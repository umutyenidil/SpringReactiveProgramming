package com.umutyenidil.springreactiveprogramming.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    final StudentService studentService;

    @PostMapping
    Mono<Student> save(
            @RequestBody Student student
    ) {
        return studentService.save(student);
    }

    @GetMapping
    Flux<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    Mono<Student> findById(
            @PathVariable("id") Integer id
    ) {
        return studentService.findById(id);
    }
}
