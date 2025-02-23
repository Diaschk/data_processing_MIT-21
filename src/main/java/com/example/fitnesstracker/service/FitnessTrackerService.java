package com.example.fitnesstracker.service;

import com.example.fitnesstracker.model.Tracker;
import com.example.fitnesstracker.utils.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FitnessTrackerService {
    private static final String FILE_PATH = "src/main/resources/data.json";
    private List<Tracker> trackers;

    public FitnessTrackerService() {
        trackers = loadTrackers();
    }

    public List<Tracker> getAllTrackers() {
        return trackers;
    }

    public void addTracker(Tracker tracker) {
        int newId = trackers.isEmpty() ? 1 : trackers.get(trackers.size() - 1).getId() + 1;
        tracker.setId(newId);
        trackers.add(tracker);
        saveTrackers();
    }


    public boolean updateTracker(Tracker updatedTracker) {
        for (int i = 0; i < trackers.size(); i++) {
            if (trackers.get(i).getId() == updatedTracker.getId()) {
                trackers.set(i, updatedTracker);
                saveTrackers();
                return true;
            }
        }
        return false;
    }

    public boolean deleteTracker(int id) {
        boolean removed = trackers.removeIf(p -> p.getId() == id);
        if(removed) saveTrackers();
       return removed;
    }


    private List<Tracker> loadTrackers() {
        try {
            String json = FileUtil.readFromFile(FILE_PATH);
            return new Gson().fromJson(json, new TypeToken<List<Tracker>>() {} .getType());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void saveTrackers() {
        try {
            String json = new Gson().toJson(trackers);
            FileUtil.writeToFile(FILE_PATH, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
