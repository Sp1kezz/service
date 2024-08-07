package com.example.domain;

import lombok.Data;
import com.baomidou.mybatisplus.extension.activerecord.Model;

@Data
public class Savings extends Model<com.example.domain.Savings> {
    private Integer id;
    private String pId;
    private Integer count;
}
