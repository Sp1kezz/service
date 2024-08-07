package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@TableName("t_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order extends Model<Order> {
    private Integer id;
    private String orderId;        //唯一订单号（由雪花算法生成），据此实现消费幂等性
    private String userId;         //用户ID
    private String productId;      //商品ID
    private Integer purchaseNum;   //购买数量
    private boolean status;        //是否支付
    private Date createTime;       //下单时间
}
