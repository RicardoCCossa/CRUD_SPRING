package com.ricardo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
//@Table(name = "Course")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private long id;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100,nullable = false)
    private String name;

    @NotNull
    @Length(max = 50)
    @Pattern(regexp = "Back-end|Front-end")
    @Column(length = 50,nullable = false)
    private String category;

}
