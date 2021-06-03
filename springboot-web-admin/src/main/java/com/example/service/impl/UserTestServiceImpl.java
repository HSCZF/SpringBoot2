package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bean.UserTest;
import com.example.mapper.UserTestMapper;
import com.example.service.UserTestService;
import org.springframework.stereotype.Service;


@Service
public class UserTestServiceImpl extends ServiceImpl<UserTestMapper, UserTest> implements UserTestService {


}
