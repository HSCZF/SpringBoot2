package com.example.service.impl;

import com.example.bean.Account;
import com.example.mapper.AccountMapper;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public Account getAccountById(Integer id) {
        return accountMapper.getAccount(id);
    }


}
