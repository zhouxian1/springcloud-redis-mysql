package com.zhouxian.service.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhouxian.iteminterface.dao.UserInfoMapper;
import com.zhouxian.iteminterface.entity.UserInfo;
import com.zhouxian.service.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouxian
 * @since 2020-06-17
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
