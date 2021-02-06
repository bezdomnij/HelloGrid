package org.example.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverS {
    WebDriver driver = null;
    private static String theUrl = "http://localhost:4446/wd/hub";
    public static WebDriver instance = null;

    private WebDriverS() {
    }


    public static WebDriver getInstance(String browser){
//        String browser = System.getenv("BROWSER");
        System.out.println(browser);
        if (instance == null) {
//            String selPw = System.getenv("SEL_PW");
//            String beginning = "https://selenium:";
//            String end = "@seleniumhub.codecool.codecanvas.hu/wd/hub";
//            String nodeUrl = beginning + selPw + end;

            try {
                if (browser.equals("chrome")) {
                    instance = new RemoteWebDriver(new URL(theUrl), new ChromeOptions());
                } else if (browser.equals("firefox")) {
                    instance = new RemoteWebDriver(new URL(theUrl), new FirefoxOptions());
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}
