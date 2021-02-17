package com.bd.recyclarerviewdemo;

public class PersonData {

    private String name;
    private String email;
    private int img;
    private int _id;

    public PersonData(String name, String email, int img, int _id) {
        this.name = name;
        this.email = email;
        this.img = img;
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
