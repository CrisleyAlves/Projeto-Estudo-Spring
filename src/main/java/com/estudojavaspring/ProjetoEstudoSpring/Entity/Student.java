package com.estudojavaspring.ProjetoEstudoSpring.Entity;

/**
 * Created by Crisley on 20/09/2017.
 */

import org.springframework.context.annotation.ComponentScan;

public class Student {

    private int id;
    private String nome;
    private String course;

    public Student(int id, String nome, String course) {
        this.id = id;
        this.nome = nome;
        this.course = course;
    }

    public Student(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
