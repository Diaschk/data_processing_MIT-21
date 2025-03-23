package com.example.catalog.repository;

import com.example.catalog.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "destinations")
public interface DestinationRepository extends JpaRepository<Destination, Long> {}
