package com.estudojavaspring.ProjetoEstudoSpring.Controller;

import com.estudojavaspring.ProjetoEstudoSpring.Entity.Phone;
import com.estudojavaspring.ProjetoEstudoSpring.Entity.Student;
import com.estudojavaspring.ProjetoEstudoSpring.Error.ResourceNotFoundException;
import com.estudojavaspring.ProjetoEstudoSpring.Repository.PhoneRepository;
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
@RequestMapping("phones")
public class PhoneController {

    @Autowired
    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneController(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    /*
        O response retorna o conteúdo solicitado e também o status da requisição
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll(Pageable pageable){
//        System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(phoneRepository.findAll(pageable), HttpStatus.OK);
    }

    /*
        O path com {id} -> é recomendado, por questão de boa prática, segundo o próprio SpringBoot
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getPhoneByNumero(@PathVariable("numero") String numero, @AuthenticationPrincipal UserDetails userDetails){
        System.out.println(userDetails);
        return new ResponseEntity<>(phoneRepository.findByNumeroIgnoreCaseContaining(numero), HttpStatus.OK);

    }

}
