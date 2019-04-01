package com.jason.springcorestudy.bean;

public class Spark extends AbstractCar {

    private String name;

    protected void run() {
        System.out.println("스파크가 움직인다.");
    }

    public Spark(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}