package com.estudojavaspring.ProjetoEstudoSpring.Service;

import com.estudojavaspring.ProjetoEstudoSpring.Entity.User;
import com.estudojavaspring.ProjetoEstudoSpring.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by Crisley Alves on 23, set, 2017
 **/
@Component
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = Optional.ofNullable(userRepository.findByUsername(username))
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));

        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("USER", "ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("USER");

        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                user.isAdmin() ? authorityListAdmin : authorityListUser);

    }
}
