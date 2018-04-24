package com.zl.sp.service.impl;

import com.zl.sp.persistence.entity.Resource;
import com.zl.sp.persistence.mapper.ResourceMapper;
import com.zl.sp.service.IResourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangliang
 * @since 2018-04-24
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {
	
}
