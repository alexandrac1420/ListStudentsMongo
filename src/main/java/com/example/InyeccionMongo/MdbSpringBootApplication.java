package com.example.InyeccionMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableMongoRepositories
public class MdbSpringBootApplication implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(MdbSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("-----CREATE OR UPDATE STUDENT ITEMS-----\n");
        createOrUpdateStudent();

        System.out.println("\n-----SHOW ALL STUDENTS-----\n");
        showAllStudents();

        System.out.println("\n-----GET STUDENT BY NAME-----\n");
        getStudentByName("Alice");

        System.out.println("\n-----GET STUDENTS BY PROGRAM-----\n");
        getStudentsByProgram("Arts");

        System.out.println("\n-----FINAL COUNT OF STUDENTS-----\n");
        findCountOfStudents();

        System.out.println("\n-----THANK YOU-----");
    }

    void createOrUpdateStudent() {
        System.out.println("Data creation or update started...");

        saveOrUpdateStudent("Alice", "Smith", "2001-01-01", "alice@student.com", "Software Engineering");
        saveOrUpdateStudent("Bob", "Richi", "1998-04-15", "bob@student.com", "Software Engineering");
        saveOrUpdateStudent("Mark", "Perez", "1999-06-21", "mark@student.com", "Arts");
        saveOrUpdateStudent("Rachel", "Adams", "2000-02-12", "rachel@student.com", "Laws");
        saveOrUpdateStudent("Fred", "Styles", "2001-07-30", "fred@student.com", "Software Engineering");

        System.out.println("Data creation or update complete...");
    }

    void saveOrUpdateStudent(String firstName, String lastName, String dateOfBirth, String email, String program) {
        Optional<Students> existingStudentOpt = studentRepository.findItemByName(firstName);

        Students student;
        if (existingStudentOpt.isPresent()) {
            student = existingStudentOpt.get();
            student.setLastName(lastName);
            student.setDateOfBirth(dateOfBirth);
            student.setAge(Students.calculateAge(dateOfBirth)); // Llamada al método estático
            student.setEmail(email);
            student.setProgram(program);
        } else {
            student = new Students(firstName, lastName, Students.calculateAge(dateOfBirth), email, program, dateOfBirth);
        }

        studentRepository.save(student);
    }

    // READ
    public void showAllStudents() {
        studentRepository.findAll().forEach(student -> System.out.println(getStudentDetails(student)));
    }

    public void getStudentByName(String name) {
        System.out.println("Getting student by name: " + name);
        Optional<Students> student = studentRepository.findItemByName(name);
        student.ifPresent(this::getStudentDetails);
    }

    public void getStudentsByProgram(String program) {
        System.out.println("Getting students for the program " + program);
        List<Students> list = studentRepository.findAll(program);
        list.forEach(student -> System.out.println("First Name: " + student.getFirstName() + ", Last Name: " + student.getLastName() + ", Email: " + student.getEmail()));
    }

    public void findCountOfStudents() {
        long count = studentRepository.count();
        System.out.println("Number of students: " + count);
    }

    public String getStudentDetails(Students student) {
        System.out.println(
            "First Name: " + student.getFirstName() +
            ", \nLast Name: " + student.getLastName() +
            ", \nAge: " + student.getAge() +
            ", \nEmail: " + student.getEmail() +
            ", \nProgram: " + student.getProgram() +
            ", \nDate of Birth: " + student.getDateOfBirth()
        );
        return "";
    }
}
