package AutomationExercise;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Q07_VerifyTestCasesPage extends TestBase {

    @Test
    public void name() {

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed());

        // 4. Click on 'Test Cases' button
        driver.findElement(By.xpath("(//button[@class='btn btn-success'])[1]")).click();

        // 5. Verify user is navigated to test cases page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Test Cases']")).isDisplayed());

    }
}
