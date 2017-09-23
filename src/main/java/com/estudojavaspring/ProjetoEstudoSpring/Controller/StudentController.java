package com.estudojavaspring.ProjetoEstudoSpring.Controller;

import com.estudojavaspring.ProjetoEstudoSpring.Entity.Student;
import com.estudojavaspring.ProjetoEstudoSpring.Error.CustomErrorType;
import com.estudojavaspring.ProjetoEstudoSpring.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Crisley on 20/09/2017.
 */

@RestController()
@RequestMapping("students")
public class StudentController {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    /*
        O response retorna o conteúdo solicitado e também o status da requisição
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll(){
//        System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    /*
        O path com {id} -> é recomendado, por questão de boa prática, segundo o próprio SpringBoot
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id){

        Student student = null;
        student = this.studentRepository.findOne(id);

        if(student == null){
            return new ResponseEntity<>(new CustomErrorType("Estudante não encontrado"), HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(studentRepository.findOne(id), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/findbyname/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return new ResponseEntity<>(studentRepository.findByNameIgnoreCaseContaining(name), HttpStatus.OK);

    }

    @RequestMapping(path = "/insert/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertStudent(@RequestBody Student student){
        return new ResponseEntity<>(this.studentRepository.save(student), HttpStatus.CREATED);

    }

    @RequestMapping(path = "/update/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateStudent(@RequestBody Student student){
        return new ResponseEntity<>(this.studentRepository.save(student), HttpStatus.OK);
    }

    @RequestMapping(path = "/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStudentById(@PathVariable("id") Long id){
        this.studentRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
