package com.maven.flightsproject.flights.Repository;

import com.maven.flightsproject.flights.Entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightDal extends JpaRepository<Flight, Long> {

}
