package pl.javastart.main;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import pl.javastart.model.NumberBean;

public class Main {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
//        Locale.setDefault(Locale.GERMAN);
        
        NumberBean strBean = new NumberBean(2);
        Set<ConstraintViolation<NumberBean>> violations = validator.validate(strBean);
        for(ConstraintViolation<NumberBean> v : violations) {
            System.out.printf("%s - %s (%s)\n", 
                    v.getPropertyPath(),
                    v.getInvalidValue(),
                    v.getMessage());
        }
    }
}