package com.example.service;

import com.example.bean.City;

public interface CityService {

    public City getCityById(Long id);

    public void saveCity(City city);

}
