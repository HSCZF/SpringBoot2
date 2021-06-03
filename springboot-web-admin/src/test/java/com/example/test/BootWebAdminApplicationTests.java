package com.example.test;

import com.example.bean.UserTest;
import com.example.mapper.UserTestMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@SpringBootTest
public class BootWebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserTestMapper userTestMapper;


    /**
     * 测试前置条件
     */
    @DisplayName("测试前置条件")
    @Test
    void testassumptions() {
        Assumptions.assumeTrue(true, "结果不是true");
        System.out.println("111111111111111111");
    }

    @Test
    public void contextLoads() {

//   jdbcTemplate.queryForList("select * from user");
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        log.info("记录总数：{}", aLong);
        log.info("数据源类型：{}", dataSource.getClass());

    }

    @Test
    public void testUserTestMapper() {
        UserTest userTest = userTestMapper.selectById(1);
        log.info("用户信息：{}", userTest);
    }

}
