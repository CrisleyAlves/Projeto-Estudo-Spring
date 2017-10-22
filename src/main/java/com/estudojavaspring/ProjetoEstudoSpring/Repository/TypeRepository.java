package com.estudojavaspring.ProjetoEstudoSpring.Repository;

import com.estudojavaspring.ProjetoEstudoSpring.Entity.Phone;
import com.estudojavaspring.ProjetoEstudoSpring.Entity.Type;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Crisley on 23/09/2017.
 */

public interface TypeRepository extends PagingAndSortingRepository<Type, Long>{

    List<Type> findByNome(String nome);

}
