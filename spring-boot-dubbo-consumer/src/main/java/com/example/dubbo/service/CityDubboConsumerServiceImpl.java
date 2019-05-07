package com.example.dubbo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.dubbo.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class CityDubboConsumerServiceImpl implements CityDubboConsumerService {
    @Reference
    private UserInfoService userInfoService;

    @Override
    public UserInfo saveUser(UserInfo userInfo) {
        UserInfo userInfo1 = userInfoService.saveUserInfo(userInfo);
        return userInfo1;
    }
}
