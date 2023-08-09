package services;

import com.example.AirlineLab_.repositories.FlightRepository;
import com.example.AirlineLab_.repositories.PassengerRepository;
import models.Flight;
import models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    PassengerService passengerService;

    public Flight findFlight(Long id){return (Flight) flightRepository.findById(id).get();}

    public List<Flight> findAllFlights(){
        return flightRepository.findAll();
    }

    public void saveFlight(Flight flight){flightRepository.save(flight); }

    public void addFlight(Long id){}

    public List<Flight> getFlightsByDestination(String destination){
        return flightRepository.filterFlightsByDestination(destination);
    }

    public void cancelFlight(Long id){
        flightRepository.deleteById(id);
    }

    public boolean bookPassengerOntoFlight(Long flightId, Long passengerId){
        Optional<Flight> foundFlight = flightRepository.findById(flightId);
        Optional<Passenger> newPassenger = passengerRepository.findById(passengerId);
        Flight flight = foundFlight.get();
        Passenger passenger = newPassenger.get();

        //check if flight is full
        if(flight.getPassengers().size() >= flight.getCapacity()){
            return false;
        }
        flight.getPassengers().add(passenger);
        flightRepository.save(flight);
        return true;

    }

    public boolean doesFlightExistForDestination(String destination){
        List<Flight> flights = flightRepository.findByDestination(destination);
        return !flights.isEmpty();
    }


}
