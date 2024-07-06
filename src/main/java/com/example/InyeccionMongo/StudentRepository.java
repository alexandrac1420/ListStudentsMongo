package com.example.InyeccionMongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Student entities.
 * Extends MongoRepository to provide CRUD operations and custom query methods.
 */
public interface StudentRepository extends MongoRepository<Students, String> {

    /**
     * Custom query to find a student by their first name.
     * 
     * @param firstName The first name of the student.
     * @return An Optional containing the found student, if any.
     */
    @Query("{firstName:'?0'}")
    Optional<Students> findItemByName(String firstName);

    /**
     * Custom query to find all students in a specific program.
     * Only retrieves the first name, last name, and email of the students.
     * 
     * @param program The program of the students.
     * @return A list of students in the specified program.
     */
    @Query(value = "{program:'?0'}", fields = "{'firstName' : 1, 'lastName' : 1, 'email' : 1}")
    List<Students> findAll(String program);

    /**
     * Counts the total number of student records.
     * 
     * @return The count of student records.
     */
    long count();
}
