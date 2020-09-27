package com.zhouxian.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhouxian.consumer.client.UserInfoClient;
import com.zhouxian.consumer.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.hypermedia.DiscoveredResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@RequestMapping("/test")
@Slf4j
//@DefaultProperties(defaultFallback = "defaultFunction")
public class TestController {

    @Autowired
    private UserInfoClient userInfoClient;

    @RequestMapping("/get")
//    @HystrixCommand(defaultFallback = "defaultFunction")
//    @HystrixCommand(commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="500")})
    public UserInfo get(){
        return  userInfoClient.get();
    }


    @GetMapping("/getById")
    UserInfo getById(){
            return  userInfoClient.get();
    }

//    public  String defaultFunction(){
//        return "sadasd";
//    }
}
