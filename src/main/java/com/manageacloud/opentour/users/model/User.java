package com.manageacloud.opentour.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Objects;

/**
 * Created by R3Systems Pty Ltd
 * User tk421 on 27/06/16.
 */

@Entity
@Table(name = "users")
public class User implements Serializable {

    public enum System {

        ADMIN(-1L);

        private Long id;

        System(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    //@SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq")
    private Long id;

    private String name;

    private String password;

    private String email;
    private String phone;

    private Timestamp autopass;

    @Column(insertable = false, updatable = false)
    private Timestamp created;

    private Timestamp deleted;

    private Timestamp password_updated;

    private String cookie;

    protected  User() {}

    public User(String name, String password, String email,Timestamp autopass) {
        id = getNextId();
        this.name = name;
        this.password = password;
        this.email = email;
        this.autopass = autopass;
        this.created = new Timestamp(Calendar.getInstance().getTime().getTime());
    }


    // TODO HACK TO REMOVE
    public static Long nextId = 0L;
    protected static Long getNextId() {
        synchronized (nextId) {
            return nextId++;
        }
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Timestamp getAutopass() {
        return autopass;
    }

    public Timestamp getCreated() {
        return created;
    }

    public Timestamp getDeleted() {
        return deleted;
    }

    public Timestamp getPassword_updated() {
        return password_updated;
    }

    public String getCookie() {
        return cookie;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", autopass=" + autopass +
                ", created=" + created +
                ", deleted=" + deleted +
                ", password_updated=" + password_updated +
                ", cookie='" + cookie + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(autopass, user.autopass) &&
                Objects.equals(created, user.created) &&
                Objects.equals(deleted, user.deleted) &&
                Objects.equals(password_updated, user.password_updated) &&
                Objects.equals(cookie, user.cookie);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, /*userRole,*/ password, email, phone, autopass, created, deleted, password_updated, cookie);
    }
}
