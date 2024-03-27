package com.example.shoaib.domytask.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "\"user\"",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String password;

}
