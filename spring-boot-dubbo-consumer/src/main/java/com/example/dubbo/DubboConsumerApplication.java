package com.example.dubbo;

import com.alibaba.fastjson.JSONObject;
import com.example.dubbo.service.CityDubboConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@SpringBootApplication
@RestController
@Slf4j
public class DubboConsumerApplication {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CityDubboConsumerService cityDubboConsumerService;

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

    @RequestMapping("/save_user")
    public String saveUser() {
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserName("bbbbb");
        userInfo1.setPassword(UUID.randomUUID().toString());
        UserInfo userInfo = cityDubboConsumerService.saveUser(userInfo1);
        log.info("消费端收到的返回信息：{}", JSONObject.toJSONString(userInfo));
        return JSONObject.toJSONString(userInfo);
    }

    @RequestMapping("/save01")
    public String save01() {
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserName("bbbbb");
        userInfo1.setPassword(UUID.randomUUID().toString());

        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:8080/save01", userInfo1, String.class);
        return stringResponseEntity.getBody();
    }

}
