package jp.co.kenshu.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.kenshu.validator.annotation.Memo;

public class MemoValidator implements ConstraintValidator<Memo, String>{

	private int maxValue;

	@Override
	public void initialize(Memo memo) {
		this.maxValue = memo.value();
	}

	@Override
	public boolean isValid(String input, ConstraintValidatorContext con) {
		if (input == null) {
			return false;
		}
		if (input.matches("^[0-9]*$")) {
			return false;
		}
		if(maxValue < input.length()) {
			return false;
		}
		return true;
	}
}
