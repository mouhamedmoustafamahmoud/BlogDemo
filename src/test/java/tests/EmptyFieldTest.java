package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.HomePage;

import java.time.Duration;

public class EmptyFieldTest extends TestBase {

    // Data-Driven Fake Data
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();

    HomePage homeObj;
    BlogPage blogObj;

    @Test(priority = 0)
    public void subscribe_With_All_Empty_Fields() throws InterruptedException {

        // Create Object from Home Page
        homeObj = new HomePage(driver);

        Thread.sleep(3000);

        // Accept the Cookies if exist
        if(homeObj.getAcceptCookiesBtn().isDisplayed()){
            homeObj.getAcceptCookiesBtn().click();
        }


        // Open Blog web page
        homeObj.getBlogLink().click();

        // Create Object from Blog page
        blogObj = new BlogPage(driver);

        // Wait Until (Subscribe Button) appears
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(blogObj.getSubscribeBtn()));

        // Click on Subscribe Button without any Data
        blogObj.getSubscribeBtn().click();

        // Validate Error Messages for all fields
        int noOfErrorMessages = blogObj.getErrorMessages().size();
        Assert.assertEquals(noOfErrorMessages, 3);

        // Redirect to Home Page
        blogObj.getHomePageLink().click();

    }

    @Test(priority = 1)
    public void subscribe_With_Empty_First_Name_Field() throws InterruptedException {

        // Wait Until Home Page load.
        Thread.sleep(3000);
        homeObj = new HomePage(driver);

        // Open Blog Web Page
        homeObj.getBlogLink().click();

        // Create an Object from Blog Page
        blogObj = new BlogPage(driver);


        // Wait 3 seconds until Subscription form appears
        Thread.sleep(3000);

        // Enter the Data
        blogObj.getLastNameTxtField().sendKeys(lastName);
        blogObj.getEmailTxtField().sendKeys(email);
        blogObj.getSubscribeBtn().click();

        // Validate First Name Error Message
        int noOfErrorMessages = blogObj.getErrorMessages().size();
        Assert.assertEquals(noOfErrorMessages, 1);
        Assert.assertTrue(blogObj.getErrorMessages().get(0).getText().contains("This field is required"));

        // Redirect to Home Page
        blogObj.getHomePageLink().click();

    }


    @Test(priority = 2)
    public void subscribe_With_Empty_Last_Name_Field() throws InterruptedException {

        // Wait Until Home Page Load
        Thread.sleep(3000);

        // Create Object from Home Page
        homeObj = new HomePage(driver);

        // Open Blog Web Page
        homeObj.getBlogLink().click();

        // Create Object from Blog Web Page
        blogObj = new BlogPage(driver);

        // Wait Until Subscription Form Appears
        Thread.sleep(3000);

        // Enter The Data
        blogObj.getFirstNameTxtField().sendKeys(firstName);
        blogObj.getEmailTxtField().sendKeys(email);
        blogObj.getSubscribeBtn().click();

        // Validate Last Name Error Message.
        int noOfErrorMessages = blogObj.getErrorMessages().size();
        Assert.assertEquals(noOfErrorMessages, 1);
        Assert.assertTrue(blogObj.getErrorMessages().get(0).getText().contains("This field is required"));

        // Redirect to The Home Page
        blogObj.getHomePageLink().click();

    }

    @Test(priority = 3)
    public void subscribe_With_Empty_Email_Field() throws InterruptedException {

        // Wait Until Home Page Load
        Thread.sleep(3000);

        // Create Object from the Home Page
        homeObj = new HomePage(driver);

        // Open Blog Web Page.
        homeObj.getBlogLink().click();

        // Craete Object from Blog Web Page.
        blogObj = new BlogPage(driver);

        // Wait Until Subscription Form Appears
        Thread.sleep(3000);

        // Enter The Data
        blogObj.getFirstNameTxtField().sendKeys(firstName);
        blogObj.getLastNameTxtField().sendKeys(lastName);
        blogObj.getSubscribeBtn().click();

        // Validate Email Error Page
        int noOfErrorMessages = blogObj.getErrorMessages().size();
        Assert.assertEquals(noOfErrorMessages, 1);
        Assert.assertTrue(blogObj.getErrorMessages().get(0).getText().contains("This field is required"));

        // Redirect to Home Page
        blogObj.getHomePageLink().click();

    }

}
