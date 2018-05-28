package ru.home.learning.validation.validators;

import ru.home.learning.qualifiers.USA;
import ru.home.learning.validation.constraints.ZipCode;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Реализация ограничения ZipCodeValidator
 * Created by YANesterov on 28.05.2018.
 */
public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {
    @Inject
    @USA
    private ZipCodeChecker checker;
    private Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");

    @Override
    public void initialize(ZipCode zipCode) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }
        Matcher matcher = zipPattern.matcher(value);
        if (!matcher.matches()) {
            return false;
        }
        return checker.isZipCodeValid(value);
    }
}
