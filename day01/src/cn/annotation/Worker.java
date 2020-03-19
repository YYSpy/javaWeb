package cn.annotation;

@MyAnno(age = 12,per = Person.P1,anno2 = @MyAnno2,strs = {"2","3"})
@MyAnno3
public class Worker {


    @MyAnno3
   public void show(){};

}
