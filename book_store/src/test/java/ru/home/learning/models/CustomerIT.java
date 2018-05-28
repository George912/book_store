package ru.home.learning.models;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Интеграционный тест CustomerIT
 * Created by YANesterov on 28.05.2018.
 */
public class CustomerIT {
    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void init() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @After
    public void close() {
        validatorFactory.close();
    }

    @Test
    public void shouldRaiseNoConstraintViolation() {
        Customer customer = new Customer("John", "Smith", "jsmith@gmail.com");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(0, violations.size());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseInvalidEmail() {
        Customer customer = new Customer("John", "Smith", "DummyEmail");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(1, violations.size());
        assertEquals("invalid email address", violations.iterator().next().getMessage());
        assertEquals("dummy", violations.iterator().next().getInvalidValue());
        assertEquals("{ru.home.learning.validation.constraints.Email.message}", violations.iterator().next().getMessageTemplate());
    }
}
