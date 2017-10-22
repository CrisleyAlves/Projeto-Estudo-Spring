package com.estudojavaspring.ProjetoEstudoSpring.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Crisley Alves on 21, out, 2017
 **/
@Entity
@Table(name = "tipo")
public class Type extends AbstractEntity{

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL, targetEntity = Phone.class)
    private Set<Phone> phones;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}
