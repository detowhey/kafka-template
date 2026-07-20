package br.dev.detowhey.kafka_template.messaging;

import br.dev.detowhey.kafka_template.converter.PersonConverter;
import br.dev.detowhey.kafka_template.dto.PersonDTO;
import br.dev.detowhey.kafka_template.dto.PersonProcessedDTO;
import br.dev.detowhey.kafka_template.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.function.Function;

@Component
@Validated
public class PersonProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonProcessor.class);

    private final PersonService personService;

    public PersonProcessor(PersonService personService) {
        this.personService = personService;
    }

    @Bean
    public Function<PersonDTO, PersonProcessedDTO> processPerson() {
        return personDTO -> {
            LOGGER.info("Received message with Person: {}", personDTO);
            var entity = PersonConverter.toPerson(personDTO);
            entity = personService.savePerson(entity);
            return PersonConverter.toPersonProcessedDTO(entity);
        };
    }
}
