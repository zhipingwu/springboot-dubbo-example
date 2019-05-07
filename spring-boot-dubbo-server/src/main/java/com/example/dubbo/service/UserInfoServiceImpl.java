package com.example.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.example.dubbo.UserInfo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wuzhiping
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    public static AtomicLong atomicInteger = new AtomicLong();
    @Override
    public UserInfo saveUserInfo(UserInfo userInfo) {
        userInfo.setId(atomicInteger.getAndIncrement());
        System.out.println("save user: {}"+ JSONObject.toJSONString(userInfo));
        return userInfo;
    }
}
