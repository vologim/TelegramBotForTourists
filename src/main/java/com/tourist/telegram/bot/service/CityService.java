
package com.tourist.telegram.bot.service;

import com.tourist.telegram.bot.model.City;
import java.util.List;

public interface CityService {
    
    List<City> getAllCity();
    
    City getById(Integer id);
    
    City getByCityName(String name);
    
    void save(City city);
    
    void delete(Integer id);
    
    List<City> deleteAllCityName(String name);

}
