package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;



public class FirstTest {
    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        chromeOptions.addArguments("incognito");


        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://author.today/");
        driver.findElement(By.xpath("//a[@onclick=\"app.showLoginModal();\"]")).click();
        driver.findElement(By.xpath("//input[@data-bind=\"textInput: login\"]")).sendKeys("sergeshukin@inbox.ru");
        driver.findElement(By.xpath("//input[@data-bind=\"textInput: password\"]")).sendKeys("Zecy4413");
        driver.findElement(By.xpath("//button[@data-bind=\"btn: processing\"]")).click();
        ArrayList icons = (ArrayList) driver.findElements(By.xpath("//button[@class=\"btn btn-transparent btn-nav-add\"]"));
        Assertions.assertTrue(icons.size() > 0);

        driver.findElement(By.xpath("//button[@class=\"btn btn-transparent btn-nav-add\"]")).click();
        driver.findElement(By.xpath("//a[@href='/post/create']")).click();


        driver.close();
        driver.quit();
    }
    }





}
