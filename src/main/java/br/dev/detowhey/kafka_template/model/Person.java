package br.dev.detowhey.kafka_template.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Person(
        @Id
        String id,
        String name,
        Integer age,
        LocalDateTime createdAt
) {
    public static Builder builder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return new Builder()
                .withId(this.id)
                .withName(this.name)
                .withAge(this.age)
                .withCreatedAt(createdAt);
    }

    public static class Builder {
        private String id;
        private String name;
        private Integer age;
        private LocalDateTime createdAt;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Person build() {
            return new Person(id, name, age, createdAt);
        }
    }
}
