
package com.tourist.telegram.bot.service;

import com.tourist.telegram.bot.model.City;
import java.util.List;

public interface CityService {
    
    City getById(Integer id);
    
    List<City> getByNameRus(String name);
    
    List<City> getByNameEng(String name);
    
    void save(City city);
    
    void delete(Integer id);
    
    City deleteByNameRus(String name);
    
    City deleteByNameEng(String name);
}
