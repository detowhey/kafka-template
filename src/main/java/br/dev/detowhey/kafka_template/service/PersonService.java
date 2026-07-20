package br.dev.detowhey.kafka_template.service;

import br.dev.detowhey.kafka_template.model.Person;
import br.dev.detowhey.kafka_template.repostiory.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person savePerson(Person person) {
        LOGGER.info("Save person with name {}", person.name());
        return personRepository.save(person);
    }
}
