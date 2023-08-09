package com.example.AirlineLab_.controllers;

import com.example.AirlineLab_.repositories.FlightRepository;
import models.Flight;
import models.Passenger;
import org.springframework.aop.scope.ScopedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.FlightService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlightsAndFilters(@RequestParam (required = false, name = "destination")
                                                                    String destination{
        if (destination != null){
            return new ResponseEntity<>
                    (flightService.getFlightsByDestination(destination), HttpStatus.OK);
        }
        return new ResponseEntity(flightService.findAllFlights(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Flight>> getFlight(@PathVariable Long id){
        return new ResponseEntity(flightService.findFlight(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
        flightService.saveFlight(flight);
        return new ResponseEntity(flightService.findAllFlights(), HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> cancelFlight(@PathVariable Long id){
        flightService.cancelFlight(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping(value = "/book")
    public ResponseEntity<Long> bookPassenger(@RequestParam Long flightId, @RequestParam Long passengerId){
        flightService.bookPassengerOntoFlight(flightId, passengerId);
        return new ResponseEntity(passengerId, HttpStatus.OK);
    }

    @GetMapping("/byDestination")
    public ResponseEntity<List<Flight>> getFlightsByDestination(
            @RequestParam String destination
    ){
        boolean flightExists = flightService.doesFlightExistForDestination(destination);
        if(!flightExists){
            return new ResponseEntity(destination, HttpStatus.BAD_REQUEST);
        }
        List<Flight> flights = flightService.getFlightsByDestination(destination);
        return new ResponseEntity(flights, HttpStatus.OK);
    }






}
