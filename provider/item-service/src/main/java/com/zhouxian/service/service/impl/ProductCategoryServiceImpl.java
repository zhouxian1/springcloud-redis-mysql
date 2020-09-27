package com.zhouxian.service.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhouxian.iteminterface.dao.ProductCategoryMapper;
import com.zhouxian.iteminterface.entity.ProductCategory;
import com.zhouxian.service.service.ProductCategoryService;
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
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

}
