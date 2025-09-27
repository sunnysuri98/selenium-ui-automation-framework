package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    protected WebDriver driver;

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@class='js-address-form']//button[normalize-space()='Continue']")
    private WebElement continueButtonInsideAddressSection;

    @FindBy(xpath = "//section[@id='checkout-delivery-step']//button[normalize-space()='Continue']")
    private WebElement continueButtonInsideShippingSection;

    @FindBy(xpath = "//section[@id='checkout-payment-step']//span[normalize-space()='Pay by bank wire']/parent::label/parent::div/child::span/input")
    private WebElement payByBankWireRadioButton;

    @FindBy(xpath = "//section[@id='checkout-payment-step']//span[normalize-space()='Pay by Check']/parent::label/parent::div/child::span/input")
    private WebElement payByCheckRadioButton;

    @FindBy(xpath = "//input[contains(@id,'conditions_to_approve')]")
    private WebElement termsCheckbox;

    @FindBy(xpath = "//section[@id='checkout-payment-step']//button[normalize-space()='Place order']")
    private WebElement placeOrderButton;

    public void clickOncontinueButtonInsideAddressSection() {
        continueButtonInsideAddressSection.click();
    }

    public void clickOnontinueButtonInsideShippingSection() {
        continueButtonInsideShippingSection.click();
    }

    public void clickOnpayByBankWireRadioButton() {

        payByBankWireRadioButton.click();

    }

    public void clickOnpayByCheckRadioButton() {

        payByCheckRadioButton.click();

    }

    public void clcikOntermsCheckbox() {

        termsCheckbox.click();

    }

    public void clickOnPlaceOrderButton() {

        placeOrderButton.click();

    }

}
