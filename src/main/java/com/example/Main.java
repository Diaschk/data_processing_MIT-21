package com.example;

import com.example.model.Destination;
import com.example.repository.DestinationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final DestinationRepository destinationRepository;

    public Main(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {

        Destination destination = new Destination("Балі", "Балі радує туристів первозданною природою", "image_url");
        destinationRepository.save(destination);
        System.out.println("Туристичне місце додано: " + destination);


        List<Destination> destinations = destinationRepository.findAll();
        System.out.println("Список туристичних місць: " + destinations);


        destination.setName("Оновлено Балі");
        destinationRepository.save(destination);
        System.out.println("Оновлене туристичне місце: " + destination);


        destinationRepository.deleteById(destination.getId());
        System.out.println("Туристичне місце видалене");
    }
}
