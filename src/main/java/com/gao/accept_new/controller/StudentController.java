package com.gao.accept_new.controller;

import com.gao.accept_new.dao.DepartementDao;
import com.gao.accept_new.mapper.StudentMapper;
import com.gao.accept_new.pojo.Department;
import com.gao.accept_new.pojo.Employee;
import com.gao.accept_new.pojo.Student;
import com.gao.accept_new.utils.ToExclUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.model.IModel;

import javax.jws.WebParam;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    DepartementDao departementDao;
    //展示所有的学生信息
    @RequestMapping("/emps")
    public String queryS(Model model) throws FileNotFoundException {
       List<Student> studentList= studentMapper.queryStudentList();
       model.addAttribute("emps",studentList);
       ToExclUtils<Student> util = new ToExclUtils<Student>();
       String[] columnNames = { "ID", "姓名", "性别","年龄","专业","学号","自我介绍","报名日期" };
       String date= RandomStringUtils.randomAlphanumeric(10);
       String path="/home/uploads/";
       String name=date+".xls";
       path = path+name;
       System.out.println(path);
       util.exportExcel("用户导出", columnNames,studentList, new FileOutputStream(path), ToExclUtils .EXCEL_FILE_2003);
       String  url_path="uploads/"+name;
       model.addAttribute("path",url_path);
       return "emp/list.html";

    }
    //index登录
    @RequestMapping("/")
    public String toindex(Model model){
        Collection<Department> departments=departementDao.getDepentments();
        model.addAttribute("departments",departments);
        return "index";
    }


    //增加用户信息
    @RequestMapping("/toAdd")
    public String toAddage(Model model){
        //查出所有部门的信息
        Collection<Department> departments=departementDao.getDepentments();
        model.addAttribute("departments",departments);


        return "emp/add";
    }

    @RequestMapping("/emp")
    public String addEmp(Student student){
        System.out.println("进入到了emp");
        System.out.println(student);
        studentMapper.addStudent(student);
        System.out.println("测试能否使用sql语句");
        return "redirect:/emps";

    }
    @RequestMapping("/success")
    public String addEmpSuccess(Student student){
        System.out.println("进入到了emp");
        System.out.println(student);
        studentMapper.addStudent(student);
        System.out.println("测试能否使用sql语句");
        return "success";

    }
    @RequestMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        Student student=studentMapper.queryStudentById(id);
        Collection<Department> departments=departementDao.getDepentments();
        model.addAttribute("departments",departments);
        model.addAttribute("emp",student);
        return "emp/update";
    }

    @RequestMapping("/updateEmp")
    public String updateEmp(Student student){
        studentMapper.updateStudent(student);
        return "redirect:/emps";
    }
    @RequestMapping("/delemp/{id}")
    public  String  deleteEmp(@PathVariable("id") Integer id){
        studentMapper.deleteStudent(id);
        return "redirect:/emps";



    }
}
