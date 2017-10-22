package com.estudojavaspring.ProjetoEstudoSpring.Entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Crisley Alves on 21, out, 2017
 **/
@Entity
@Table(name = "telefone")
public class Phone implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "numero", length = 9, nullable = false)
    private String numero;

    @Column(name = "student")
    private int student;

    @Column(name = "tipo")
    private int tipo;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
