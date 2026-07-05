package br.dev.detowhey.kafka_template.repostiory;

import br.dev.detowhey.kafka_template.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
