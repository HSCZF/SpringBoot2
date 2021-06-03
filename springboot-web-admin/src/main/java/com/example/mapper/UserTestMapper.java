package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bean.UserTest;

/**
 * 继承BaseMapper，就可以拥有CRUD的方法，就不需要自己写增删改查，没有的自己写
 */
public interface UserTestMapper extends BaseMapper<UserTest> {


}
