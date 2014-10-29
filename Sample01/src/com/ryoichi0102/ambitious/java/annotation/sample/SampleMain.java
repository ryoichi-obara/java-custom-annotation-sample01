package com.ryoichi0102.ambitious.java.annotation.sample;

public class SampleMain {

	public static void main(String[] args) {

		// Formに値を詰めてabstractのvalidateメソッドが呼ばれるイメージ.
		SampleForm form = new SampleForm();
		form.setInputCode("XXX");
		form.validate();

		SampleForm f2 = new SampleForm();
		f2.setInputCode("あ");
		f2.validate();
	}

}
