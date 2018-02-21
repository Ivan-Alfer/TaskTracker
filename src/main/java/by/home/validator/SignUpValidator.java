package by.home.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.home.entity.User;

@Component
public class SignUpValidator implements Validator{
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty", "firstName must not be empty.");
		String firstName = user.getFirstName();
		if ((firstName.length()) > 16) {
			errors.rejectValue("firstName", "firstName.tooLong", "firstName must not more than 16 characters.");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "surname.empty", "surname must not be empty.");
		String surname = user.getSurname();
		if ((surname.length()) > 16) {
			errors.rejectValue("surname", "surname.tooLong", "surname must not more than 16 characters.");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");
		if (!(user.getPassword()).equals(user.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "confirmPassword.passwordDontMatch", "Passwords don't match.");
		}
		
		if( !EmailValidator.getInstance().isValid( user.getEmail() ) ){
			errors.rejectValue("email", "email.notValid", "Email address is not valid.");
		}
		
	}
}