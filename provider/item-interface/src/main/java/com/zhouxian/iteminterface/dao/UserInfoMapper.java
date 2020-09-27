package com.zhouxian.iteminterface.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhouxian.iteminterface.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhouxian
 * @since 2020-06-17
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
