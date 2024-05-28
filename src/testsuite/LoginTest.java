package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project_3_browserfactory.BaseTest;

/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username
 * is invalid!”
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password
 * is invalid!”
 */
public class LoginTest extends BaseTest {

    static String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUpBrowser(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        WebElement element = driver.findElement(By.xpath("//button[@class='radius']"));
        element.click();
        String actualText = "Secure Area";
        String expectedText = driver.findElement(By.xpath("//h2[text() = ' Secure Area']")).getText();
        Assert.assertEquals("User should not login with valid credentials.", expectedText, actualText);
    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        WebElement element = driver.findElement(By.xpath("//button[@class='radius']"));
        element.click();
        String actualText = "Your username is invalid!\n" +
                "×";
        String expectedText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        Assert.assertEquals("User should not login with invalid credentials.", expectedText, actualText);

    }

    @Test
    public void verifyThePasswordErrorMessage(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        WebElement element = driver.findElement(By.xpath("//button[@class='radius']"));
        element.click();
        String actualText = "Your password is invalid!\n" +
                "×";
        String expectedText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        Assert.assertEquals("User should not login with invalid credentials.", expectedText, actualText);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
