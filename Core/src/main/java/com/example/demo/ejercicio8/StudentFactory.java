package com.example.demo.ejercicio8;

public class StudentFactory {
    public Student getStudent(String name, String subject, String teacherName) {
        Student student = new Student();

        student.setName(name);
        student.setSubject(new Subject());
        student.getSubject().setName(subject);
        student.getSubject().setTeacher(new Teacher());
        student.getSubject().getTeacher().setName(teacherName);

        return student;
    }    
}
