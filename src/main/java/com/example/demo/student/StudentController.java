package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("api/vi/student")
    public List<Student> getStudents(){
    return studentService.getStudents();
    }


//    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("api/vi/student/{studentId}")
    public Optional<Student> getStudent (
            @PathVariable("studentId") Long stdId
    ) {
        return studentService.getOneStudent(stdId);
    }

    @PostMapping("api/vi/student")
    public void registerNewStudent(@RequestBody Student student){
    StudentService.addNewStudent(student);
    }

    @DeleteMapping("api/vi/student/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long stdId){
        studentService.deleteStudent(stdId);
    }

    @PutMapping("api/vi/student/{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long stdId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(stdId, name, email);
    }
}
