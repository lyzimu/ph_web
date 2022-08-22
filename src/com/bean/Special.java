package com.bean;

import java.util.List;

public class Special {
    private int id;
    private String name;
    private List<Vet> vetlist;

    public Special() {
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

    public List<Vet> getVetlist() {
        return vetlist;
    }

    public void setVetlist(List<Vet> vetlist) {
        this.vetlist = vetlist;
    }

    @Override
    public String toString() {
        return "Special{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vetlist=" + vetlist +
                '}';
    }
}
