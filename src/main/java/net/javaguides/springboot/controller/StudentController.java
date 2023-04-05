package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8080/student1
    @GetMapping("student1")
    public Student getStudent() {
        Student student = new Student(
        665209,
        "Joanthony",
        "McGee"
        ); return student;
    }

    // http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(685990, "Cade", "Cruzen"));
        students.add(new Student(659348, "Derek", "Vega"));
        students.add(new Student(665209, "Joanthony", "McGee"));
        return students;
    }

    //Spring-boot REST API w/ @PathVariable as int
    // http://localhost:8080/students/678909
    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable("id") int id) {
        return new Student(id, "Brooks", "Dodson");
    }

    //Spring-boot REST API w/ @PathVariable w/ multiple parameters
    // http://localhost:8080/students/678909/firsName/lastName
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id")int studentId,
                                       @PathVariable("first-name") String firstName,
                                        @PathVariable("last-name") String lastName){
        return new Student(studentId,firstName,lastName);
    }

    // Spring-boot REST API with Request Param
    // http://localhost:8080/student/query?id=654321
    @GetMapping("student/query")
    public Student studentRequestParam(@RequestParam int id) {
        return new Student(id, "Lawson", "Maddings");
    }

    // Spring-boot REST API with Request Param with multiple parameters
    // http://localhost:8080/students/query?id=654321&firstName=Cade&lastName=Garcia
    @GetMapping("students/query")
    public Student studentRequestParamMulti(@RequestParam int id,
                                       @RequestParam String firstName,
                                       @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }

    //Spring-boot REST API that handles HTTP POST request
    //@PostMapping and @RequestBody
    // http://localhost:8080/students/create
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
//        System.out.println(student.getId());
//        System.out.println(student.getFirstName());
//        System.out.println(student.getLastName());
        student.getId();
        student.getFirstName();
        student.getLastName();
        return student;
    }

    //Spring-boot REST API that handles HTTP PUT request - updates the existing resource
    // http://localhost:8080/students/query?id=123456/update
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }


}
