package pl.javastart.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import pl.javastart.constraint.OddNumber;

public class OddNumberStringValidator implements ConstraintValidator<OddNumber, String>{

    @Override
    public void initialize(OddNumber constraintAnnotation) {
        //tutaj wyci�gamy informacje z adnotacji, np. warto�ci min/max
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Integer number = Integer.valueOf(value);
        return number % 2 == 0;
    }
}