package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name="pets")
public class pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String species;
}
