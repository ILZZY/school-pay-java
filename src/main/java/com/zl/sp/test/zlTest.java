/**   
 * @Title: zlTest.java 
 * @Package com.zl.sp.test 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zl   
 * @date Mar 17, 2018 9:14:36 PM 
 * @version V1.0  
 */
package com.zl.sp.test;

/** 
 * @ClassName: zlTest 
 * @Description: TODO 
 * @author zl
 * @date 18-03-17 9:14:36 PM
 */
class Student{
	private String name;
	
	public Student() {
		super();
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
public class zlTest {
	/** 
	 * @Title: main 
	 * @date 18-03-17 9:14:36 PM
	 * @Description: TODO 
	 * @param @param args
	 * @return void
	 * @throws  
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Student aStudent = new Student("张三");
		aStudent.setName("李四");
		System.out.println(aStudent.getName());
		
		String str = new String("11");
		str=null;
		System.out.println(str);
	}

}
