package com.example.InyeccionMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import java.util.List;
import java.util.Optional;

/**
 * Main class for the Spring Boot application that interacts with MongoDB.
 * It implements CommandLineRunner to execute methods on startup.
 */
@SpringBootApplication
@EnableMongoRepositories
public class MdbSpringBootApplication implements CommandLineRunner {

    // Autowiring the StudentRepository to interact with the MongoDB
    @Autowired
    StudentRepository studentRepository;

    /**
     * Main method to run the Spring Boot application.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(MdbSpringBootApplication.class, args);
    }

    /**
     * Method that runs on application startup.
     * It performs various operations like creating/updating students,
     * retrieving students by different criteria, and displaying student count.
     * 
     * @param args Command line arguments
     */
    @Override
    public void run(String... args) {
        // Display message for creating or updating student items
        System.out.println("-----CREATE OR UPDATE STUDENT ITEMS-----\n");
        createOrUpdateStudent();

        // Display message for showing all students
        System.out.println("\n-----SHOW ALL STUDENTS-----\n");
        showAllStudents();

        // Display message for getting a student by name
        System.out.println("\n-----GET STUDENT BY NAME-----\n");
        getStudentByName("Alice");

        // Display message for getting students by program
        System.out.println("\n-----GET STUDENTS BY PROGRAM-----\n");
        getStudentsByProgram("Arts");

        // Display message for finding the final count of students
        System.out.println("\n-----FINAL COUNT OF STUDENTS-----\n");
        findCountOfStudents();

        // Final thank you message
        System.out.println("\n-----THANK YOU-----");
    }

    /**
     * Method to create or update multiple student records.
     */
    void createOrUpdateStudent() {
        System.out.println("Data creation or update started...");

        // Creating or updating students with sample data
        saveOrUpdateStudent("Alice", "Smith", "2001-01-01", "alice@student.com", "Software Engineering");
        saveOrUpdateStudent("Bob", "Richi", "1998-04-15", "bob@student.com", "Software Engineering");
        saveOrUpdateStudent("Mark", "Perez", "1999-06-21", "mark@student.com", "Arts");
        saveOrUpdateStudent("Rachel", "Adams", "2000-02-12", "rachel@student.com", "Laws");
        saveOrUpdateStudent("Fred", "Styles", "2001-07-30", "fred@student.com", "Software Engineering");

        System.out.println("Data creation or update complete...");
    }

    /**
     * Method to save or update a student record.
     * If the student already exists, it updates the record; otherwise, it creates a new record.
     * 
     * @param firstName The first name of the student
     * @param lastName The last name of the student
     * @param dateOfBirth The date of birth of the student
     * @param email The email of the student
     * @param program The program of the student
     */
    void saveOrUpdateStudent(String firstName, String lastName, String dateOfBirth, String email, String program) {
        Optional<Students> existingStudentOpt = studentRepository.findItemByName(firstName);

        Students student;
        if (existingStudentOpt.isPresent()) {
            // Update existing student record
            student = existingStudentOpt.get();
            student.setLastName(lastName);
            student.setDateOfBirth(dateOfBirth);
            student.setAge(Students.calculateAge(dateOfBirth)); // Call to static method to calculate age
            student.setEmail(email);
            student.setProgram(program);
        } else {
            // Create new student record
            student = new Students(firstName, lastName, Students.calculateAge(dateOfBirth), email, program, dateOfBirth);
        }

        // Save the student record to the database
        studentRepository.save(student);
    }

    /**
     * Method to show all student records.
     */
    public void showAllStudents() {
        studentRepository.findAll().forEach(student -> System.out.println(getStudentDetails(student)));
    }

    /**
     * Method to get a student by their first name.
     * 
     * @param name The first name of the student
     */
    public void getStudentByName(String name) {
        System.out.println("Getting student by name: " + name);
        Optional<Students> student = studentRepository.findItemByName(name);
        student.ifPresent(this::getStudentDetails);
    }

    /**
     * Method to get students by their program.
     * 
     * @param program The program of the students
     */
    public void getStudentsByProgram(String program) {
        System.out.println("Getting students for the program " + program);
        List<Students> list = studentRepository.findAll(program);
        list.forEach(student -> System.out.println("First Name: " + student.getFirstName() + ", Last Name: " + student.getLastName() + ", Email: " + student.getEmail()));
    }

    /**
     * Method to find the count of all student records.
     */
    public void findCountOfStudents() {
        long count = studentRepository.count();
        System.out.println("Number of students: " + count);
    }

    /**
     * Method to display the details of a student.
     * 
     * @param student The student object
     * @return An empty string
     */
    public String getStudentDetails(Students student) {
        System.out.println(
            "First Name: " + student.getFirstName() +
            ", \nLast Name: " + student.getLastName() +
            ", \nAge: " + student.getAge() +
            ", \nEmail: " + student.getEmail() +
            ", \nProgram: " + student.getProgram() +
            ", \nDate of Birth: " + student.getDateOfBirth()
        );
        return ""; // Assuming an empty string return for simplicity
    }
}
