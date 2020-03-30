package ru.levelup.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "groups")
public class Group {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "group")
    private List<User> users;

    public Group(String name) {
        this.name = name;
    }

    public Group() {}

    public int getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }
}
