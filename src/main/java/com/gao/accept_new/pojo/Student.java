package com.gao.accept_new.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    //序号
    private Integer id;
    //姓名
    private String name;

    //性别
    private Integer gender;
    //年龄
    private int age;
    //专业
    private String major;
    //学号
    private String  sno;
    //自我介绍
    private String introduction;
    //创建时间
    private Date date;


}
