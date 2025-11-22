package com.ricardo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
//@Table(name = "Course")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private long id;

    //@Column(name = "nome")
    @Column(length = 200,nullable = false)
    private String name;

    @Column(length = 50,nullable = false)
    private String category;

}
