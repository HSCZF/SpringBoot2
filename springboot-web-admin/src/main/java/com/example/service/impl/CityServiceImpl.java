package com.example.service.impl;


import com.example.bean.City;
import com.example.mapper.CityMapper;
import com.example.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;

    @Override
    public City getCityById(Long id) {
        return cityMapper.getById(id);
    }

    @Override
    public void saveCity(City city) {
        cityMapper.insert(city);
    }

}
