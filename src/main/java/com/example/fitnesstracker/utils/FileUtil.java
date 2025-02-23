package com.example.fitnesstracker.utils;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
    public static String readFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
    public static void writeToFile(String filePath, String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        }
    }
}
