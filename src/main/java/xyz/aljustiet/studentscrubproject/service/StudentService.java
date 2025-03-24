package xyz.aljustiet.studentscrubproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.aljustiet.studentscrubproject.model.Student;
import xyz.aljustiet.studentscrubproject.repository.StudentsRepo;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentsRepo studentsRepo;

    public List<Student> getAll() {
        return studentsRepo.findAll();
    }

    public  Student getOne(Integer id) {
        return studentsRepo.findById(id).get();
    }
}