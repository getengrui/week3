package com.bw.bean;

public class Owner {
    private int id;
    private String name;
    private String idcard;
    private String gender;

    public Owner() {
    }

    public Owner(int id, String name, String idcard, String gender) {
        this.id = id;
        this.name = name;
        this.idcard = idcard;
        this.gender = gender;
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

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idcard='" + idcard + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
