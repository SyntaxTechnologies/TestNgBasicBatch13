package class02;

import org.testng.annotations.Test;

public class priority {

    @Test(groups = "smoke")
    public void FirstTest(){
        System.out.println("hello! 1st test");

    }
    @Test()
    public void SecondTest(){

        System.out.println("hello! 2nd test");
    }

    @Test(priority = 2)
    public void ThirdTest(){

        System.out.println("hello! 3rd test");
    }

    @Test(priority=1)
    public void FourthTest(){
        System.out.println("hello! 4th test");
    }

}
//break till 1