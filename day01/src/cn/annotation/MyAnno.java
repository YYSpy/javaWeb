package cn.annotation;


import cn.annotation.Person;

public @interface MyAnno {



    int age();
    String name()default "张三";

    Person per();
    MyAnno2 anno2();

    String[] strs();

}
