import React from 'react';

const StudentList = ({ students }) => {
    return (
        <table>
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Date of Birth</th>
                    <th>Age</th>
                    <th>Email</th>
                    <th>Program</th>
                </tr>
            </thead>
            <tbody>
                {students.map(student => (
                    <tr key={student.id}>
                        <td>{student.firstName}</td>
                        <td>{student.lastName}</td>
                        <td>{student.dateOfBirth}</td>
                        <td>{student.age}</td>
                        <td>{student.email}</td>
                        <td>{student.program}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
};

export default StudentList;
