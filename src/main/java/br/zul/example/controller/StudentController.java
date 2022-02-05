package br.zul.example.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.zul.example.domain.Student;
import br.zul.example.service.StudentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/students")
@RestController
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public ResponseEntity<Page<Student>> getAllStudents(Pageable pageable) {
        Page<Student> studentsPage = studentService.getStudentsPage(pageable);
        return ResponseEntity.ok(studentsPage);
    }

}
