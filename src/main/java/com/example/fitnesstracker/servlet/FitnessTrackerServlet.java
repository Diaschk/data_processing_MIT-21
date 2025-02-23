package com.example.fitnesstracker.servlet;

import com.example.fitnesstracker.model.Tracker;
import com.example.fitnesstracker.service.FitnessTrackerService;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


@WebServlet("/pot")
public class FitnessTrackerServlet extends HttpServlet {

    private FitnessTrackerService trackerService = new FitnessTrackerService();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Tracker> trackers = trackerService.getAllTrackers();
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(trackers));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        Tracker newtracker = gson.fromJson(reader, Tracker.class);
        trackerService.addTracker(newtracker);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        Tracker updatedTracker = gson.fromJson(reader, Tracker.class);
        if (trackerService.updateTracker(updatedTracker)) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if (trackerService.deleteTracker(id)) {
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
