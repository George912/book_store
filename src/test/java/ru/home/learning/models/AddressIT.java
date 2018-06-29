package ru.home.learning.models;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Интеграционный тест AddressIT
 * Created by YANesterov on 28.05.2018.
 */
public class AddressIT {
    @Test
    public void shouldRaiseConstraintViolationCauseInvalidZipCode() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Address address = new Address("233 Стрит", "Нью-Йорк", "NY", "DummyZip", "США");
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertEquals(1, violations.size());
        validatorFactory.close();
    }
}
