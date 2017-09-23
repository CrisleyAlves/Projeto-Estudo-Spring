package com.estudojavaspring.ProjetoEstudoSpring.Entity;

/**
 * Created by Crisley on 20/09/2017.
 */

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Student extends AbstractEntity {

    @NotEmpty(message = "O nome do estudante não foi preenchido")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "O email do do estudante não foi preenchido")
    @Column(name = "course")
    private String course;

    public String getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {

        this.course = course;
    }
}
