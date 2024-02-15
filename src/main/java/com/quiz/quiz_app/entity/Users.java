package com.quiz.quiz_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Users extends BaseEntity {

    @Column(nullable = false)
    private String firstName;

    @Column
    private String lastName;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<UserAnswer> users = new ArrayList<>();
}
