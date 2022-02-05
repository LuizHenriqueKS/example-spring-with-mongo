package br.zul.example.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.zul.example.domain.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

    Page<Student> findAll(Pageable page);

    Optional<Student> findByEmail(String email);

}
