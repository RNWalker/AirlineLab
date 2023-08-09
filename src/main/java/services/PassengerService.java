package services;

import com.example.AirlineLab_.repositories.FlightRepository;
import com.example.AirlineLab_.repositories.PassengerRepository;
import models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public List<Passenger> findAllPassengers(){
        return passengerRepository.findAll();
    }

    public Passenger findPassenger(Long id){
        return (Passenger) passengerRepository.findById(id).get();
    }

    public void savePassenger(Passenger passenger){
        passengerRepository.save(passenger);}
}


