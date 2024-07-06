package com.example.InyeccionMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller for managing student entities.
 * Provides endpoints to add a new student and retrieve all students.
 */
@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Endpoint to add a new student.
     * 
     * @param student The student object to be added.
     * @return The saved student object.
     */
    @PostMapping("/add")
    public Students addStudent(@RequestBody Students student) {
        // Calculate and set the age of the student based on their date of birth
        student.setAge(student.calculateAge(student.getDateOfBirth()));
        // Save the student object to the database
        return studentRepository.save(student);
    }

    /**
     * Endpoint to retrieve all students.
     * 
     * @return A list of all student objects.
     */
    @GetMapping("/all")
    public List<Students> getAllStudents() {
        // Retrieve and return all student objects from the database
        return studentRepository.findAll();
    }
}
