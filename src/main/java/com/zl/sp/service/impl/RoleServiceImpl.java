package com.zl.sp.service.impl;

import com.zl.sp.persistence.entity.Role;
import com.zl.sp.persistence.mapper.RoleMapper;
import com.zl.sp.service.IRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author zhangliang
 * @since 2018-04-17
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
	
}
