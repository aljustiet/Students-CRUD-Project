package xyz.aljustiet.studentscrubproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.aljustiet.studentscrubproject.dto.StudentDto;
import xyz.aljustiet.studentscrubproject.model.Result;
import xyz.aljustiet.studentscrubproject.model.Student;
import xyz.aljustiet.studentscrubproject.repository.StudentsRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentsRepo studentsRepo;

    public List<Student> getAll() {
        return studentsRepo.findAll();
    }

    public Student getOne(Integer id) {
        return studentsRepo.findById(id).get();
    }

    public Result create(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setAge(studentDto.getAge());

        studentsRepo.save(student);

        return new Result(true, "Student created");
    }

    public Result update(StudentDto studentDto, Integer id) {
        Optional<Student> byId = studentsRepo.findById(id);
        if (byId.isPresent()) {
            Student student = byId.get();
            student.setName(studentDto.getName());
            student.setEmail(studentDto.getEmail());
            student.setAge(studentDto.getAge());

            studentsRepo.save(student);

            return new Result(true, "Student updated");
        }
        return new Result(false, "Not found");
    }

    public Result delete(Integer id) {
        Optional<Student> byId = studentsRepo.findById(id);
        if ( byId.isPresent() ) {
            studentsRepo.deleteById(id);
            return new Result(true, "Deleted");
        }
        return new Result(false, "Not found");
    }
}