package com.example.kafkatest;

public class SimpleObject {

    private String name;
    private String desc;

    public SimpleObject(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public SimpleObject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "SimpleObject{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
