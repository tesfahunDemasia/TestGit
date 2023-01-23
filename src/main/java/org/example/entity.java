package org.example;

public class entity {
    int id;
    String qwerty;
    // GERE'S AND SETTERS OF ID
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    // GERE'S AND SETTERS OF QWERTY
    public String getQwerty() {
        return qwerty;
    }
    public void setQwerty(String qwerty) {
        this.qwerty = qwerty;
    }

    public entity(int id, String qwerty) {
        this.id = id;
        this.qwerty = qwerty;
    }
    public entity() {
    }
}
