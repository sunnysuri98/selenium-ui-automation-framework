package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfilePage {

    protected WebDriver driver;

    public UserProfilePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//nav[@class='header-nav']//a[@title='View my customer account']//span")
    private WebElement name;

    @FindBy(xpath = "//nav[@class='header-nav']//a[contains(normalize-space(),'Sign out')]")
    private WebElement signOutButton;

    @FindBy(xpath = "//div[@id='search_widget']//input[@placeholder='Search our catalog']")
    private WebElement searchBox;

    public String getName() {
        return name.getText();
    }

    public void clickOnSignoutButton() {
        signOutButton.click();
    }

    public void fillSearchBar(String text ){

        searchBox.clear();
        searchBox.sendKeys(text);
        searchBox.sendKeys(Keys.ENTER);
       

    }

}
