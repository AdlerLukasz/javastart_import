package pl.javastart.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pl.javastart.constraint.OddNumber;

public class OddNumberValidator implements ConstraintValidator<OddNumber, Integer>{

    @Override
    public void initialize(OddNumber constraintAnnotation) {
        //tutaj wyci¹gamy informacje z adnotacji, np. wartoœci min/max
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value % 2 == 0;
    }
}