# Використовуємо образ OpenJDK для Spring Boot
FROM openjdk:21-jdk-slim

# Вказуємо робочий каталог
WORKDIR /app

# Копіюємо jar-файл у контейнер
COPY target/*.jar app.jar

# Вказуємо команду для запуску Spring Boot застосунку
ENTRYPOINT ["java", "-jar", "app.jar"]

# Відкриваємо порт 8084
EXPOSE 8084

