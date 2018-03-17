package com.zl.sp.bean;

import java.util.Date;

public class Order {
    private Integer orderId;

    private Date orderGenerateTime;

    private Integer orderStatus;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderGenerateTime() {
        return orderGenerateTime;
    }

    public void setOrderGenerateTime(Date orderGenerateTime) {
        this.orderGenerateTime = orderGenerateTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}