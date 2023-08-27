package com.maven.flightsproject.flights.Repository;

import com.maven.flightsproject.flights.Entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityDal extends JpaRepository<City,Long> {

}
