package com.ricardo.controller;

import com.ricardo.Repository.CourseRepository;
import com.ricardo.model.Courses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CoursesController {

    private final CourseRepository courseRepository;

    @GetMapping
    public List<Courses> lis() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Courses> findById(@PathVariable @NotNull @Positive Long id) {
        return courseRepository.findById(id)
       .map(recordFound -> ResponseEntity.ok().body(recordFound)).
        orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Courses create(@RequestBody @Valid Courses course) {
        return courseRepository.save(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Courses> update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Courses course) {
        return courseRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(course.getName());
                    recordFound.setCategory(course.getCategory());
                    Courses updatedCourse = courseRepository.save(recordFound);
                    return ResponseEntity.ok().body(updatedCourse);
                }).
                orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @NotNull @Positive Long id) {
        return courseRepository.findById(id)
                .map(recordFound -> {
                    courseRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                }).
                orElse(ResponseEntity.notFound().build());
    }
}
