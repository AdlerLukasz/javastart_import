package pl.javastart.constraint;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

import pl.javastart.validator.OddNumberStringValidator;
import pl.javastart.validator.OddNumberValidator;
 
@Documented
@Constraint(validatedBy = {OddNumberValidator.class, OddNumberStringValidator.class})
@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface OddNumber {
    String message() default "Number should be odd";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
