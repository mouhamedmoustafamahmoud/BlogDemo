package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.HomePage;

import java.time.Duration;

public class PlaceHolderTest extends TestBase {

    HomePage homeObj;
    BlogPage blogObj;

    @Test
    public void verify_PlaceHolders_Of_Fields() {

        // Expected Placeholders
        String expectedFirstNamePlaceHolder = "Your first name...";
        String expectedLastNamePlaceHolder = "Your last name...";
        String expectedEmailPlaceHolder = "Your email...";

        // Create Object from the Home Page
        homeObj = new HomePage(driver);

        // Accept the Cookies if exist
        if(homeObj.getAcceptCookiesBtn().isDisplayed()){
            homeObj.getAcceptCookiesBtn().click();
        }

        // Open Blog Web Page
        homeObj.getBlogLink().click();

        // Create Object from Blog Web Page
        blogObj = new BlogPage(driver);

        // Wait Until (Subscribe Button) appears
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOf(blogObj.getSubscribeBtn()));

        // Actual Placeholders
        String actualFirstNamePlaceHolder = blogObj.getFirstNameTxtField().getAttribute("placeholder");
        String actualLastNamePlaceHolder = blogObj.getLastNameTxtField().getAttribute("placeholder");
        String actualEmailPlaceHolder = blogObj.getEmailTxtField().getAttribute("placeholder");

        // Print Actual Placeholders
        System.out.println("First Name Place Holder : " + actualFirstNamePlaceHolder);
        System.out.println("Last Name Place Holder : " + actualLastNamePlaceHolder);
        System.out.println("Email Place Holder : " + actualEmailPlaceHolder);

        // Validate the Placeholders
        Assert.assertEquals(actualFirstNamePlaceHolder,expectedFirstNamePlaceHolder);
        Assert.assertEquals(actualLastNamePlaceHolder,expectedLastNamePlaceHolder);
        Assert.assertEquals(actualEmailPlaceHolder,expectedEmailPlaceHolder);


    }
}
