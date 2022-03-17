package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {


    //Elements
    @FindBy(css = "button.btn.btn-block.accept-cookies")
    WebElement acceptCookiesBtn;

    @FindBy(linkText = "Blog")
    WebElement blogLink;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div[1]/h1/a")
    WebElement homePageLink;

    // Getters
    public WebElement getAcceptCookiesBtn() {
        return acceptCookiesBtn;
    }

    public WebElement getBlogLink() {
        return blogLink;
    }

    public WebElement getHomePageLink() {
        return homePageLink;
    }


    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }





}
