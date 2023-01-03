package com.linzrain.dao;

import com.linzrain.pojo.Student;

public interface StudentDAO {
    public int insertStudent(Student student);
    public int deleteStudent(String stuNum);
}
