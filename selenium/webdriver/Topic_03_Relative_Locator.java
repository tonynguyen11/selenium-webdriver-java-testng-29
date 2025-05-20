package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_03_Relative_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Relative() {
        driver.get("https://demo.nopcommerce.com/login");

        //Login button
        By loginButtonBy = By.cssSelector("button.login-button");

        //Remember me checkbox
        By rememberMeCheckboxBy = By.id("RememberMe");

        //Forgot password link
        WebElement forgotPasswordLinkElement = driver.findElement(By.cssSelector("span.forgot-password"));

        //Password textbox
        By passwordTextboxBy = By.cssSelector("input#Password");

        //GUI (location / postion)
        WebElement rememberMeTexElement = driver
                .findElement(RelativeLocator.with(By.tagName("label"))
                .above(loginButtonBy)
                .toRightOf(rememberMeCheckboxBy)
                .toLeftOf(forgotPasswordLinkElement)
                .below(passwordTextboxBy)
                .near(forgotPasswordLinkElement));

        System.out.println("Text of Remember me checkbox: " + rememberMeTexElement.getText());

        //List elements
        List< WebElement> allLinks = driver.findElements(RelativeLocator.with(By.tagName("a")));




    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
