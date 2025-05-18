package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
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
        driver.get("https://demo.nopcommerce.com/register");
    }

    /*
        - Selenium version: 1.x / 2.x/ 3.x/ 4.x
        - There are 8 types of locators:
            + Id / Class / Name = corresponding HTML attributes
            + Tag name: HTML tag
            + Link text  / Partial link text: HTML tag <a> (anchor)
            + CSS selector / XPath
         - Selenium Locator = HTML Attribute
         - Id / Class / Name = corresponding HTML attributes

        Selenium version: 4.x: some locator support visualise testing: GUI
            - Class - Relative Locator
            - above / below / toLeftOf / toRightOf / near ...
        */

    @Test
    public void TC_01_ID() {
        driver.findElement(By.id("FirstName")).sendKeys("Automation");

    }

    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("Email"));
    }

    @Test
    public void TC_04_Tagname() {
        driver.findElement(By.tagName("input"));
    }

    @Test
    public void TC_05_LinkText() {
        driver.findElement(By.linkText("Shipping & returns"));
    }

    @Test
    public void TC_06_Partial_LinkText() {
        driver.findElement(By.partialLinkText("vendor account"));
    }

    @Test
    public void TC_07_Css() {
        // Css vs id
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));

        // Css vs class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        //Css vs name
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        //Css vs tagname
        driver.findElement(By.cssSelector("input"));

        //Css vs linktext
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));

        //Css vs partial linktext
        driver.findElement(By.cssSelector("a[href*='addresses']"));
        driver.findElement(By.cssSelector("a[href^='/customer/addresses']")); //beginning
        driver.findElement(By.cssSelector("a[href$='addresses']")); //end
    }

    @Test
    public void TC_08_XPath() {
        // Css vs id
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        // Css vs class
        driver.findElement(By.xpath("//div[@class='page-title']"));

        //Css vs name
        driver.findElement(By.xpath("//input[@name='FirstName']"));

        //Css vs tagname
        driver.findElement(By.xpath("//input"));

        //Css vs linktext
        driver.findElement(By.xpath("//a[@href='/customer/addresses']"));
        driver.findElement(By.xpath("//a[text()='Addresses']"));

        //Css vs partial linktext
        driver.findElement(By.xpath("//a[contains(@href,'addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));
    }


    @AfterClass
    public void afterClass() {
       // driver.quit();
    }
}
