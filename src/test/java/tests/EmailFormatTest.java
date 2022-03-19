package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.HomePage;

import java.time.Duration;

public class EmailFormatTest extends TestBase{

    HomePage homeObj;
    BlogPage blogObj;

    // Data-Driven (Used to create fake data)
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();

    // Invalid Email Format
    String email = "mouhamed123@gmail";


    @Test
    public void subscribe_With_Invalid_Email_Format() {

       // Create an object from HomePage
        homeObj = new HomePage(driver);

        // Accept the Cookies if exist
        if(homeObj.getAcceptCookiesBtn().isDisplayed()){
            homeObj.getAcceptCookiesBtn().click();
        }

        // Open Blog page by clicking on the Blog link
        homeObj.getBlogLink().click();

        // Create an object from Blog page
        blogObj = new BlogPage(driver);

        // Wait until (Subscribe Button) appears.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(blogObj.getSubscribeBtn()));

        // Enter the data
        blogObj.subscribe(firstName,lastName,email);

        // The Email Error Message
        String errorMsg = blogObj.getErrorMessages().get(0).getText();

        // Validate Email Format Error Message
        Assert.assertTrue(errorMsg.contains("Enter a valid email address"));


    }
}
