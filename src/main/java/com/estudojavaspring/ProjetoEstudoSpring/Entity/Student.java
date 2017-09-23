package com.estudojavaspring.ProjetoEstudoSpring.Entity;

/**
 * Created by Crisley on 20/09/2017.
 */

import javax.persistence.Entity;

@Entity
public class Student extends AbstractEntity {

    private String name;

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
