package com.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vet {
    private int id ;
    private String name;
    private List<Special> specialList = new ArrayList<Special>();
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

    public List<Special> getSpecialList() {
        return specialList;
    }

    public void setSpecialList(List<Special> specialList) {
        this.specialList = specialList;
    }

    @Override
    public String toString() {
        return "Vet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialList=" + specialList +
                '}';
    }
}
