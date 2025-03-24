package xyz.aljustiet.studentscrubproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.aljustiet.studentscrubproject.model.Student;

public interface StudentsRepo extends JpaRepository<Student, Integer> {
}