package br.dev.detowhey.kafka_template.converter;

import br.dev.detowhey.kafka_template.dto.PersonDTO;
import br.dev.detowhey.kafka_template.dto.PersonProcessedDTO;
import br.dev.detowhey.kafka_template.model.Person;

import java.time.LocalDateTime;

public class PersonConverter {

    private PersonConverter() {
    }

    public static Person toPerson(PersonDTO dto) {
        return Person.builder()
                .withAge(dto.age())
                .withName(dto.name())
                .withCreatedAt(LocalDateTime.now())
                .build();
    }

    public static PersonProcessedDTO toPersonProcessedDTO(Person person) {
        return PersonProcessedDTO.builder()
                .withId(person.id())
                .withAge(person.age())
                .withName(person.name())
                .withCreatedAt(person.createdAt())
                .build();
    }
}
