package com.estudojavaspring.ProjetoEstudoSpring.Util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Crisley Alves on 23, set, 2017
 **/
public class PasswordEncoder {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode(bCryptPasswordEncoder.encode("admin")));
    }

}
