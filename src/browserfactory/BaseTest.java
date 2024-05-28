package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Project-3 - ProjectName : com-herokuapp-sw-2
 * BaseUrl = http://the-internet.herokuapp.com/login
 * 1. Create the package ‘browserfactory’ and create the
 * class with the name ‘BaseTest’ inside the
 * ‘browserfactory’ package. And write the browser setup
 * code inside the class ‘Base Test’.
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 */
public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        // Launch the Chrome Browser
        driver = new ChromeDriver();
        // Open the URL into Browser
        driver.get(baseUrl);
        //Maximise Browser
        driver.manage().window().maximize();
        // We give Implicit wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser(){
        driver.quit();
    }
}
