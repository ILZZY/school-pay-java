/**   
 * @Title: DataGridInfo.java 
 * @Package com.zl.sp.common 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zl   
 * @date Mar 29, 2018 10:02:45 PM 
 * @version V1.0  
 */
package com.zl.sp.common;

/** 
 * @ClassName: DataGridInfo 
 * @Description: TODO 
 * @author zl
 * @date 18-03-29 10:02:45 PM
 */
public class DataGridInfo extends Tip{
private static final String NOT_FOUND = "No matching records found!";
    
    /**
     * <p>没匹配记录的处理方式</p>
     * @title: notFound
     */
    public void notFound() {
        this.setMsg_(NOT_FOUND);
    }
}
