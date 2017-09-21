package com.estudojavaspring.ProjetoEstudoSpring.Service;

import com.estudojavaspring.ProjetoEstudoSpring.Dao.StudentDAO;
import com.estudojavaspring.ProjetoEstudoSpring.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Crisley on 20/09/2017.
 */

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public Collection<Student> getAllStudents(){
        return this.studentDAO.getAllStudents();
    }

    public Student getStudentById(int id){
        return this.studentDAO.getStudentById(id);
    }

    public void removeStudentById(int id) {
        this.studentDAO.removeStudentById(id);
    }

    public void updateStudent(Student stu){
        this.studentDAO.updateStudent(stu);
    }

    public void insertStudent(Student student) {
        this.studentDAO.insertStudent(student);
    }
}
