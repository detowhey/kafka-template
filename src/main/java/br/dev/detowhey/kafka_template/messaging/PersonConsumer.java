package br.dev.detowhey.kafka_template.messaging;

import br.dev.detowhey.kafka_template.converter.PersonConverter;
import br.dev.detowhey.kafka_template.dto.PersonDTO;
import br.dev.detowhey.kafka_template.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class PersonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonConsumer.class);

    private final PersonService personService;

    public PersonConsumer(PersonService personService) {
        this.personService = personService;
    }

    @Bean
    public Consumer<PersonDTO> registerNewPerson() {
        return personDTO -> {
            LOGGER.info("Received message with Person: {}", personDTO);
            var entity = PersonConverter.toEntity(personDTO);
            personService.savePerson(entity);
        };
    }
}
