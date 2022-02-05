package br.zul.example.util;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.zul.example.domain.Address;
import br.zul.example.domain.Gender;
import br.zul.example.domain.Student;

public class StudentCreator {

    public static Student createStudentToBeSaved() {
        Address address = Address.builder()
                .country("England")
                .city("London")
                .postCode("NE9")
                .build();
        return Student.builder()
                .firstName("Jamila")
                .lastName("Ahmed")
                .email("jahmed@gmail.com")
                .gender(Gender.FEMALE)
                .address(address)
                .favouriteSubjects(List.of("Computer Science", "Maths"))
                .totalSpentInBooks(BigDecimal.TEN)
                .created(LocalDateTime.now())
                .build();
    }

}
