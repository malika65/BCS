package com.company;

public class User
{
    String name;
    String pass;
    User(String name,String pass) {
        this.pass = pass;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " jfdhk "  + pass;
    }
}
