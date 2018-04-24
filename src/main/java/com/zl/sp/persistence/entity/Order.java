package com.zl.sp.persistence.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 订单信息
 * </p>
 *
 * @author zhangliang
 * @since 2018-04-23
 */
@TableName("sp_order")
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单标识号
     */
	@TableId(value="order_id", type= IdType.AUTO)
	private Integer orderId;
    /**
     * 下单用户
     */
	@TableField("order_user_name")
	private String orderUserName;
    /**
     * 订单主题
     */
	@TableField("oder_subject")
	private String oderSubject;
    /**
     * 订单金额
     */
	@TableField("order_amount")
	private String orderAmount;
    /**
     * 订单状态
     */
	@TableField("order_status")
	private Integer orderStatus;
    /**
     * 商户订单号
     */
	@TableField("order_out_trade_no")
	private String orderOutTradeNo;
    /**
     * 订单生成时间
     */
	@TableField("order_generate_time")
	private Date orderGenerateTime;


	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderUserName() {
		return orderUserName;
	}

	public void setOrderUserName(String orderUserName) {
		this.orderUserName = orderUserName;
	}

	public String getOderSubject() {
		return oderSubject;
	}

	public void setOderSubject(String oderSubject) {
		this.oderSubject = oderSubject;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderOutTradeNo() {
		return orderOutTradeNo;
	}

	public void setOrderOutTradeNo(String orderOutTradeNo) {
		this.orderOutTradeNo = orderOutTradeNo;
	}

	public Date getOrderGenerateTime() {
		return orderGenerateTime;
	}

	public void setOrderGenerateTime(Date orderGenerateTime) {
		this.orderGenerateTime = orderGenerateTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.orderId;
	}

	@Override
	public String toString() {
		return "Order{" +
			", orderId=" + orderId +
			", orderUserName=" + orderUserName +
			", oderSubject=" + oderSubject +
			", orderAmount=" + orderAmount +
			", orderStatus=" + orderStatus +
			", orderOutTradeNo=" + orderOutTradeNo +
			", orderGenerateTime=" + orderGenerateTime +
			"}";
	}
}
