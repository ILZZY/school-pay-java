package com.zl.sp.common;

import org.apache.commons.lang3.StringUtils;

import com.baomidou.mybatisplus.plugins.Page;
import com.zl.sp.common.MyPage;

/**
 * 分页对象创建工程
 * 根据前端UI的分页参数创建适用于后端的统一的分页对象
 * 
 * <pre> 
 * 项目名称：
 * 类名称：PageFactory
 * 类描述： 
 * 创建人：阳飞
 * 创建时间：2017年8月13日 下午9:51:19
 * 修改人：阳飞
 * 修改时间：2017年8月13日 下午9:51:19
 * 修改备注：
 * </pre>
 * 
 * @version 
 *
 */
public class PageFactory {
  
    /**
     * 默认页大小
     */
    public static final int DEF_LIMIT = 20;
        
    /**
     * 获取前端分页参数中表示limit的参数的名称
     * @param dataGridType
     */
    private static int getLimitWithName(MyPage page){
        if(StringUtils.isBlank(page.getTableType()) 
            || "datatables".equalsIgnoreCase(page.getTableType())) {
        	if(page.getLength() == 0) {
        		return DEF_LIMIT;
        	}
            return page.getLength();
        }
        return DEF_LIMIT;
    }
    
    /**
     * 获取前端分页参数中表示offset的参数的名称
     * @param dataGridType
     */
    private static int getOffsetWithName(MyPage page){
        if(StringUtils.isBlank(page.getTableType()) 
            || "datatables".equalsIgnoreCase(page.getTableType())) {
            return page.getStart();
        } else {
        	return page.getStart();
        }
    }
    
    /**
     * 创建分页参数对象
     * @param limit
     * @param offset
     * @param sort
     * @param order
     * @return
     */
    public static <T> Page<T> buildPage(int limit,int offset,String sort, String order) {
        
        if(StringUtils.isBlank(sort)){
            Page<T> page = new Page<T>((offset / limit + 1), limit);
            page.setOpenSort(false);
            return page;
        } else {
            Page<T> page = new Page<T>((offset / limit + 1), limit, sort);
            if("asc".equals(order)){
                page.setAsc(true);
            }else{
                page.setAsc(false);
            }
            return page;
        }
    }
    
	@SuppressWarnings("rawtypes")
    public static Page getPageParam(MyPage page){
    	Page p = buildPage(getLimitWithName(page), getOffsetWithName(page), null, null);
		p.setTotal(page.getTotal());
    	return p;
    }
}