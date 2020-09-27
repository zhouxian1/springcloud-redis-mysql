package com.zhouxian.consumer.client;

import com.zhouxian.consumer.config.FeignConfig;
import com.zhouxian.consumer.entity.UserInfo;
import com.zhouxian.consumer.fallback.UserInfoFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "provider-server",fallback = UserInfoFallback.class,configuration = FeignConfig.class)
public interface UserInfoClient {
    @GetMapping("/userInfo/getById")
    UserInfo get();
}
