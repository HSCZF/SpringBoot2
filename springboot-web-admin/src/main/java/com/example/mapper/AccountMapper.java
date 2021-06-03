package com.example.mapper;

import com.example.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    public Account getAccount(Integer id);

}
