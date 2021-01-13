package com.achacker.pojo;

import java.util.Objects;

public class Persion {
    private String id;
    private String name;

    public Persion() {
    }

    public Persion(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persion persion = (Persion) o;
        return Objects.equals(id, persion.id) && Objects.equals(name, persion.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Persion{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
