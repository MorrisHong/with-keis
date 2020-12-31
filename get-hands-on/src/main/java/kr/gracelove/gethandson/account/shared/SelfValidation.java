package kr.gracelove.gethandson.account.shared;


import javax.validation.*;
import java.util.Set;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/29
 */

public abstract class SelfValidation<T> {

	private Validator validator;

	public SelfValidation() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	protected void validateSelf() {
		Set<ConstraintViolation<T>> violations = validator.validate((T) this);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
	}
}
