package br.zul.example.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import br.zul.example.domain.Student;
import br.zul.example.util.StudentCreator;

@DisplayName("Tests for StudentRepository")
@DataMongoTest
@ActiveProfiles("test")
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @DisplayName("findAll should return a Page of Student when successful")
    void findAll_ReturnsPageStudents_WhenSuccessful() {
        Page<Student> emptyStudentsPage = studentRepository.findAll(Pageable.unpaged());
        Assertions.assertThat(emptyStudentsPage.getSize()).isEqualTo(0);
        Student studentToBeSaved = StudentCreator.createStudentToBeSaved();
        Student savedStudent = studentRepository.save(studentToBeSaved);
        Page<Student> studentsPage = studentRepository.findAll(Pageable.unpaged());
        Assertions.assertThat(studentsPage.getSize()).isEqualTo(1);
        Student studentSaved = studentsPage.getContent().get(0);
        Assertions.assertThat(studentSaved.getId()).isEqualTo(savedStudent.getId());
    }

    @Test
    @DisplayName("findByEmail should return a Optional of Student when successful")
    void findByEmail_ReturnOptionalStudentWhenSuccessful() {

    }

}
