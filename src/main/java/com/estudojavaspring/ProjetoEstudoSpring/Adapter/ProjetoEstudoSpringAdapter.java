package com.estudojavaspring.ProjetoEstudoSpring.Adapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by Crisley Alves on 23, set, 2017
 **/

/*
    Classe utilizada para alterar a quantidade de dados que será mostrada na paginação
    está sobreescrevendo a função principal do adapter do springboot responsável pela paginação
 */

@Configuration
public class ProjetoEstudoSpringAdapter extends WebMvcConfigurerAdapter{

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableHandlerMethodArgumentResolver phmar = new PageableHandlerMethodArgumentResolver();
        phmar.setFallbackPageable(new PageRequest(0, 5));
        argumentResolvers.add(phmar);
    }
}
