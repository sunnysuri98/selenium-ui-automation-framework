package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmedPage {

    protected WebDriver driver;

    public OrderConfirmedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@id='main']//h3[contains(@class,'h1')]")
    private WebElement orderConfirmed;

    public String getOrderConfirmedMessage() {
        return orderConfirmed.getText();
    }

}
