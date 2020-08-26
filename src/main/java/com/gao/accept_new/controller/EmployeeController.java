package com.gao.accept_new.controller;

import com.gao.accept_new.dao.DepartementDao;
import com.gao.accept_new.dao.EmployeeDao;
import com.gao.accept_new.pojo.Department;
import com.gao.accept_new.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import java.util.Collection;
import java.util.Date;


public class EmployeeController {
    //
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartementDao departementDao;
    @RequestMapping("/emps")
    public String list(Model model){
      Collection<Employee> employee= employeeDao.getALL();

      model.addAttribute("emps",employee);
      return "emp/list.html";


    }
    @RequestMapping("/toAdd")
    public String toAddage(Model model){
         //查出所有部门的信息
        Collection<Department> departments=departementDao.getDepentments();
        model.addAttribute("departments",departments);
        System.out.println(departments);


        return "emp/add";
    }


    @RequestMapping("/emp")
    public String addEmp(Employee employee){
        //添加的操作
        System.out.println(employee);
        Date date=new Date();
        employee.setBirth(date);
        employeeDao.save(employee);//保存底层员工信息
        return "redirect:/emps";
    }

    //去员工的修改页面
    @RequestMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        System.out.println("测试能否进入到这个页面");
         //查出原来的数据
        Employee employeeById =employeeDao.getEmployeeByID(id);
        System.out.println(employeeById);
        Collection<Department> departments=departementDao.getDepentments();
        model.addAttribute("departments",departments);

        model.addAttribute("emp",employeeById);
        return "emp/update";
        }
    @RequestMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    //删除员工
    @RequestMapping("/delemp/{id}")
    public  String  deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";



    }


        }