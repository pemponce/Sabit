package com.example.lombok.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "userlombok")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;
    private int height;
    private String name;
    private String nation;


    public User( int age, int height, String name, String nation) {
        this.age = age;
        this.height = height;
        this.name = name;
        this.nation = nation;
    }
}
