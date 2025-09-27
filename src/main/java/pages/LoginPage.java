package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    protected WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form[@id='login-form']//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//form[@id='login-form']//input[@name='password']")
    private WebElement pass;

    @FindBy(xpath = "//form[@id='login-form']//button[@id='submit-login']")
    private WebElement logInButton;

    @FindBy(xpath = "//a[contains(normalize-space(),'No account? Create one here')]")
    private WebElement newAccountCreationButton;

    public void fillEmail(String emailAddress) {
        email.clear();
        email.sendKeys(emailAddress);

    }

    public void fillPassword(String password) {
        pass.clear();
        pass.sendKeys(password);

    }

    public void clickOnLoginButton() {

        logInButton.click();
    }

    public void clickOnnewAccountCreationButton() {
        newAccountCreationButton.click();
    }

}
