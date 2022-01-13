package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
    return studentService.getStudents();
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping(path = "{studentId}")
    public Optional<Student> getStudent (
            @PathVariable("studentId") Long stdId
    ) {
        return studentService.getOneStudent(stdId);
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
    StudentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long stdId){
        studentService.deleteStudent(stdId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long stdId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(stdId, name, email);
    }
}
