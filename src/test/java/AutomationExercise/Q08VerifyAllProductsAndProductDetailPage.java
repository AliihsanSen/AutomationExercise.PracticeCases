package AutomationExercise;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Q08VerifyAllProductsAndProductDetailPage extends TestBase {

    @Test
    public void name() throws InterruptedException {

        //  1. Launch browser
        //  2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //  3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed());

        //  4. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        //  5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());

        //  6. The products list is visible


        //  7. Click on 'View Product' of first product

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//a[text()='View Product'])[1]")).click();

        //  8. User is landed to product detail page
        System.out.println("User is " + driver.getTitle());

        //  9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product-information']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//div[@class='product-information']")).getText());
    }
}
