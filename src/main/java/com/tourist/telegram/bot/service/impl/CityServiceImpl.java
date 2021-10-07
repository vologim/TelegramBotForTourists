
package com.tourist.telegram.bot.service.impl;

import com.tourist.telegram.bot.model.City;
import com.tourist.telegram.bot.repository.CityRepository;
import com.tourist.telegram.bot.service.CityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService{
    
    private final CityRepository repository;

    @Autowired
    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    
    @Override
    public City getById(Integer id) {
        return repository.findById(id).get();
    }
    
    @Override
    public List<City> getByNameRus(String name) {
        return repository.findByNameRus(name);
    }
    
    @Override
    public List<City> getByNameEng(String name) {
        return repository.findByNameEng(name);
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
    public City deleteByNameRus(String name) {
        return repository.deleteByNameRus(name);
    }

    @Override
    public City deleteByNameEng(String name) {
        return repository.deleteByNameEng(name);
    }
    
}
