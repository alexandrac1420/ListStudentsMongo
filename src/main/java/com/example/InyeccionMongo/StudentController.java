package com.example.InyeccionMongo;

import com.example.InyeccionMongo.Students;
import com.example.InyeccionMongo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/add")
    public Students addStudent(@RequestBody Students student) {
        student.setAge(student.calculateAge(student.getDateOfBirth()));
        return studentRepository.save(student);
    }

    @GetMapping("/all")
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }
}
