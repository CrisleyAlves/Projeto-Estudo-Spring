package com.estudojavaspring.ProjetoEstudoSpring.Controller;

import com.estudojavaspring.ProjetoEstudoSpring.Entity.Student;
import com.estudojavaspring.ProjetoEstudoSpring.Error.ResourceNotFoundException;
import com.estudojavaspring.ProjetoEstudoSpring.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<?> listAll(Pageable pageable){
//        System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(studentRepository.findAll(pageable), HttpStatus.OK);
    }

    /*
        O path com {id} -> é recomendado, por questão de boa prática, segundo o próprio SpringBoot
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails){
        System.out.println(userDetails);
        verifyIfStudentExists(id);
        Student student = this.studentRepository.findOne(id);
        return new ResponseEntity<>(studentRepository.findOne(id), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/findbyname/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return new ResponseEntity<>(studentRepository.findByNameIgnoreCaseContaining(name), HttpStatus.OK);

    }

    @RequestMapping(path = "/insert/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<?> insertStudent(@Valid @RequestBody Student student){
        this.studentRepository.save(student);
        return new ResponseEntity<>(this.studentRepository.save(student), HttpStatus.CREATED);

    }

    @RequestMapping(path = "/update/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateStudent(@RequestBody Student student){
        verifyIfStudentExists(student.getId());
        return new ResponseEntity<>(this.studentRepository.save(student), HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStudentById(@PathVariable("id") Long id){
        verifyIfStudentExists(id);
        this.studentRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyIfStudentExists(Long id){
        if(this.studentRepository.findOne(id) == null) {
            throw new ResourceNotFoundException("O estudante com o código: " + id + " não foi encontrado");
        }
    }



}
