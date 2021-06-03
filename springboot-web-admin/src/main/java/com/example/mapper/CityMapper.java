package com.example.mapper;

import com.example.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * 注解和不注解混合模式
 */
@Mapper
public interface CityMapper {

    @Select("select * from city where id = #{id}")
    public City getById(Long id);

    /**
     * 不使用注解模式
     * @param city
     */
    //public void insert(City city);


    /**
     * 使用注解模式，xml那边要注释掉这个接口mapper，过于复杂
     *
     * @param city
     */
    @Insert("insert into city(`name`, `state`, `country`) values (#{name}, #{state}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(City city);

}
