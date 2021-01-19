package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;


public class AppTest 
{
    static WebDriver driver;

    /*@BeforeTest
    public void setUp()throws MalformedURLException {
        final String WEBDRIVER = "webdriver.chrome.driver";
        final String CHROME_DRIVER_LOCATION = "/home/david/Letöltések";
        System.setProperty(WEBDRIVER, CHROME_DRIVER_LOCATION);
        String nodeUrl = "https://seleniumhub.codecool.codecanvas.hu/wd/hub";
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.LINUX);

        driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
    }*/


    @Test
    public void shouldAnswerWithTrue() throws MalformedURLException {
        String nodeUrl = "https://selenium:CoolCanvas19.@seleniumhub.codecool.codecanvas.hu/wd/hub";
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
        String nodeUrl = "https://selenium:CoolCanvas19.@seleniumhub.codecool.codecanvas.hu/wd/hub";
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.LINUX);

        driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
        String practiceUrl = "https://www.google.com/";
        driver.get(practiceUrl);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        driver.quit();
        assertEquals(practiceUrl, currentUrl);
    }

    /*@AfterTest
    public void afterTest(){
        driver.quit();
    }*/
}


