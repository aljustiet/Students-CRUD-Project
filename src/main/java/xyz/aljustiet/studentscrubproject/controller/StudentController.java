package xyz.aljustiet.studentscrubproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.aljustiet.studentscrubproject.dto.StudentDto;
import xyz.aljustiet.studentscrubproject.model.Result;
import xyz.aljustiet.studentscrubproject.model.Student;
import xyz.aljustiet.studentscrubproject.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getOne(@PathVariable Integer id) {
        return studentService.getOne(id);
    }

    @PostMapping
    public Result create(@RequestBody StudentDto studentDto) {
        return studentService.create(studentDto);
    }

    @PutMapping("/{id}")
    public Result update(@RequestBody StudentDto studentDto, @PathVariable Integer id) {
        return studentService.update(studentDto, id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return studentService.delete(id);
    }
}