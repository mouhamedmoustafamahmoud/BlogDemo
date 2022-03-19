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
    public void subscribe_With_All_Empty_Fields() {

        // Create Object from Home Page
        homeObj = new HomePage(driver);

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


    }

    @Test(priority = 1)
    public void subscribe_With_Empty_First_Name_Field() {

        // Create Object from the Home Page
        homeObj = new HomePage(driver);

        // Accept the Cookies if exist
        if(homeObj.getAcceptCookiesBtn().isDisplayed()){
            homeObj.getAcceptCookiesBtn().click();
        }

        // Open Blog Web Page
        homeObj.getBlogLink().click();

        // Create an Object from Blog Page
        blogObj = new BlogPage(driver);


        // Wait 3 seconds until Subscription form appears
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(blogObj.getSubscribeBtn()));

        // Enter the Data
        blogObj.getLastNameTxtField().sendKeys(lastName);
        blogObj.getEmailTxtField().sendKeys(email);
        blogObj.getSubscribeBtn().click();

        // Validate First Name Error Message
        int noOfErrorMessages = blogObj.getErrorMessages().size();
        Assert.assertEquals(noOfErrorMessages, 1);
        Assert.assertTrue(blogObj.getErrorMessages().get(0).getText().contains("This field is required"));


    }


    @Test(priority = 2)
    public void subscribe_With_Empty_Last_Name_Field() {

        // Create Object from Home Page
        homeObj = new HomePage(driver);

        // Accept the Cookies if exist
        if(homeObj.getAcceptCookiesBtn().isDisplayed()){
            homeObj.getAcceptCookiesBtn().click();
        }

        // Open Blog Web Page
        homeObj.getBlogLink().click();

        // Create Object from Blog Web Page
        blogObj = new BlogPage(driver);

        // Wait Until Subscribe Button Appears
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(blogObj.getSubscribeBtn()));

        // Enter The Data
        blogObj.getFirstNameTxtField().sendKeys(firstName);
        blogObj.getEmailTxtField().sendKeys(email);
        blogObj.getSubscribeBtn().click();

        // Validate Last Name Error Message.
        int noOfErrorMessages = blogObj.getErrorMessages().size();
        Assert.assertEquals(noOfErrorMessages, 1);
        Assert.assertTrue(blogObj.getErrorMessages().get(0).getText().contains("This field is required"));

    }

    @Test(priority = 3)
    public void subscribe_With_Empty_Email_Field() {

        // Create Object from the Home Page
        homeObj = new HomePage(driver);

        if (homeObj.getAcceptCookiesBtn().isDisplayed()){
            homeObj.getAcceptCookiesBtn().click();
        }

        // Open Blog Web Page.
        homeObj.getBlogLink().click();

        // Create Object from Blog Web Page.
        blogObj = new BlogPage(driver);

        // Wait Until Subscription Form Appears
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(blogObj.getSubscribeBtn()));

        // Enter The Data
        blogObj.getFirstNameTxtField().sendKeys(firstName);
        blogObj.getLastNameTxtField().sendKeys(lastName);
        blogObj.getSubscribeBtn().click();

        // Validate Email Error Page
        int noOfErrorMessages = blogObj.getErrorMessages().size();
        Assert.assertEquals(noOfErrorMessages, 1);
        Assert.assertTrue(blogObj.getErrorMessages().get(0).getText().contains("This field is required"));

    }

}
