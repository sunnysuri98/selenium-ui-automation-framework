package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

      protected WebDriver driver;

    public CartPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[contains(@class,'cart-summary')]/descendant::a[normalize-space()='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;


     public void clickOnproceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }
    
}
