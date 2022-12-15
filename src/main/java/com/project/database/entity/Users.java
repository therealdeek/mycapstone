package com.project.database.entity;

import javax.persistence.*;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

//    @Column(name = "create_date", nullable = false, updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createDate;
}

