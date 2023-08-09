package com.example.AirlineLab_.repositories;

import models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository {

    List<Flight> filterFlightsByDestination(String destination);

    List<Flight> findByDestination (String destination);
}
