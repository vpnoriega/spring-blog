package com.codeup.springblog.models;

import javax.persistence.*;

@Entity //annotating that the POJOs are JPA entities
@Table(name="ads") //Table names are derived from the entity names(not sure why we did ads vs ad
public class Ad {
    @Id //annotating the entity that is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //how to generate an id for each row automatically
    private long id;

    @Column(nullable = false, length = 100) //used to specify the details of the column to which a field or property will be mapped
    private String title;

    @Column(nullable = false)
    private String description;

/** The mapping above is equivalent to the following MySQL table definition:*/
//CREATE TABLE ads (
//            id BIGINT NOT NULL AUTO_INCREMENT,
//            title VARCHAR(100) NOT NULL,
//    description VARCHAR(255) NOT NULL,
//    PRIMARY KEY (id)
//);

    public Ad() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
