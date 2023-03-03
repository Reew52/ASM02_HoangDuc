package com.mycompany.approject;
import java.time.LocalDateTime;

public class ClassBase {
    private static int lastId = 0;
   
    private int id;
    private LocalDateTime created;
    private LocalDateTime updated;

    ClassBase(int id) {
        this.id = id;
        this.created = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public static ClassBase create() {
        lastId++;
        return new ClassBase(lastId);
    }
}