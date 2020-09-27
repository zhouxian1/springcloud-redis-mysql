package com.zhouxian.service.web;


import com.zhouxian.iteminterface.entity.UserInfo;
import com.zhouxian.service.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhouxian
 * @since 2020-06-17
 */
@RestController
@RequestMapping("/userInfo")
@RefreshScope //配置刷新
public class UserInfoController {

    @Autowired
    private UserInfoServiceImpl userInfoService;
    @Value("${test.name}")
    private  String name;

    @RequestMapping("/getById")
    public UserInfo getById() throws InterruptedException {
//        Thread.sleep(2000);
        System.out.println("参数刷新为：==============》"+name);
       return userInfoService.selectById("1");
    }

}

