/**   
 * @Title: zlTest.java 
 * @Package com.zl.sp.test 
 * @Description: TODO(��һ�仰�������ļ���ʲô) 
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
		// TODO �Զ����ɵķ������
		Student aStudent = new Student("����");
		aStudent.setName("����");
		System.out.println(aStudent.getName());
		
		String str = new String("11");
		str=null;
		System.out.println(str);
	}

}
