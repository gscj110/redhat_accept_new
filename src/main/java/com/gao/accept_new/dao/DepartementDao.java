package com.gao.accept_new.dao;


import com.gao.accept_new.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门表
@Repository
public class DepartementDao {

    //模拟数据库
    private static Map<Integer, Department> departments=null;


    static {
        departments=new HashMap<Integer, Department>();//创建一个部门表

        departments.put(1,new Department(1,"软件工程"));
        departments.put(2,new Department(2,"计算机科学与技术"));
        departments.put(3,new Department(3,"嵌入式"));
        departments.put(4,new Department(4,"云计算"));
        departments.put(5,new Department(5,"3D"));


    }
    //获取所有部门信息
    public Collection<Department> getDepentments(){
        return departments.values();
    }
    //通过id得到部门
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }

}
