
package com.tourist.telegram.bot.repository;

import com.tourist.telegram.bot.model.City;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer>{
    
    List<City> findByNameRus(String name); 
    
    List<City> findByNameEng(String name); 
    
    City deleteByNameRus(String name);
    
    City deleteByNameEng(String name);
}
