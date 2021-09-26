package com.example.springsecuritydbuserdemo.security.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Table(schema = "spring_security_db", name = "authorities")
@Entity
public class DBUserAuthority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="authority", unique = true)
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
