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

    public User(String username, String password, String email, String role) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}

//@Data
//@Entity
//public class User implements UserDetails {
//    @Id
//    int id;
//
//    String username;
//    @JsonIgnore
//    String password;
//    String email;
//    String role;
//
//    @JsonCreator
//    public User(User user) {
//        this.id = user.id;
//        this.username = user.username;
//        this.password = user.password;
//        this.email = user.email;
//        this.role = user.role;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        if (role.equals("admin")) {
//            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        } else {
//            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
//        }
//    }
//
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
