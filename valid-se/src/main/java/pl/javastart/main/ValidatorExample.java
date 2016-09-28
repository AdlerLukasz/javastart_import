package pl.javastart.main;

import java.time.Instant;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import pl.javastart.model.User;

public class ValidatorExample {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        User user = new User(null, 
                            new Date(Instant.now().toEpochMilli()), 
                            "123456789",
                            "John", 
                            "Doe", 
                            15, 
                            "blednyAdresEmail");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            System.out.printf("%s - %s (%s)\n", 
                    violation.getPropertyPath(),
                    violation.getInvalidValue(),
                    violation.getMessage());
        }
    }
}