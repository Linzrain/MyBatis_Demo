package com.linzrain.dao;

import com.linzrain.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

import static org.junit.Assert.*;

public class StudentDAOTest {

    @Test
    public void insertStudent() {
        try {
            //加载mybatis配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //创建builder
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //会话工厂,连接工厂
            SqlSessionFactory factory = builder.build(is);
            //sqlsession 代表数据库的连接,也代表数据库的连接对象
            //会话(连接)
            SqlSession sqlSession = factory.openSession();
            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
            int i = studentDAO.insertStudent(new Student(0,"10002","linzrain","男",24));
            sqlSession.commit();
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void deleteStudent() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession sqlSession = factory.openSession();
            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
            int i = studentDAO.deleteStudent("10002");
            sqlSession.commit();
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}