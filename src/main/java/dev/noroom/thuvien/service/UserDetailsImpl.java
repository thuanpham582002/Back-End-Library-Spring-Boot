package dev.noroom.thuvien.service;

import dev.noroom.thuvien.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserDetailsImpl implements UserDetails {
    private Long id;

    private String username;

    private String password;

    private String email;

    private String role;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String username, String password, String email, String role, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRole().equals("admin") ?
                List.of(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return "ROLE_ADMIN";
                    }
                }) :
                List.of(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return "ROLE_USER";
                    }
                });
        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getRole(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // TODO: implement this
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // TODO: implement this
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // TODO: implement this
    }

    @Override
    public boolean isEnabled() {
        return true; // TODO: implement this
    }
}
