package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

    protected WebDriver driver;

    public ProductPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//select[@id='group_3']")
    private WebElement productDimension;

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    private WebElement quantity;

    @FindBy(xpath = "//div[@class='add']//button")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='modal-content']//div[@class='cart-content-btn']//a")
    private WebElement proceedToCheckOutButton;

    public void selectProductDimension(String dimension) {

        Select select = new Select(productDimension);

        select.selectByVisibleText(dimension);

    }

    public void fillProductQuanty(String no) {
        
        quantity.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        quantity.sendKeys(Keys.BACK_SPACE);
        quantity.sendKeys(no);

    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public void clickOnproceedToCheckoutButton(){
        proceedToCheckOutButton.click();
    }

}
