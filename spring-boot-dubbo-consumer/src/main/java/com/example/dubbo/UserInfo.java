package com.example.dubbo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    private Long id;
    private String userName;
    private String password;
}
