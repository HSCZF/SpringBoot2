package com.example.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    /* 阿里druid账号+密码 */
    private String userName;
    private String password;

}
