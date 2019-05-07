package com.example.dubbo;

import com.alibaba.fastjson.JSONObject;
import com.example.dubbo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class DubboServerApplication {

    public static AtomicLong atomicInteger = new AtomicLong();
    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboServerApplication.class)
                .run(args);
    }

    @RequestMapping("/save01")
    public String save01(UserInfo userInfo){
        userInfo.setId(atomicInteger.getAndIncrement());
        userInfo.setUserName("bbbbb");
        userInfo.setPassword(UUID.randomUUID().toString());
        System.out.println("save user: {}"+ JSONObject.toJSONString(userInfo));
        return JSONObject.toJSONString(userInfo);
    }

}
