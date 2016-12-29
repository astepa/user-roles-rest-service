package app.validation;

import app.model.User;
import app.repository.RoleRepository;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {
    private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[A-Z]).{2,255})";

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty");
        User user = (User) target;
        validatePassword(user, errors);
        validateRoles(user, errors);
    }

    private void validateRoles(User user, Errors errors) {
        List<Long> roles = user.getRoles();
        if (roles == null || roles.isEmpty()) return;
        for (Long roleId : roles) {
            if (!roleRepository.exists(roleId)) {
                errors.rejectValue("roles", "roles.invalid");
            }
        }
    }

    private void validatePassword(User user, Errors errors) {
        String password = user.getPassword();
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        if (password==null||!pattern.matcher(password).matches())
            errors.rejectValue("password", "password.invalid");
    }
}
