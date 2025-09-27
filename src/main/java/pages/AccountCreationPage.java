package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage {

    protected WebDriver driver;

    public AccountCreationPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form[@id='customer-form']//input[@name='firstname']")
    private WebElement firstName;

    @FindBy(xpath = "//form[@id='customer-form']//input[@name='lastname']")
    private WebElement lastName;

    @FindBy(xpath = "//form[@id='customer-form']//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//form[@id='customer-form']//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//form[@id='customer-form']//label[contains(normalize-space(),'offers')]")
    private WebElement offersCheckBox;

    @FindBy(xpath = "//form[@id='customer-form']//label[contains(normalize-space(),'terms and conditions')]")
    private WebElement termsCheckbox;

    @FindBy(xpath = "//form[@id='customer-form']//button[normalize-space()='Save']")
    private WebElement submitButton;



    public void fillFirstName(String firstname) {
        firstName.sendKeys(firstname);
    }

    public void fillLastName(String lastname) {
        lastName.sendKeys(lastname);
    }

    public void fillemail(String Email) {
        email.sendKeys(Email);
    }

    public void fillPassword(String Password) {

        password.sendKeys(Password);

    }

    public void fillTermsCheckBox() {
        termsCheckbox.click();
    }

    public void fillOffersCheckBox() {
        offersCheckBox.click();
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

}
