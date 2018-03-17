package com.zl.sp.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zl.sp.bean.User;
import com.zl.sp.dao.UserMapper;

/**
 * @ClassName: MapperTest
 * @Description: 测试mapper，使用Spring的单元测试，自动注入所需的组件（需要导入Spring TestContext Framework模块）
 * @author zl
 * @date 18-03-17 8:42:19 PM
 */
//指定使用那种模块来测试
@RunWith(SpringJUnit4ClassRunner.class)
//指定配置文件的位置
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {
	/** 
	* @Fields UserMapper : 自动注入 
	*/ 
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/** 
	 * @Title: testCRUD 
	 * @date 18-03-17 8:47:23 PM
	 * @Description: TODO 
	 * @param 
	 * @return void
	 * @throws  
	 */
	@Test
	public void testCRUD() {
		System.out.println("测试开始"); 
		/*//1.创建SpringIOC容器
		ApplicationContext ioc = new ClassPathXmlApplicationContext();
		//2.从容器中获取mapper
		UserMapper umBean = ioc.getBean(UserMapper.class);*/
		//userMapper.insertSelective(new User(null,"张三", 0, 50));
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		for (int i = 0; i < 100; i++) {
			String uid = UUID.randomUUID().toString().substring(0, 5)+i;
			int gender = (uid.charAt(0)-'A')%2;
			int age = ((uid.charAt(0)-'A')*(uid.charAt(4)-'A'))%110;
			mapper.insertSelective(new User(null,uid,gender<0?-gender:gender,age<0?-age:age));			
		}
		System.out.println("测试结束");
	}
}
