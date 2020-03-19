package cn.Test;

import cn.junit.Calculate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculateTestt {
    @Before
    public void init(){
        System.out.println("init...");
    }

    @After
    public void close(){
        System.out.println("close...");
    }

    @Test
    public void testAdd(){
        int a = new Calculate().add(2,1);
        System.out.println("testAdd");
        Assert.assertEquals(3,a);
    }

    @Test
    public void testSub(){
        int a = new Calculate().sub(2,1);
        System.out.println("testSub");
        Assert.assertEquals(1,a);
    }
}
