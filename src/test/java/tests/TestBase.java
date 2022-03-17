package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBase {

    protected static WebDriver driver;

    @BeforeSuite
    @Parameters("browser")
    public void startUp(@Optional("chrome") String browserName){

        if(browserName.equalsIgnoreCase("chrome")) {
            String chromeDriverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")) {
            String firefoxDriverPath = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.navigate().to("https://blink22.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }


}
