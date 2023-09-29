package com.yosha.userprofile.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;
    private  String email;
    private String phoneNumber;
}
