package com.gao.accept_new;

import com.gao.accept_new.pojo.Student;
import com.gao.accept_new.utils.ToExclUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.ConnectionEvent;
import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class AcceptNewApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
    //查看数据源
        System.out.println(dataSource.getClass());
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    void test() throws FileNotFoundException {
        ToExclUtils<Student> util = new ToExclUtils<Student>();
        // 准备数据
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(new Student(101,"张三asdf",1,12,"gaga","1231","dsfsf",new Date()));
//            list.add(new Student(111,"李四asd","男"));
//            list.add(new Student(111,"王五","女"));
        }
        String[] columnNames = { "ID", "姓名", "性别" };
        util.exportExcel("用户导出", columnNames, list, new FileOutputStream("D:/test.xls"), ToExclUtils .EXCEL_FILE_2003);
    }
    }



