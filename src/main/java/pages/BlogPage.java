package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BlogPage extends PageBase {

    // Elements
    @FindBy(id = "firstname")
    WebElement firstNameTxtField;

    @FindBy(id = "lastname")
    WebElement lastNameTxtField;

    @FindBy(id = "email")
    WebElement emailTxtField;

    @FindBy(id = "_form_5_submit")
    WebElement subscribeBtn;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div[1]/h1/a")
    WebElement homePageLink;

    @FindBy(css = "div._form-thank-you")
    WebElement successMsg;

    @FindBy(css = "div._error-inner")
    List<WebElement> errorMessages;


    // Getters
    public WebElement getFirstNameTxtField() {
        return firstNameTxtField;
    }

    public WebElement getLastNameTxtField() {
        return lastNameTxtField;
    }

    public WebElement getEmailTxtField() {
        return emailTxtField;
    }

    public WebElement getSubscribeBtn() {
        return subscribeBtn;
    }

    public WebElement getHomePageLink() {
        return homePageLink;
    }

    public WebElement getSuccessMsg() {
        return successMsg;
    }

    public List<WebElement> getErrorMessages() {
        return errorMessages;
    }


    // Constructor
    public BlogPage(WebDriver driver) {
        super(driver);
    }

    // Methods
    public void subscribe(String firstName, String lastName, String email){
        firstNameTxtField.sendKeys(firstName);
        lastNameTxtField.sendKeys(lastName);
        emailTxtField.sendKeys(email);
        subscribeBtn.click();
    }


}
