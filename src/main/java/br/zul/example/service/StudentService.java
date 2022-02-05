package br.zul.example.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.zul.example.domain.Student;
import br.zul.example.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public Page<Student> getStudentsPage(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

}
