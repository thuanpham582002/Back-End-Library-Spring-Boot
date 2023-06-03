package dev.noroom.thuvien.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String username;
    @JsonIgnore
    String password;
    String email;
    String role;

    @JsonCreator
    public User(User user) {
        this.id = user.id;
        this.username = user.username;
        this.password = user.password;
        this.email = user.email;
        this.role = user.role;
    }

    public User() {

    }

    public User(String username, String email, String password, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}