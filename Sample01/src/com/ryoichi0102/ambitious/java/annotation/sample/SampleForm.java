package com.ryoichi0102.ambitious.java.annotation.sample;

import com.ryoichi0102.ambitious.java.annotation.Validate;
import com.ryoichi0102.ambitious.java.annotation.Validate.ValidateType;

/**
 * <h3>
 *  StrutsのFormクラスみたいなものでの使用想定.
 * </h3>
 *
 * @author ryoichi-obara
 * @since 2014/10/30
 */
public class SampleForm extends AbstractBaseActionForm {

	@Validate(ValidateType.CODE)
	private String inputCode;

	// ----- Protected methods

	protected void validate() {
		// 基底クラスでアノテーションを処理してみる.
		super.validate();
	}

	// ----- Getters and Setters

	public String getInputCode() {
		return inputCode;
	}
	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}

}
