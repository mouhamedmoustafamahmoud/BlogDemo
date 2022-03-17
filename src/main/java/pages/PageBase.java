package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    // Fields
    protected WebDriver driver;

    // Constructor
    public PageBase(WebDriver driver) {
        this.driver = driver;

        // Find the elements exist in a web page.
        PageFactory.initElements(driver,this);
    }
}
