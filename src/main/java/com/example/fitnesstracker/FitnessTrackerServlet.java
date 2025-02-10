package com.example.fitnesstracker;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import java.io.IOException;

@WebServlet("/pot")
public class FitnessTrackerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Pots pots = new Pots("Apple Watch", "pot.jpg", "Smartwatch with fitness tracking features", 399.99, "Heart rate monitor, GPS, Waterproof");

        Gson gson = new Gson();
        String json = gson.toJson(pots);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
