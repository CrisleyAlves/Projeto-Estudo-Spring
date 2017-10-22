package com.estudojavaspring.ProjetoEstudoSpring.Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Crisley Alves on 21, out, 2017
 **/
@Entity
@Table(name = "tipo")
public class Type extends AbstractEntity{


    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL, targetEntity = Phone.class)
    private List<Phone> phones;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
