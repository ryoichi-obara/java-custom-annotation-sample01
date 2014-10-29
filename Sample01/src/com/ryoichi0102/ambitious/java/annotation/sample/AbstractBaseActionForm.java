package com.ryoichi0102.ambitious.java.annotation.sample;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.ryoichi0102.ambitious.java.annotation.Validate;

/**
 * <h3>
 *  フィールドに付けられたAnnotationをvalidateメソッドで処理するサンプル.
 * </h3>
 *
 * @author ryoichi-obara
 * @since 2014/10/30
 */
public class AbstractBaseActionForm { // extends ActionForm {

	@Validate
	protected String mode;

	// Non annotation fields.
	public String publicStringAtAbsForm;
	private String privateStringAtAbsForm;

	// ----- Protected methods

	protected void validate() {

		// 対象クラス(super抜き)のフィールド一覧を取得してアノテーションをチェック.
		Field[] fields = getClass().getDeclaredFields();
		for (Field f : fields) {
			Annotation[] annos = f.getDeclaredAnnotations();
			for (Annotation a : annos) {
				if (a instanceof Validate) {
					Validate vali = (Validate) a;

					// フィールド値を取得(String前提で書いてます.)
					String fieldValue = null;
					if (!Modifier.isPublic(f.getModifiers()) && !f.isAccessible()) {
						f.setAccessible(true);
					}
					try {
						fieldValue = f.get(this).toString();
					} catch (IllegalAccessException e) {
						System.out.println("IllegalAccess.");
					}

					System.out.println("Field " + f.getName() + "='" + fieldValue + "' has Validate annotation(" + vali.value() + ")");
				}
			}
		}
	}

	// ----- Getters and Setters

	public String getPublicStringAtAbsForm() {
		return publicStringAtAbsForm;
	}
	public void setPublicStringAtAbsForm(String publicStringAtAbsForm) {
		this.publicStringAtAbsForm = publicStringAtAbsForm;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getPrivateStringAtAbsForm() {
		return privateStringAtAbsForm;
	}
	public void setPrivateStringAtAbsForm(String privateStringAtAbsForm) {
		this.privateStringAtAbsForm = privateStringAtAbsForm;
	}

}
