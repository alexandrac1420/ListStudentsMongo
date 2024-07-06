import React, { useState } from 'react';
import axios from 'axios';

const StudentForm = ({ onStudentAdded }) => {
    const [student, setStudent] = useState({
        firstName: '',
        lastName: '',
        dateOfBirth: '',
        email: '',
        program: ''
    });

    const handleChange = (e) => {
        setStudent({ ...student, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/students/add', student)
            .then(response => {
                console.log(response.data);
                onStudentAdded(); // Llama a la función para actualizar la lista de estudiantes
                // Limpiar el formulario después de añadir el estudiante
                setStudent({
                    firstName: '',
                    lastName: '',
                    dateOfBirth: '',
                    email: '',
                    program: ''
                });
            })
            .catch(error => {
                console.error(error);
            });
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label htmlFor="firstName">First Name:</label>
                <input type="text" id="firstName" name="firstName" value={student.firstName} onChange={handleChange} required />
            </div>
            <div>
                <label htmlFor="lastName">Last Name:</label>
                <input type="text" id="lastName" name="lastName" value={student.lastName} onChange={handleChange} required />
            </div>
            <div>
                <label htmlFor="dateOfBirth">Date of Birth:</label>
                <input type="date" id="dateOfBirth" name="dateOfBirth" value={student.dateOfBirth} onChange={handleChange} required />
            </div>
            <div>
                <label htmlFor="email">Email:</label>
                <input type="email" id="email" name="email" value={student.email} onChange={handleChange} required />
            </div>
            <div>
                <label htmlFor="program">Program:</label>
                <input type="text" id="program" name="program" value={student.program} onChange={handleChange} required />
            </div>
            <button type="submit">Add Student</button>
        </form>
    );
};

export default StudentForm;
