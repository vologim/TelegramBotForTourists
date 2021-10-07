
package com.tourist.telegram.bot.service.impl;

import com.tourist.telegram.bot.model.City;
import com.tourist.telegram.bot.repository.CityRepository;
import com.tourist.telegram.bot.service.CityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityServiceImpl implements CityService{
    
    private final CityRepository repository;

    @Autowired
    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<City> getAllCity() {
        return repository.findAll();
    }
    
    @Override
    public City getByCityName(String name) {
        return repository.findFirstByCityName(name);
    }
    
    @Override
    public City getById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(City city) {
        repository.save(city);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<City> deleteAllCityName(String name) {
        return repository.deleteByCityName(name);
    }
    
}
