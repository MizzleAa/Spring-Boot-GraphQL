package com.sample.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", unique = true)
    @NotNull
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;
 
    @Column(name = "name")
    @NotNull
    private String name;
    
    @Column(name = "age")
    private int age;

    @Builder
    public User(String email, String password, String name, int age){
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public void update(String name, int age){
        this.name = name;
        this.age = age;
    }
}
