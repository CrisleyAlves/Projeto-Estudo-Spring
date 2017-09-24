package com.estudojavaspring.ProjetoEstudoSpring.Repository;

import com.estudojavaspring.ProjetoEstudoSpring.Entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Crisley on 23/09/2017.
 */

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
    User findByUsername(String username);

}
