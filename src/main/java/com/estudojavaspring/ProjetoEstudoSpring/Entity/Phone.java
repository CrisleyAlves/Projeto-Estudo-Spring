package com.estudojavaspring.ProjetoEstudoSpring.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @ManyToOne(targetEntity = Student.class)
    @JsonBackReference
    private Student student;

    @ManyToOne(targetEntity = Type.class)
    @JsonBackReference
    private Type tipo;

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Type getTipo() {
        return tipo;
    }

    public void setTipo(Type tipo) {
        this.tipo = tipo;
    }
}
