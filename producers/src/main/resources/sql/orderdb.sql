#创建数据库
DROP DATABASE IF EXISTS orderdb;
CREATE DATABASE orderdb;
#选择使用数据库
USE orderdb;
#创建表t_order并插入相关数据
DROP TABLE IF EXISTS t_order;
create table t_order
(
    id int(50) auto_increment comment 'id' primary key ,
    order_Id  varchar(80)   comment '订单id',
    user_Id varchar(20) null comment '用户id',
    product_Id varchar(20)  null comment '商品id',
    purchase_Num int(50)  null comment '购买数量',
    status tinyint(1) null comment '是否支付',
    create_Time date null comment '下单时间'
) charset = utf8;
insert into t_order
values ('1','00000000000000001', 'u001', 'p001','1000',false,'2023-06-10');
insert into t_order
values ('2','00000000000000002', 'u002','p002', '2000',true,'2023-06-10');