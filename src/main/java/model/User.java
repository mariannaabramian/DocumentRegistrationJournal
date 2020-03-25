package model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;



    @Column(length = 50)
    private String login;

    @Enumerated(EnumType.ORDINAL)
    private UserStatus status;

    @Transient
    private String notStored;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Group group;

    public int getX() {
        return 999;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public Group getGroup() {
        return group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
