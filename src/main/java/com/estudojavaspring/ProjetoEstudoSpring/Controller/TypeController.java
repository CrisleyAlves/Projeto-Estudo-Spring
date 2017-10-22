package com.estudojavaspring.ProjetoEstudoSpring.Controller;

import com.estudojavaspring.ProjetoEstudoSpring.Repository.PhoneRepository;
import com.estudojavaspring.ProjetoEstudoSpring.Repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Crisley on 20/09/2017.
 */

@RestController()
@RequestMapping("types")
public class TypeController {

    @Autowired
    private final TypeRepository typeRepository;

    @Autowired
    public TypeController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    /*
        O response retorna o conteúdo solicitado e também o status da requisição
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll(Pageable pageable){
//        System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(typeRepository.findAll(pageable), HttpStatus.OK);
    }

    /*
        O path com {id} -> é recomendado, por questão de boa prática, segundo o próprio SpringBoot
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getTypeByNome(@PathVariable("nome") String nome, @AuthenticationPrincipal UserDetails userDetails){
        System.out.println(userDetails);
        return new ResponseEntity<>(typeRepository.findByNome(nome), HttpStatus.OK);

    }

}
