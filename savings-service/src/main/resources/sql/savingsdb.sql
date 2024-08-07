#创建数据库
DROP DATABASE IF EXISTS savingsdb;
CREATE DATABASE savingsdb;
#选择使用数据库
USE savingsdb;
#创建表t_savings并插入相关数据
DROP TABLE IF EXISTS t_savings;
create table t_savings
(
    id    int(20) auto_increment comment '记录id' primary key,
    p_id  varchar(200)        null comment '外汇代码',
    count int(20) default '0' null comment '余额',
    constraint commodity_code unique (p_id)
) charset = utf8;
insert into t_savings
values ('1', 'p001', '1000');
insert into t_savings
values ('2', 'p002', '2000');