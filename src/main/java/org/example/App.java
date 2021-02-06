package org.example;

import org.example.util.WebDriverS;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class App {
    public static void main( String[] args ) throws MalformedURLException, InterruptedException {
        System.out.println( "Hello World!" );
        String browser = System.getenv("BROWSER");
        WebDriver driver = WebDriverS.getInstance(browser);
        driver.get("http://google.com");
        TimeUnit.SECONDS.sleep(5);
        driver.quit();
    }
}
