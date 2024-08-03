package org.example.entities;

import java.time.LocalDate;
import java.util.UUID;

public class BaseEntity {

    private String id;
    private LocalDate createdDate;

    public BaseEntity() {
        this.id = UUID.randomUUID().toString();
        this.createdDate = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
