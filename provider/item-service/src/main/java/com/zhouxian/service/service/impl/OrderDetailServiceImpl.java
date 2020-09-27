package com.zhouxian.service.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhouxian.iteminterface.dao.OrderDetailMapper;
import com.zhouxian.iteminterface.entity.OrderDetail;
import com.zhouxian.service.service.OrderDetailService;
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
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}
