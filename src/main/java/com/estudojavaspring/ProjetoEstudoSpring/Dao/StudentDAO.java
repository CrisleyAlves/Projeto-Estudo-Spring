package com.estudojavaspring.ProjetoEstudoSpring.Dao;

import com.estudojavaspring.ProjetoEstudoSpring.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Crisley on 20/09/2017.
 */

@Repository
public class StudentDAO {

    private static Map<Integer, Student> students;

    static{
        students = new HashMap<Integer, Student>(){
            {
                put( 1, new Student(1, "João","Sistemas"));
                put( 2, new Student(2, "Maria","Psicologia"));
                put( 3, new Student(3, "Carol","Direito"));
            }
        };
    }

    public Collection<Student> getAllStudents(){
        return this.students.values();
    }



    public Student getStudentById(int id){
        return this.students.get(id);
    }

    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    public void updateStudent(Student stu){
        Student s = this.students.get(stu.getId());
        s.setCourse(stu.getCourse());
        s.setNome(stu.getNome());
        this.students.put(stu.getId(), stu);
    }

    public void insertStudent(Student student) {
        this.students.put(student.getId(), student);
    }
}
