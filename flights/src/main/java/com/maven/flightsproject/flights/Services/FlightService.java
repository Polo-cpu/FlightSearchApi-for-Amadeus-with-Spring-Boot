package com.maven.flightsproject.flights.Services;

import com.maven.flightsproject.flights.Entities.Flight;
import com.maven.flightsproject.flights.FlightsApplication;
import com.maven.flightsproject.flights.Repository.IFlightDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class FlightService {
    @Autowired
    private IFlightDal flightDal;
    private final String apiUrl = "https://localhost:8080/flight/api/flights";
    public FlightService(IFlightDal flightDal){
        this.flightDal = flightDal;
    }

    @Scheduled(cron = "0 0 * * * *")
    public void saveFlightData(){
        RestTemplate restTemplate = new RestTemplate();
        FlightsApplication response = restTemplate.getForObject(apiUrl,FlightsApplication.class);
    }



    public Flight findFlightsTwoWay(String departureAirport, String arrivalAirport, String departureTime, String returnTime){
        Flight myFlightObject = new Flight();
        Flight mySearchFlight = new Flight();
        mySearchFlight.setDepartureAirport(departureAirport);
        mySearchFlight.setArrivalAirport(arrivalAirport);
        mySearchFlight.setDepartureTime(departureTime);
        mySearchFlight.setReturnTime(returnTime);
        List<Flight> allFlights = findAllFlights();
        for (Flight x : allFlights
             ) {
            if(Objects.equals(x.getDepartureAirport(), mySearchFlight.getDepartureAirport()) &&
                    Objects.equals(x.getArrivalAirport(), mySearchFlight.getArrivalAirport()) &&
                    Objects.equals(x.getDepartureTime(), mySearchFlight.getDepartureTime()) &&
                    Objects.equals(x.getReturnTime(), mySearchFlight.getReturnTime())){
                myFlightObject = x;
            }
            else {
                myFlightObject = null;
            }

        }
        return myFlightObject;
    }
    public Flight findFlightsOneWay(String departureAirport, String arrivalAirport, String departureTime){
        Flight myFlightObject = new Flight();
        Flight mySearchFlight = new Flight();
        mySearchFlight.setDepartureAirport(departureAirport);
        mySearchFlight.setArrivalAirport(arrivalAirport);
        mySearchFlight.setDepartureTime(departureTime);
        mySearchFlight.setReturnTime(null);
        List<Flight> allFlights = findAllFlights();
        for (Flight x : allFlights
        ) {
            if(Objects.equals(x.getDepartureAirport(), mySearchFlight.getDepartureAirport()) &&
                    Objects.equals(x.getArrivalAirport(), mySearchFlight.getArrivalAirport()) &&
                    Objects.equals(x.getDepartureTime(), mySearchFlight.getDepartureTime()) &&
                    Objects.equals(x.getReturnTime(), mySearchFlight.getReturnTime())){
                double newCost = x.getCost()/2;
                mySearchFlight.setCost(newCost);
                myFlightObject = x;
            }
            else {
                myFlightObject = null;
            }

        }
        return myFlightObject;
    }
    public Flight addFlight(Flight flight){
        return flightDal.save(flight);
    }
    public List<Flight> findAllFlights(){
        return flightDal.findAll();
    }
    public Flight getFlightById(long flightId){
        return flightDal.findById(flightId).get();
    }

    public void deleteFlightById(long flightId){
        flightDal.deleteById(flightId);
    }
    public void deleteFlightByName(Flight flight){
        flightDal.delete(flight);
    }
}
