package pl.javastart.main;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import pl.javastart.model.NumberBean;
import pl.javastart.model.StringBean;

public class Main {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        NumberBean bean = new NumberBean(10);
        Set<ConstraintViolation<NumberBean>> violations = validator.validate(bean);
        for(ConstraintViolation<NumberBean> v : violations) {
            System.out.printf("%s - %s (%s)\n", 
                    v.getPropertyPath(),
                    v.getInvalidValue(),
                    v.getMessage());
        }
        
        StringBean strBean = new StringBean("9");
        Set<ConstraintViolation<StringBean>> violations2 = validator.validate(strBean);
        for(ConstraintViolation<StringBean> v : violations2) {
            System.out.printf("%s - %s (%s)\n", 
                    v.getPropertyPath(),
                    v.getInvalidValue(),
                    v.getMessage());
        }
    }
}
