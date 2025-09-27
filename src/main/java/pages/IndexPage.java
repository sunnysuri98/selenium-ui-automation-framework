package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    protected WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//nav[@class='header-nav']//a[@title='Log in to your customer account']")
    private WebElement signInButton;

    public void clickOnsignInButton() {
        signInButton.click();
    }

}
