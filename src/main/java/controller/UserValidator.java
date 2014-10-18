package controller;


import model.UserWithValidatorWay;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserWithValidatorWay.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserWithValidatorWay user = (UserWithValidatorWay) target;

        ValidationUtils.rejectIfEmpty(errors, "email", "user.email.empty");
        if(user.getPassword() == null || "".equals(user.getPassword())){
            errors.rejectValue("password", "user.password.empty");
        }
    }
}
