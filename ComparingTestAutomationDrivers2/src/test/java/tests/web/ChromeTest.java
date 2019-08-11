package tests.web;

import java.net.URL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeTest {
    private static final String ACCESS_KEY = System.getenv(“SEETEST_IO_ACCESS_KEY”);
    private static final String CLOUD_URL = “https://cloud.seetest.io/wd/hub/”;
    private static final String TITLE = “Selenium Test on Chrome”;
    private RemoteWebDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        dc.setCapability(“accessKey”, ACCESS_KEY);
        dc.setCapability(“generateReport”, true);
        dc.setCapability(“testName”, TITLE);
        driver = new RemoteWebDriver(new URL(CLOUD_URL), dc);
    }

    @Test
    public void testSeleniumOnChrome() {
        driver.get(“https://seetest.io”);
        System.out.println(driver.getTitle());

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(“//*[text()=’Manual’]”)));



                WebElement manualNavLink = driver.findElement(By.xpath(“//*[text()=’Manual’]”));
                        manualNavLink.click();
        WebElement automationNavLink = driver.findElement(By.xpath(“//*[text()=’Automation’]”));
                automationNavLink.click();
        WebElement webinarFooterLink = driver.findElement(By.xpath(“//*[text()=’Webinars’]”));
                webinarFooterLink.click();



        String webinarH2TitleText = driver.findElement(By.xpath(“//h2[1]”)).getText();
                System.out.println(“The title of the first h2 is: ” + webinarH2TitleText);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}