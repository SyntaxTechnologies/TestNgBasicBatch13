package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssertion {

//
//    navigate to syntaxhrms
//    1.we need to write test case to verify the wrong credentials
//    and give error message that is "Invalid credentials"
//    2. assert that username text box is displayed
//    quit the browser
WebDriver driver;
    //    navigate to syntax HRMS website
    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();;
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

    }
    @Test(groups = "regression")
    public  void invalidCredentials(){
        //finding the username text box
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        //send username
        username.sendKeys("WeatherMay");
        //        finding the password field
        WebElement pswrd = driver.findElement(By.xpath("//input[@id='txtPassword']"));
//        send password
        pswrd.sendKeys("abcdefgh");
//        finding the element login btn
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
//        click the login
        loginBtn.click();

//        get the element message invalid crdentials
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
//        extract the error message
        String errorText = errorMsg.getText();

//        expected text
        String expectedText="Invalid credentials";
        SoftAssert soft =new SoftAssert();
//        make sure error text is equal to expected text
        soft.assertEquals(errorText,expectedText);

//        get he webelement username from the website
        username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
//        is it displayed?
        boolean displayed = username.isDisplayed();

//        make sure the text box is dislplayed
        soft.assertTrue(displayed);

        soft.assertAll();

    }

    @AfterMethod(alwaysRun = true)
    public  void closeBrowser(){
        driver.quit();
    }
}
