package validator;

import model.Package;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import service.PackageDAO;

public class PackageValidator implements Validator {
        private PackageDAO packageDAO;

        public void setpackageDAO(PackageDAO packageDAO) {
            this.packageDAO = packageDAO;
        }
        
	@Override
	public boolean supports(Class<?> clazz) {
            return Package.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "quantity.required");
	}
}

