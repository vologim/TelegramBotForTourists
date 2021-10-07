
package com.tourist.telegram.bot.controller;

import com.tourist.telegram.bot.model.City;
import com.tourist.telegram.bot.service.impl.CityServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CityController {
    
    private final CityServiceImpl cityService;

    @Autowired
    public CityController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }
    
    @GetMapping("/cities")
    public List<City> getAllCities(){
        return cityService.getAllCity();
    }
    
    @GetMapping("/cities/{id}")
    public City getCityById(@PathVariable Integer id){
        return cityService.getById(id);
    }
    
    @GetMapping("/cities/name/{name}")
    public City getCityByName(@PathVariable String name){
        return cityService.getByCityName(name);
    }
    
    @PostMapping("/cities")
    public City saveSity(@RequestBody City city){
        cityService.save(city);
        return city;
    }
    
    @PutMapping("/cities")
    public City updateCity(@RequestBody City city){
        cityService.save(city);
        return city;
    }
    
    @DeleteMapping("/cities/{id}")
    public City deleteCityById(@PathVariable Integer id){
        City city = cityService.getById(id);
        cityService.delete(id);
        return city;
    }
    
    @DeleteMapping("/cities/name/{name}")
    public List<City> deleteCityByName(@PathVariable String name){
        return cityService.deleteAllCityName(name);
    }
}
