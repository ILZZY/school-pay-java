package com.zl.sp.service.impl;

import com.zl.sp.persistence.entity.Order;
import com.zl.sp.persistence.mapper.OrderMapper;
import com.zl.sp.service.IOrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单信息 服务实现类
 * </p>
 *
 * @author zhangliang
 * @since 2018-04-13
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
	
}
