package com.maven.flightsproject.flights.Controller;

import com.maven.flightsproject.flights.Entities.Flight;
import com.maven.flightsproject.flights.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class SearchController {
    @Autowired
    private FlightService flightService;
    @GetMapping("/search-twoway")
    public ResponseEntity<Flight> searchFlightTwoWay(@RequestParam String departureAirport,
                                               @RequestParam String arrivalAirport,
                                               @RequestParam String departureTime,
                                               @RequestParam String returnTime){
        Flight searchedFlight =  flightService.findFlightsTwoWay(departureAirport,arrivalAirport,departureTime,returnTime);
        return new ResponseEntity<Flight>(searchedFlight, HttpStatus.OK);
    }
    @GetMapping("/search-oneway")
    public ResponseEntity<Flight> searchFlightOneWay(@RequestParam String departureAirport,
                                               @RequestParam String arrivalAirport,
                                               @RequestParam String departureTime){
        Flight searchedFlight =  flightService.findFlightsOneWay(departureAirport,arrivalAirport,departureTime);
        return new ResponseEntity<Flight>(searchedFlight, HttpStatus.OK);
    }

}
