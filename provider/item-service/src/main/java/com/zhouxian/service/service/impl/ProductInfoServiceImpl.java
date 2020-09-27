package com.zhouxian.service.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhouxian.iteminterface.dao.ProductInfoMapper;
import com.zhouxian.iteminterface.entity.ProductInfo;
import com.zhouxian.service.service.ProductInfoService;
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
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {

}
