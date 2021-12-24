package com.tuareg_coding.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "user_sequence"
    )
    private Long id;
    @Column(
            nullable = false,
            length = 100
    )
    private String firstName;
    @Column(
            nullable = false,
            length = 100
    )
    private String lastName;
    @Column(
            nullable = false,
            unique = true,
            length = 100
    )
    private String email;
    @Column(
            nullable = false,
            length = 200
    )
    private String password;
}
