package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private static StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email already exist!");
        }
        studentRepository.save(student);

        System.out.println(student);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getOneStudent(Long stdId){
        return studentRepository.findById(stdId);
    }


    public void deleteStudent(Long stdId) {
        if(!studentRepository.existsById(stdId)){
            throw new IllegalStateException("Student with id "+ stdId+" does not exists!");
        }
        studentRepository.deleteById(stdId);
    }

    @Transactional
    public void updateStudent(Long stdId, String name, String email) {
    Student student = studentRepository.findById(stdId).orElseThrow(()-> new IllegalStateException(
            "Student with ID " +stdId+" does not exist"
    ));
    if (name != null && name.length()>0 && !Objects.equals(student.getName(), name)){
        student.setName(name);
    }
        if (email != null && email.length()>0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email already taken!");
            }
            student.setEmail(email);
        }
    }
}
