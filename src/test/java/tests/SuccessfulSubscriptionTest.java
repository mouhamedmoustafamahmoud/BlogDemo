package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.HomePage;

import java.time.Duration;

public class SuccessfulSubscriptionTest extends TestBase{

    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();

    HomePage homeObj;
    BlogPage blogObj;

    @Test
    public void subscribe_With_All_Valid_Data() throws InterruptedException {

        // Create Object from Home Page
        homeObj = new HomePage(driver);



        // Accept the Cookies if exist
        if(homeObj.getAcceptCookiesBtn().isDisplayed()){
            homeObj.getAcceptCookiesBtn().click();
        }



        // Open Blog web page
        homeObj.getBlogLink().click();

        // Create Object from Blog Page
        blogObj = new BlogPage(driver);

        // Wait until (Subscribe Button ) appears
        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(7));
        wait1.until(ExpectedConditions.visibilityOf(blogObj.getSubscribeBtn()));

        // Enter Valid Credentials
        blogObj.subscribe(firstName,lastName,email);

        // Wait until Success Message Appears and Print it
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.visibilityOf(blogObj.getSuccessMsg()));
        System.out.println(blogObj.getSuccessMsg().getText());

        // Validate Success Message
        Assert.assertTrue(blogObj.getSuccessMsg().getText().contains("Thanks"));

        // Redirect to Home Page
        blogObj.getHomePageLink().click();
    }
}
