package com.example.lymphocytes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
@Document("lymphocytes")
public class Lymphocyte {

    @Id
    private Long id;
    private String type;
    private boolean identifiedInvader;

    public Lymphocyte(String type, boolean identifiedInvader) {
        this.type = type;
        this.identifiedInvader = identifiedInvader;
    }
    public Lymphocyte() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIdentifiedInvader() {
        return identifiedInvader;
    }

    public void setIdentifiedInvader(boolean identifiedInvader) {
        this.identifiedInvader = identifiedInvader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lymphocyte that = (Lymphocyte) o;
        return identifiedInvader == that.identifiedInvader && id.equals(that.id) && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, identifiedInvader);
    }

    @Override
    public String toString() {
        return "Lymphocyte{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", identifiedInvader=" + identifiedInvader +
                '}';
    }
}
