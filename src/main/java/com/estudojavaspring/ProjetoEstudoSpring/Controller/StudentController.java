package com.estudojavaspring.ProjetoEstudoSpring.Controller;

import com.estudojavaspring.ProjetoEstudoSpring.Entity.Student;
import com.estudojavaspring.ProjetoEstudoSpring.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Crisley on 20/09/2017.
 */

@RestController()
@ComponentScan( basePackages = "com.estudojavaspring.ProjetoEstudoSpring")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping( value = "/students", method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id){
        return this.studentService.getStudentById(id);
    }

    @RequestMapping(value = "/students/remove/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id){
        this.studentService.removeStudentById(id);
    }

    @RequestMapping(value = "/students/update/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateStudent(@RequestBody Student student){
        this.studentService.updateStudent(student);

        return "foi";
    }

    @RequestMapping(value = "/students/insert/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String insertStudent(@RequestBody Student student){

        this.studentService.insertStudent(student);

        return "foi";
    }



}
