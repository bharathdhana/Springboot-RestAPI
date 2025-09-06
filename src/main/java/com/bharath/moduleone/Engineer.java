package com.bharath.moduleone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
public class Engineer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private List<String> techStack;


    @Override
    public String toString() {
        return "Engineer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", techStack=" + techStack +
                '}';
    }

    public Engineer(){}

    public Engineer(int id, String name, List<String> techStack) {
        this.id = id;
        this.name = name;
        this.techStack = techStack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTechStack() {
        return techStack;
    }

    public void setTechStack(List<String> techStack) {
        this.techStack = techStack;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Engineer engineer = (Engineer) o;
        return id == engineer.id && Objects.equals(name, engineer.name) && Objects.equals(techStack, engineer.techStack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, techStack);
    }
}
