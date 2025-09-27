package com.mystorev1;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import resources.ConfigReader;

public class TestBase {

    ConfigReader configReader = new ConfigReader();
    String url = configReader.getBaseUrl();
    String browserName = configReader.getbrowser();

    protected static WebDriver driver;
    protected static Logger log = LogManager.getLogger("mystorev1");

    public static WebDriver getDriver() {
        return driver;
    }

  @BeforeMethod
public void setup(ITestContext context) {
    boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));

    switch (browserName.toLowerCase()) {
        case "chrome":
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            if (isHeadless) {
                chromeOptions.addArguments("--headless=new");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--window-size=1920,1080");
            }
            driver = new ChromeDriver(chromeOptions);
            break;

        case "edge":
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions = new EdgeOptions();
            if (isHeadless) {
                edgeOptions.addArguments("--headless=new");
                edgeOptions.addArguments("--disable-gpu");
                edgeOptions.addArguments("--window-size=1920,1080");
            }
            driver = new EdgeDriver(edgeOptions);
            break;

        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (isHeadless) {
                firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("--width=1920");
                firefoxOptions.addArguments("--height=1080");
            }
            driver = new FirefoxDriver(firefoxOptions);
            break;

        default:
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
    }

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.get(url);

    context.setAttribute("driver", driver);

    log.info("Base URL is opened in " + browserName + (isHeadless ? " (headless)" : ""));
}


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
