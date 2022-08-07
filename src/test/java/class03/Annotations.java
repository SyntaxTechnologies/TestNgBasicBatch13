package class03;

import org.testng.annotations.*;

public class Annotations {
    @BeforeSuite
    public void beforesuite(){
        System.out.println("i am before suit");
    }

    @AfterSuite
    public void aftersuit(){
        System.out.println("i am after suit");
    }

    @BeforeTest
    public void beforeTest(){

        System.out.println("i am before Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class");
    }

    @Test
    public void Atest(){
        System.out.println("i am Atest");
    }
    @Test
    public void Btest(){
        System.out.println("i am Btest");
    }


    @AfterClass
    public void afterclass(){
        System.out.println("i am after class");
    }
    @AfterTest
    public void afterTest(){

        System.out.println("i am after Test");
    }
}
