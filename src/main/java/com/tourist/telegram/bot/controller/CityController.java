
package com.tourist.telegram.bot.controller;

import com.tourist.telegram.bot.model.City;
import com.tourist.telegram.bot.service.impl.CityServiceImpl;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    
    @GetMapping("/city/{id}")
    public City getCityById(@PathVariable Integer id){
        return cityService.getById(id);
    }
    
    @GetMapping("/city/name/{name}")
    public List<City> getCityByNameRus(@PathVariable String name){
        String regexEng = "[a-zA-Z]+";
        Pattern pattern = Pattern.compile(regexEng);
        Matcher matcher = pattern.matcher(name);
        
        if(matcher.find()){
            return cityService.getByNameEng(name);
        }
        return cityService.getByNameRus(name);
    }
    
    @PostMapping("/city")
    public City saveSity(@RequestBody City city){
        cityService.save(city);
        return city;
    }
    
    @PutMapping("/city")
    public City updateCity(@RequestBody City city){
        cityService.save(city);
        return city;
    }
    
    @DeleteMapping("/city/{id}")
    public City deleteCityById(@PathVariable Integer id){
        City city = cityService.getById(id);
        cityService.delete(id);
        return city;
    }
    
    @DeleteMapping("/city/name/{name}")
    public List<City> deleteCityByName(@PathVariable String name){
        String regexEng = "[a-zA-Z]+";
        Pattern pattern = Pattern.compile(regexEng);
        Matcher matcher = pattern.matcher(name);
        
        if(matcher.find()){
            return cityService.deleteAllNameEng(name);
        }
        return cityService.deleteAllNameRus(name);
    }
}
