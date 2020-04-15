package com.example.fragmentwithrecycler;

public class Person {

    private String name;
    private String telnr;

    public Person(String name, String telnr) {
        this.name = name;
        this.telnr = telnr;
    }

    public String getName() {
        return name;
    }

    public String getTelnr() {
        return telnr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelnr(String telnr) {
        this.telnr = telnr;
    }

}
