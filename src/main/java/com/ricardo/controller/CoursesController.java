package com.ricardo.controller;

import com.ricardo.Repository.CourseRepository;
import com.ricardo.model.Courses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CoursesController {

    private final CourseRepository courseRepository;

    @GetMapping
    public List<Courses> lis() {
        return courseRepository.findAll();
    }
}
