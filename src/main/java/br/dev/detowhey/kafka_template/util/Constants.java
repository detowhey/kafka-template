package br.dev.detowhey.kafka_template.util;

public class Constants {

    private Constants() {
    }

    public static final String MESSAGE_ERROR_PERSON_NAME = "The person's name violates business rules.";
    public static final String MESSAGE_ERROR_PERSON_AGE = "The person's age must be greater than 0.";
    public static final String MESSAGE_ERROR_NOT_NULL = "The property cannot be null.";
    public static final String MESSAGE_ERROR_NULL_OR_BLANK_PROPERTY = "The property cannot be null or blank";
}
