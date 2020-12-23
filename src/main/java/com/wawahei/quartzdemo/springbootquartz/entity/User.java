package com.wawahei.quartzdemo.springbootquartz.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:
 * @author: yanghailang
 * @create: 2020-12-22 17:26
 **/
@Data
@Entity
@Table
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String password;
}