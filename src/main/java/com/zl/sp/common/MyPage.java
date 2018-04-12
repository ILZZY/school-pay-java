/**   
 * @Title: Page.java 
 * @Package com.zl.sp.common 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zl   
 * @date Apr 5, 2018 9:03:49 AM 
 * @version V1.0  
 */
package com.zl.sp.common;

/** 
 * @ClassName: Page 
 * @Description: TODO 
 * @author zl
 * @date 18-04-05 9:03:49 AM
 */
public class MyPage {
	private int total;
	//起始位置
//	private int offset;
	private int start;
	//分页大小
	//private int limit;
	private int length;
	private String tableType = "datatables";
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
//	public int getOffset() {
//		return offset;
//	}
//	public void setOffset(int offset) {
//		this.offset = offset;
//	}
//	public int getLimit() {
//		return limit;
//	}
//	public void setLimit(int limit) {
//		this.limit = limit;
//	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getTableType() {
		return tableType;
	}
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}
}
