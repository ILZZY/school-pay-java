/**   
 * @Title: BeanMapper.java 
 * @Package com.zl.sp.utils 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zl   
 * @date Mar 29, 2018 10:18:27 PM 
 * @version V1.0  
 */
package com.zl.sp.utils;

import java.util.List;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeFactory;

/**
 * @ClassName: BeanMapper
 * @Description: TODO
 * @author zl
 * @date 18-03-29 10:18:27 PM
 */
public class BeanMapper {
	private static MapperFacade mapper;

	// 建议优先使用MapperFactory,当mapper被使用后，会被缓存起来 TKing
	private static MapperFactory mapperFactory;

	static {
		mapperFactory = new DefaultMapperFactory.Builder().build();
		// 如果有特定的类型映射对需要被转换建议使用BoundMapperFacade,比默认的MapperFacade有更高的性能 TKing
		mapper = mapperFactory.getMapperFacade();
	}

	/**
	 * 简单的复制出新类型对象.
	 * 
	 * @param source
	 *            源对象
	 * @param destinationClass
	 *            转换目标Class
	 * @return
	 */
	public static <S, D> D map(S source, Class<D> destinationClass) {
		return mapper.map(source, destinationClass);
	}

	/**
	 * 简单的复制出新对象列表到ArrayList 不建议使用mapper.mapAsList(Iterable<S>,Class<D>)接口 mapList
	 * 
	 * @param sourceList
	 *            源list
	 * @param sourceClass
	 *            源对象Class
	 * @param destinationClass
	 *            目标对象 Class
	 * @return
	 */
	public static <S, D> List<D> mapList(Iterable<S> sourceList, Class<S> sourceClass, Class<D> destinationClass) {
		return mapper.mapAsList(sourceList, TypeFactory.valueOf(sourceClass), TypeFactory.valueOf(destinationClass));
	}

	/**
	 * 预先获取orika转换所需要的Type，避免每次转换. getType
	 * 
	 * @param rawType
	 * @return
	 */
	public static <E> Type<E> getType(final Class<E> rawType) {
		return TypeFactory.valueOf(rawType);
	}

	/**
	 * 极致性能的复制出新类型对象. 预先通过BeanMapper.getType() 静态获取并缓存Type类型，在此处传入 map
	 * 
	 * @param source
	 *            源对象
	 * @param sourceType
	 *            源对象Type
	 * @param destinationType
	 *            转换目标Type
	 * @return
	 */
	public static <S, D> D map(S source, Type<S> sourceType, Type<D> destinationType) {
		return mapper.map(source, sourceType, destinationType);
	}

}
