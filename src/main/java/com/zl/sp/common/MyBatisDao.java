package com.zl.sp.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * <p>标识访问数据库的DAO</p>
 * <pre>
 * 方便{@link org.mybatis.spring.mapper.MapperScannerConfigurer}的扫描。
 * <pre>
 * @className: MyBatisDao
 * @description: TODO
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
@MapperScan
public @interface MyBatisDao {
	String value() default "";
}