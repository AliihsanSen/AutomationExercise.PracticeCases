package AutomationExercise;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q02_LoginUser_Correct extends TestBase {

    @Test
    public void test1() {

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

        // 6. Enter correct email address and password (mail:ornek@gmail.com password:123456)
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("ornek@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("123456");

        // 7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        // 8. Verify that 'Logged in as username' is visible
        WebElement loginUser = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(loginUser.isDisplayed());

        // 9. Click 'Delete Account' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();

        // 10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement deletedButton = driver.findElement(By.xpath("//h1"));
        String expectedDelete = "ACCOUNT DELETED!";
        String actualDelete = deletedButton.getText();
        Assert.assertNotEquals(expectedDelete, actualDelete);
        driver.findElement(By.xpath("//*[text()='Delete']")).click();
    }
}
