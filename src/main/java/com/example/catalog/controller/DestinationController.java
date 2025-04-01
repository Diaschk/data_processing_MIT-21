package com.example.catalog.controller;

import com.example.catalog.model.Destination;
import com.example.catalog.repository.DestinationRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation .*;

import java.util.List;

    @Slf4j
    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/api/destinations")
    public class DestinationController {
        private final DestinationRepository destinationRepository;

        @Operation(summary = "Отримати всі туристичні місця")
        @GetMapping
        public List<Destination> getAllDestinations() {
            log.info("GET /api/destinations - отримати всі туристичні місця");
            return destinationRepository.findAll();
        }

        @Operation(summary = "Отримати туристичне місце по ID")
        @GetMapping("/{id}")
        public Destination getDestinationById(@PathVariable Long id) {
            log.info("GET /api/destinations/{} - отримати туристичне місце", id);
            return destinationRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Туристичне місце не знайдено"));
        }


        @Operation(summary = "Створити нове туристичне місце")
        @PostMapping
        public Destination createDestination(@RequestBody Destination destination) {
            log.info("POST /api/destinations - створити туристичне місце: {}", destination.getName());
            return destinationRepository.save(destination);
        }

        @Operation(summary = "Оновити туристичне місце за ID")
        @PutMapping("/{id}")
        public ResponseEntity<Destination> updateDestination(
                @PathVariable Long id,
                @RequestBody Destination destinationDetails) {
            log.info("PUT /api/destinations/{} - запит на оновлення туристичного місця", id);

            return destinationRepository.findById(id)
                    .map(existingDestination -> {
                        updateDestinationFields(existingDestination,destinationDetails);
                        Destination updated = destinationRepository.save(existingDestination);
                        log.info("Туристичне місце з ID={} успішно оновлено", id);
                        return ResponseEntity.ok(updated);
                    })

                    .orElseGet(() -> {
                        log.warn("Туристичне місце з ID={} не знайдено для оновлення", id);
                        return ResponseEntity.notFound().build();
                    });
        }

        private void updateDestinationFields(Destination target, Destination source) {
            target.setName(source.getName());
            target.setDescription(source.getDescription());
            target.setImageUrl(source.getImageUrl());
        }
        @Operation(summary = "Видалити туристичне місце")
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteDestination(@PathVariable Long id) {
            log.warn("DELETE /api/destinations/{} - видалити туристичне місце", id);

            if (destinationRepository.existsById(id)) {
                destinationRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                log.warn("Туристичне місце з ID={} не знайдено", id);
                return ResponseEntity.notFound().build();
            }
        }

    }

