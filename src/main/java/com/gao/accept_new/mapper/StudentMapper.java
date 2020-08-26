package com.gao.accept_new.mapper;

import com.gao.accept_new.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//这个注解表示了这是一个mybatis的mapper类
@Mapper
//mapper类
@Repository
public interface StudentMapper {

    //int age =18;静态常量

    List<Student> queryStudentList();

    Student queryStudentById(int id);

    int addStudent(Student student);

    int updateStudent(Student student);

    int deleteStudent(int id);

}
