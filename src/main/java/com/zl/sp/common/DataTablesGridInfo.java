/**   
 * @Title: DataTablesGridInfo.java 
 * @Package com.zl.sp.common 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zl   
 * @date Mar 29, 2018 10:04:22 PM 
 * @version V1.0  
 */
package com.zl.sp.common;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.zl.sp.utils.SpTools;

/** 
 * @ClassName: DataTablesGridInfo 
 * @Description: TODO 
 * @author zl
 * @date 18-03-29 10:04:22 PM
 */
public class DataTablesGridInfo extends DataGridInfo {
	/**
     * 总记录数
     */
    private int recordsTotal = 0;
    
    /**
     * 过滤之后的记录数
     */
    private int recordsFiltered = 0;
    
    public DataTablesGridInfo(){
    	super();
    }
    
    public <T> DataTablesGridInfo(Page<T> page) {
        super();
        this.recordsTotal = page.getTotal();
        this.recordsFiltered = page.getTotal();
        this.setData(page.getRecords());
        if(SpTools.isEmpty(page.getRecords())) {
            notFound();
        }
    }
    
    public <T> DataTablesGridInfo(int recordsTotal, List<T> data) {
        super();
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsTotal;
        this.setData(data);
        if(SpTools.isEmpty(data)) {
            notFound();
        }
    }
    
    /**
     * 返回BO分页数据
     * @param page
     * @param data
     */
    public <T,B> DataTablesGridInfo(Page<T> page,List<B> data) {
        this(page.getTotal(),data);
    }

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
    
}
