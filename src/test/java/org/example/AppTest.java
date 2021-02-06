package org.example;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AppTest {
    private WebDriver driver;
    private final String nodeUrl
            = "http://localhost:4446/wd/hub";
    private String browser;
    private DesiredCapabilities capabilities = null;

    @BeforeMethod
    private void setup() throws MalformedURLException {
        browser = System.getenv("BROWSER");
        if (browser.equals("chrome")) {
            capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.LINUX);
        } else if (browser.equals("firefox")) {
            capabilities = DesiredCapabilities.firefox();
            capabilities.setBrowserName("firefox");
            capabilities.setPlatform(Platform.LINUX);
        } else {
            System.out.println("No such browser");
            fail();
        }
        driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
    }

    @Test
    public void shouldAnswerWithTrue() {
        driver.manage().deleteAllCookies();
        String practiceUrl = "https://www.google.com/";
        driver.get(practiceUrl);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        driver.quit();
        assertEquals(practiceUrl, currentUrl);
    }

}


