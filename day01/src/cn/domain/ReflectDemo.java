package cn.domain;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        //1.Class.forName(全类名)
        Class<?> cls1 = Class.forName("cn.domain.Person");
        System.out.println(cls1);
        //2.类名.Class
        Class cls2 = Person.class;
        System.out.println(cls2);
        //3.对象.getClass()
        Person p =new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);

        System.out.println(cls1==cls2);
        System.out.println(cls3==cls2);
    }
}
