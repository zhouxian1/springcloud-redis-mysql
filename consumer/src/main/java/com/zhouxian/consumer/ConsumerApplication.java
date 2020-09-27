package com.zhouxian.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication
//@EnableEurekaClient
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringCloudApplication
@EnableFeignClients //开启feign
public class ConsumerApplication {
    public static void main(String[] args){
        SpringApplication.run(ConsumerApplication.class);
    }
}
