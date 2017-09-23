package com.estudojavaspring.ProjetoEstudoSpring.Repository;

import com.estudojavaspring.ProjetoEstudoSpring.Entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Crisley on 23/09/2017.
 */

public interface StudentRepository extends PagingAndSortingRepository<Student, Long>{

    List<Student> findByNameIgnoreCaseContaining(String name);

}
