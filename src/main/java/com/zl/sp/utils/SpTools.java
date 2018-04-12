/**   
 * @Title: SpTools.java 
 * @Package com.zl.sp.utils 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zl   
 * @date Mar 29, 2018 9:30:42 PM 
 * @version V1.0  
 */
package com.zl.sp.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

/** 
 * @ClassName: SpTools 
 * @Description: TODO 
 * @author zl
 * @date 18-04-05 9:30:37 AM
 */
public class SpTools {

	/**
	 * 对象是否不为空
	 */
	public static boolean isNotEmpty(Object o) {
		return !isEmpty(o);
	}

	/**
	 * 判断对象是否为空 包括 字符串、对象、集合 isEmpty
	 */
	public static boolean isEmpty(Object o) {
		if (o == null) {
			return true;
		}
		if (o instanceof String) {
			if (o.toString().trim().equals("")) {
				return true;
			}
		} else if (o instanceof List) {
			if (((List) o).size() == 0) {
				return true;
			}
		} else if (o instanceof Map) {
			if (((Map) o).size() == 0) {
				return true;
			}
		} else if (o instanceof Set) {
			if (((Set) o).size() == 0) {
				return true;
			}
		} else if (o instanceof Object[]) {
			if (((Object[]) o).length == 0) {
				return true;
			}
		} else if (o instanceof int[]) {
			if (((int[]) o).length == 0) {
				return true;
			}
		} else if (o instanceof long[]) {
			if (((long[]) o).length == 0) {
				return true;
			}
		} else if (o instanceof float[]) {
			if (((float[]) o).length == 0) {
				return true;
			}
		} else if (o instanceof double[]) {
			if (((double[]) o).length == 0) {
				return true;
			}
		}
		return false;
	}
	
	public static <T> EntityWrapper<T> createEntityWrapper() {
        return new EntityWrapper<T>();
    }

    public static <T> EntityWrapper<T> createEntityWrapper(T enty) {
        return new EntityWrapper<T>(enty);
    }
	
	/**
     * 通过BO创建 EntityWrapper
     * 
     * @param bo
     *            业务BO
     * @param entyClz
     *            实体Bean Class
     * @return EntityWrapper
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <BO, ENTY extends Model<ENTY>> EntityWrapper<ENTY> createEntityWrapper(BO bo, Class<ENTY> entyClz) {

        if (null == bo) {
            return createEntityWrapper();
        }

        Class boClz = (Class) bo.getClass();
        ENTY enty = (ENTY) BeanMapper.map(bo, BeanMapper.getType(boClz), BeanMapper.getType(entyClz));
        return createEntityWrapper(enty);
    }
	
}
