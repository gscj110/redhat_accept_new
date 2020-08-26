package com.gao.accept_new.dao;

import com.gao.accept_new.pojo.Department;
import com.gao.accept_new.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//员工Dao
@Repository
public class EmployeeDao {
    //模拟数据库中的数据
   private static Map<Integer, Employee> employees=null;
   //员工有所属的部门
    @Autowired
    private  DepartementDao departmentDao;
   static {
       employees = new HashMap<Integer, Employee>();//创建一个部门表
       Date date = new Date();

       employees.put(1001, new Employee(1001, "AA", "1213904383@qq.com", 1, new Department(101, "教学部"), new Date()));
       employees.put(1002, new Employee(1002, "BB", "1213904383@qq.com", 0, new Department(102, "市场部"), new Date()));
       employees.put(1003, new Employee(1003, "CC", "1213904383@qq.com", 1, new Department(103, "科研部"), new Date()));
       employees.put(1004, new Employee(1004, "DD", "1213904383@qq.com", 0, new Department(104, "运营部"), new Date()));
       employees.put(1005, new Employee(1005, "EE", "1213904383@qq.com", 1, new Department(105, "后勤部"), new Date()));


   }
   //主键自增
    private static Integer initId=1006;
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    //查询全部员工信息
    public Collection<Employee> getALL(){
        return employees.values();
    }
    //通过id查询员工
    public Employee getEmployeeByID(Integer id){
        return employees.get(id);
    }
    //删除员工通过id
    public void delete(Integer id){
        employees.remove(id);
    }


}
