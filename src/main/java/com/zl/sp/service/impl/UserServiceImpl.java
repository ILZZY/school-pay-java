package com.zl.sp.service.impl;

import com.zl.sp.persistence.entity.User;
import com.zl.sp.persistence.mapper.UserMapper;
import com.zl.sp.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zhangliang
 * @since 2018-04-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
}
