package com.estudojavaspring.ProjetoEstudoSpring.Entity;

/**
 * Created by Crisley on 20/09/2017.
 */

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student extends AbstractEntity {

    @NotEmpty(message = "O nome do estudante não foi preenchido")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "O email do do estudante não foi preenchido")
    @Column(name = "course")
    private String course;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, targetEntity = Phone.class)
    private List<Phone> phones;

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

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
