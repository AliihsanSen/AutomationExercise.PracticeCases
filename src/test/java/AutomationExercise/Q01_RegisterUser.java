package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Q01_RegisterUser {

    WebDriver driver;
    Actions actions;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions = new Actions(driver);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void registerUser() throws InterruptedException {

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        String homePage = driver.findElement(By.xpath("//a[@style='color: orange;']")).getText();
        System.out.println("You are at " + homePage + " page");


        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        // 5. Verify 'New User Signup!' is visible
        WebElement userSignup = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        String expectedUser = "New User Signup!";
        String actualUser = userSignup.getText();
        Assert.assertEquals(actualUser, expectedUser);

        // 6. Enter name and email address
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Ali İhsan");
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("ornek07@gmail.com");

        // 7. Click 'Signup' button
        driver.findElement(By.xpath("//*[text()='Signup']")).click();

        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccount = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        String expectedUser1 = "ENTER ACCOUNT INFORMATION";
        String actualUser1 = enterAccount.getText();
        Assert.assertEquals(expectedUser1, actualUser1);

        // 9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.cssSelector("#id_gender1")).click();
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='password']"));
        actions.click(passwordBox).sendKeys("123456" + Keys.TAB)
                .sendKeys("5" + Keys.TAB)
                .sendKeys("June" + Keys.TAB)
                .sendKeys("1997")
                .perform();

        // 10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();

        // 11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();

        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@id='first_name']"));
        actions.click(firstNameBox).sendKeys("Ali İhsan" + Keys.TAB)
                .sendKeys("ŞEN" + Keys.TAB)
                .sendKeys("EV" + Keys.TAB)
                .sendKeys("Çaybaşı Mahhallesi" + Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("United States" + Keys.TAB)
                .sendKeys("Turkey" + Keys.TAB)
                .sendKeys("Konya" + Keys.TAB)
                .sendKeys("42100" + Keys.TAB)
                .sendKeys("050-12-47" + Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        // 13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        // 14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreated = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        String expectedUser2 = "ACCOUNT CREATED!";
        String actualUser2 = accountCreated.getText();
        Assert.assertEquals(expectedUser2, actualUser2);

        // 15. Click 'Continue' button
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

        // 16. Verify that 'Logged in as username' is visible
        WebElement loggedUsername = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        String expectedUsername = "Logged in as";
        String actualUsername = loggedUsername.getText();
        Assert.assertEquals(expectedUsername, actualUsername);

        // 17. Click 'Delete Account' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();

        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement deletedButton = driver.findElement(By.xpath("(//*[text()='Delete Account'])[2]"));
        String expectedDelete = "ACCOUNT DELETED!";
        String actualDelete = deletedButton.getText();
        Assert.assertNotEquals(expectedDelete, actualDelete);
        driver.findElement(By.xpath("//*[text()='Delete']")).click();

    }
}
