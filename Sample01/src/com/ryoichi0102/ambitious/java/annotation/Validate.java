package com.ryoichi0102.ambitious.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h3>
 * アノテーションの定義.
 * </h3>
 *
 * @see http://www.ne.jp/asahi/hishidama/home/tech/java/annotation.html
 * @author ryoichi-obara
 * @since 2014/10/24
 */
@Retention(RetentionPolicy.RUNTIME) // アノテーション情報をどこまで保持するかを指定。(RUNTIMEを指定すると実行時にもその値が渡され利用することができるようになる.)
@Target(ElementType.FIELD) //フィールドにだけ指定できるアノテーションであることは、このように定義する。
public @interface Validate {

	// 1.
	//   アノテーションの属性の型(メソッド戻り型にあたるもの)には、
	//   プリミティブ型, String, Class, アノテーション, enum, その1次元配列のみが定義できる. (BigDecimalとかはできない)
	// 2.
	//   value()メソッドは @Validate(value=ValidateType.CODE) と書かずに
	//   @Validate(ValidateType.CODE) のように省略できる。
	// 3.
	//   default指定もできる。
	ValidateType value() default ValidateType.CODE;

	public enum ValidateType {
		CODE, INTEGRAL, DECIMAL, DATE, TIMESTAMP;
	}

}
