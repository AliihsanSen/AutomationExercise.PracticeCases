package AutomationExercise;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q03_LoginUser_Incorrect extends TestBase {

    @Test
    public void test1(){

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

        // 3. Verify that home page is visible successfully
        driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed();
        System.out.println("Home page is visible");

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // 5. Verify 'Login to your account' is visible
        WebElement loginAccountText = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginAccountText.isDisplayed());

        // 6. Enter correct email address and password (mail:ornek@gmail.com password:14785)
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("ornek@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("14785");

        // 7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        // 8. Verify error 'Your email or password is incorrect!' is visible
        WebElement text = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
        Assert.assertTrue(text.isDisplayed());
        System.out.println(text.getText());

    }
}
