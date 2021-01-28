package com.zb.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_order")
public class TOrder  extends IdEntity {

    @Column(name="order_no",length = 20)
    private String orderNo;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_time")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_time")
    private Date updateTime;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
