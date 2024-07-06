import React, { useEffect, useState } from 'react';
import StudentForm from './StudentForm';
import StudentList from './StudentList';
import axios from 'axios';

const App = () => {
    const [students, setStudents] = useState([]);

    useEffect(() => {
        fetchStudents(); // Llama a fetchStudents al montar el componente
    }, []); // Asegúrate de que useEffect se ejecute solo una vez al montar

    const fetchStudents = () => {
        axios.get('http://localhost:8080/api/students/all')
            .then(response => {
                setStudents(response.data);
            })
            .catch(error => {
                console.error(error);
            });
    };

    const handleStudentAdded = () => {
        fetchStudents(); // Llama a fetchStudents después de añadir un estudiante
    };

    return (
        <div>
            <StudentForm onStudentAdded={handleStudentAdded} />
            <StudentList students={students} />
        </div>
    );
};

export default App;
