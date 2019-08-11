package tests.web;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import static sun.audio.AudioDevice.device;

public class AndroidWebTest {
    private static String ACCESS_KEY = System.getenv(“SEETEST_IO_ACCESS_KEY”);
    private static final String CLOUD_URL = “https://cloud.seetest.io:443/wd/hub”;
    private static final String TITLE = “Testing Website on Android Chrome with Java”;
    private AndroidDriver driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(“testName”, TITLE);
        dc.setCapability(“accessKey”, ACCESS_KEY);
        dc.setBrowserName(MobileBrowserType.CHROME);
        driver = new AndroidDriver(new URL(CLOUD_URL), dc);
    }

    @Test
    public void testAppiumOnChrome() {
        driver.get(“https://amazon.com”);
        System.out.println(driver.getTitle());
        if (driver.getCapabilities().getCapability(“device.category”).equals(“TABLET”)) {
            driver.findElement(By.xpath(“//*[@name=’field-keywords’]”)).sendKeys(“iPhone”);
                    driver.findElement(By.xpath(“//*[@text=’Go’]”)).click();
        } else {
            driver.findElement(By.xpath(“//*[@name=’k’]”)).sendKeys(“iPhone”);
                    driver.findElement(By.xpath(“//*[@value=’Go’]”)).click();
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

