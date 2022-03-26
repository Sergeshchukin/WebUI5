package com.geekbrains.lesson3;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;


public class SetupDriverExamples{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");
        //chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");
        Thread.sleep(5000);

        //((JavascriptExecutor)driver).executeScript("window.open()");

        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(3000);

        List<String> tabs = new ArrayList<>(driver.getWindowHandle());
        driver.switchTo().window(tabs.get(1));

        driver.close();

        driver.quit();


    }
}
