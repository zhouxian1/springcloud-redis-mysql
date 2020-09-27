package com.zhouxian.consumer.fallback;

import com.zhouxian.consumer.client.UserInfoClient;
import com.zhouxian.consumer.entity.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class UserInfoFallback implements UserInfoClient {
    @Override
    public UserInfo get() {
        UserInfo userInfo=new UserInfo();
        userInfo.setId("1");
        userInfo.setUsername("用户异常！");
        return userInfo;
    }
}
