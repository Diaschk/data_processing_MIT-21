package com.example.catalog.controller;

import com.example.catalog.model.Destination;
import com.example.catalog.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("destinations")
public class DestinationController {


    @Autowired
    private DestinationRepository destinationRepository;

    @GetMapping
    public String listDestinations(Model model) {
        model.addAttribute("destinations", destinationRepository.findAll());
        return "destination-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("destination", new Destination());
        return "destination-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Destination destination = destinationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Невірний ID туристичного місця: " + id));
        model.addAttribute("destination", destination);
        return "destination-form";
    }

    @PostMapping("/save")
    public String saveDestination(@ModelAttribute("destination") Destination destination) {
        destinationRepository.save(destination);
        return "redirect:/destinations";
    }


    @GetMapping("/delete/{id}")
    public String deleteDestination(@PathVariable Long id) {
        destinationRepository.deleteById(id);
        return "redirect:/destinations";
    }

}
