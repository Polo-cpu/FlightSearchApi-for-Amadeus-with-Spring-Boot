package com.maven.flightsproject.flights.Services;

import com.maven.flightsproject.flights.Entities.City;
import com.maven.flightsproject.flights.Repository.ICityDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private ICityDal cityDal;

    public CityService(ICityDal cityDal){
        this.cityDal = cityDal;
    }
    public City addCity(City city){
        return cityDal.save(city);
    }
    public List<City> findAllCities(){
        return cityDal.findAll();
    }

    public City getCityById(long cityId){
        return cityDal.findById(cityId).get();
    }

    public void deleteCityById(long cityId){
        cityDal.deleteById(cityId);
    }
    public void deleteCityByName(City city){
        cityDal.delete(city);
    }


}
