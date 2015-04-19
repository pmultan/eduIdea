package sk.revolone.eduidea.utils.validation;

import sk.revolone.eduidea.utils.validation.FieldMatch;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements
		ConstraintValidator<FieldMatch, Object> {
	private String firstFieldName;
	private String secondFieldName;

	@Override
	public void initialize(final FieldMatch constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
	}

	@Override
	public boolean isValid(final Object value,
			final ConstraintValidatorContext context) {
		try {
			final Object firstObj = BeanUtils
					.getProperty(value, firstFieldName);
			final Object secondObj = BeanUtils.getProperty(value,
					secondFieldName);

			boolean result = firstObj == null && secondObj == null
					|| firstObj != null && firstObj.equals(secondObj);
			if (!result) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(
						"Fields do not match").addNode(secondFieldName)
						.addConstraintViolation();
			}
			return result;
		} catch (final Exception ignore) {
			// ignore
		}
		return true;
	}
}
