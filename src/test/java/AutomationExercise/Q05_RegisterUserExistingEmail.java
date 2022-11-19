package AutomationExercise;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q05_RegisterUserExistingEmail extends TestBase {

    @Test
    public void name() {

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

        // 3. Verify that home page is visible successfully
        driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed();
        System.out.println("Home page is visible");

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // 5. Verify 'New User Signup!' is visible
        WebElement newUserSignup = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignup.isDisplayed());
        System.out.println("'" + newUserSignup.getText() + "' is visible");

        // 6. Enter name and already registered email address
        // Already name is : Ihsan
        // Already email is : test123@gmail.com
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Ihsan");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("test123@gmail.com");

        // 7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        // 8. Verify error 'Email Address already exist!' is visible
        WebElement alreadyExistText=driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
        Assert.assertTrue(alreadyExistText.isDisplayed());
        System.out.println("'"+alreadyExistText.getText()+"' is visible");
    }
}
