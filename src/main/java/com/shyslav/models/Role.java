package com.shyslav.models;

/**
 * Created by shyslav on 9/10/16.
 */
public class Role {
    private int id;
    private int name;
    private char home;
    private char blog;
    private char contacts;
    private char comments;
    private char admin_panel;

    public Role(int id, int name, char home, char blog, char contacts, char comments, char admin_panel) {
        this.id = id;
        this.name = name;
        this.home = home;
        this.blog = blog;
        this.contacts = contacts;
        this.comments = comments;
        this.admin_panel = admin_panel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public char getHome() {
        return home;
    }

    public void setHome(char home) {
        this.home = home;
    }

    public char getBlog() {
        return blog;
    }

    public void setBlog(char blog) {
        this.blog = blog;
    }

    public char getContacts() {
        return contacts;
    }

    public void setContacts(char contacts) {
        this.contacts = contacts;
    }

    public char getComments() {
        return comments;
    }

    public void setComments(char comments) {
        this.comments = comments;
    }

    public char getAdmin_panel() {
        return admin_panel;
    }

    public void setAdmin_panel(char admin_panel) {
        this.admin_panel = admin_panel;
    }
}
