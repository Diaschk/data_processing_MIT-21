package controller;

import model.Destination;
import repository.DestinationRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {
    @Autowired
    private DestinationRepository destinationRepository;

    @GetMapping
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    @PostMapping
    public Destination createDestination(@RequestBody Destination destination) {
        return destinationRepository.save(destination);
    }

    @PutMapping("/{id}")
    public Destination updateDestination(@PathVariable Long id, @RequestBody Destination destinationDetails) {
        Destination destination = destinationRepository.findById(id).orElseThrow();
        destination.setName(destinationDetails.getName());
        destination.setDescription(destinationDetails.getDescription());
        destination.setImageUrl(destinationDetails.getImageUrl());
        return destinationRepository.save(destination);
    }

    @DeleteMapping("/{id}")
    public void deleteDestination(@PathVariable Long id) {
        destinationRepository.deleteById(id);
    }
}