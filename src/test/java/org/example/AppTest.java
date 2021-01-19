package org.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {
    static WebDriver driver;
    private final String nodeUrl
            = "https://selenium:CoolCanvas19.@seleniumhub.codecool.codecanvas.hu/wd/hub";

    @Test
    public void shouldAnswerWithTrue() throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
        String practiceUrl = "https://www.google.com/";
        driver.get(practiceUrl);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        driver.quit();
        assertEquals(practiceUrl, currentUrl);
    }

    @Test
    public void shouldAnswerWithTrue2() throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
        String practiceUrl = "https://www.bbc.com/";
        driver.get(practiceUrl);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        driver.quit();
        assertEquals(practiceUrl, currentUrl);
    }
}


