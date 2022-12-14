package com.project.database.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Blob;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "pr_name")
    private String prName;

    @Column(name = "pr_price")
    private Integer prPrice;

    @Column(name = "pr_desc")
    private String prDesc;

    @Column(name = "avatar")
    private String avatar;
}
