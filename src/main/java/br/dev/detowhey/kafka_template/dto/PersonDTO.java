package br.dev.detowhey.kafka_template.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import static br.dev.detowhey.kafka_template.util.Constants.*;

public record PersonDTO(
        @NotBlank(message = MESSAGE_ERROR_NULL_OR_BLANK_PROPERTY)
        @Size(min = 5, max = 80, message = MESSAGE_ERROR_PERSON_NAME)
        String name,
        @NotNull(message = MESSAGE_ERROR_NOT_NULL)
        @Positive(message = MESSAGE_ERROR_PERSON_AGE)
        Integer age
) {

    public static Builder builder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return new Builder()
                .withName(this.name)
                .withAge(this.age);
    }

    public static class Builder {
        private String name;
        private Integer age;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public PersonDTO build() {
            return new PersonDTO(name, age);
        }
    }
}
