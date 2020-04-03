package ru.levelup.model;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    public Group(String name) {
        this.name = name;
    }

    public Group() {
    }

    //    @ManyToMany(mappedBy = "group")
    @OneToMany(mappedBy = "group")
//    @JoinColumn(name = "group_fk")
//    @JoinTable()
    private List<User> users;
//    private Set<User> users;
//    private Map<Integer, User> users;

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

    public List<User> getUsers() {
        return users;
    }
}
