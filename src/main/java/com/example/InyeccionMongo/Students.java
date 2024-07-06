package com.example.InyeccionMongo;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("students")
public class Students {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String age; // Mantener este campo para datos existentes
    private String email;
    private String program;
    private String dateOfBirth; // Nuevo campo

    public Students() {}

    public Students(String firstName, String lastName, String age, String email, String program, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.program = program;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public static String calculateAge(String dateOfBirth) {
        LocalDate dob = LocalDate.parse(dateOfBirth);
        LocalDate currentDate = LocalDate.now();
        return String.valueOf(java.time.Period.between(dob, currentDate).getYears());
    }
}
