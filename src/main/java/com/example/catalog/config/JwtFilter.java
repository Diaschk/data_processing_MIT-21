package com.example.catalog.config;

import com.example.catalog.service.JwtService;
import com.example.catalog.service.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String username;

        // Якщо заголовок Authorization відсутній або не починається з "Bearer ", пропускаємо фільтрацію
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Витягуємо токен з заголовку
        jwt = authHeader.substring(7);
        username = jwtService.extractUsername(jwt);

        // Якщо ім'я користувача є, але аутентифікація ще не виконана
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            try {
                // Завантажуємо користувача
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                // Перевіряємо валідність токена
                if (jwtService.isTokenValid(jwt, userDetails.getUsername())) {
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    // Встановлюємо аутентифікацію в контекст
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                    log.info("✅ JWT авторизація успішна для користувача: {}", username);
                } else {
                    // Якщо токен недійсний, повертаємо 401
                    log.warn("❌ Недійсний токен для користувача: {}", username);
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or expired JWT token");
                    return;
                }
            } catch (Exception e) {
                // Якщо сталася помилка, повертаємо 401
                log.error("❌ Помилка при обробці JWT токена: {}", e.getMessage());
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or expired JWT token");
                return;
            }
        }

        // Продовжуємо фільтрацію
        filterChain.doFilter(request, response);
    }
}
