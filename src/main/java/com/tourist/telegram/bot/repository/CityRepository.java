
package com.tourist.telegram.bot.repository;

import com.tourist.telegram.bot.model.City;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{
    
    City findFirstByCityName(String name); 
        
    List<City> deleteByCityName(String name);
    
}
