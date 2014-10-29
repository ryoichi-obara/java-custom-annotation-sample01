java-custom-annotation-sample01
===============================

フィールドに付けられたAnnotationをvalidateメソッドで処理するサンプル.

StrutsのようなFormBeanのフィールドに
```Java
    @Validate(value=ValidateType.CODE)
    private String inputedCode;
```
とアノテーションを付けるだけで、その値の妥当性を定型的に検査するためのサンプル基盤実装です。
