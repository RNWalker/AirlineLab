package com.example.AirlineLab_.components;

import com.example.AirlineLab_.repositories.FlightRepository;
import com.example.AirlineLab_.repositories.PassengerRepository;
import models.Flight;
import models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader(){}

    @Override

public void run(ApplicationArguments args) throws Exception {

        //Plane to Spain
        Flight planeToSpain = new Flight("Spain", LocalDate.of(2023, 8, 15), LocalTime.of(15, 30, 0));
        flightRepository.save(planeToSpain);

        Passenger rebecca = new Passenger("Rebecca", "rebeccaflies@gmail.com");
        rebecca.addFlight(planeToSpain);
        passengerRepository.save(rebecca);

        Passenger ollie = new Passenger("Ollie", "ollieflies@gmail.com");
        ollie.addFlight(planeToSpain);
        passengerRepository.save(ollie);

        //Plane to Italy
        Flight planeToItaly = new Flight("Italy", LocalDate.of(2023, 8, 23), LocalTime.of(12, 0));
        flightRepository.save(planeToItaly);

        Passenger ben = new Passenger("Ben", "benflies@gmail.com");
        ben.addFlight(planeToItaly);
        passengerRepository.save(ben);

        Passenger grace = new Passenger("Grace", "graceflies@gmail.com");
        grace.addFlight(planeToItaly);
        passengerRepository.save(grace);

        //Plane to Hungary
        Flight planeToHungary = new Flight("Hungary", LocalDate.of(2023, 8, 19), LocalTime.of(10, 0));
        flightRepository.save(planeToHungary);

        Passenger phil = new Passenger("Phil", "philflies@gmail.com");
        phil.addFlight(planeToHungary);
        passengerRepository.save(phil);

        Passenger anna = new Passenger("Anna", "annaflies@gmail.com");
        anna.addFlight(planeToHungary);
        passengerRepository.save(anna);

        //Can't stop going on holiday
        Passenger karina = new Passenger("Karina", "karinaflies@gmail.com");
        karina.addFlight(planeToSpain);
        karina.addFlight(planeToItaly);
        passengerRepository.save(karina);

        Passenger freddy = new Passenger("Freddy", "freddyflies@gmail.com");
        freddy.addFlight(planeToSpain);
        freddy.addFlight(planeToHungary);
        passengerRepository.save(freddy);


    }

}
