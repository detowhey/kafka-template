package br.dev.detowhey.kafka_template.converter;

import br.dev.detowhey.kafka_template.dto.PersonDTO;
import br.dev.detowhey.kafka_template.model.Person;

import java.time.LocalDateTime;

public class PersonConverter {

    private PersonConverter() {
    }

    public static Person toEntity(PersonDTO dto) {
        return Person.builder()
                .withAge(dto.age())
                .withName(dto.name())
                .withCreatedAt(LocalDateTime.now())
                .build();
    }
}
