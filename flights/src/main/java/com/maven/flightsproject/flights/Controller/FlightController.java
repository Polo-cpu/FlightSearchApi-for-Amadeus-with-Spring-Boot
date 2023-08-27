package com.maven.flightsproject.flights.Controller;

import com.maven.flightsproject.flights.Entities.Flight;
import com.maven.flightsproject.flights.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight/api")
public class FlightController {
    @Autowired
    private FlightService flightService;
    @PostMapping("/save")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
        Flight addFlights = flightService.addFlight(flight);
        return new ResponseEntity<Flight>(addFlights, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Flight>> getAllFlights(){
        List<Flight> allFlights = flightService.findAllFlights();
        return new ResponseEntity<List<Flight>>(allFlights,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightId(@PathVariable("id") Long id){
        Flight flightById = flightService.getFlightById(id);
        return new ResponseEntity<Flight>(flightById,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlightById(@PathVariable("id") Long id){
        flightService.deleteFlightById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
