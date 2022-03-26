package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;


public class ThirdTest {
    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        chromeOptions.addArguments("incognito");


        driver.get("https://author.today/");
        driver.findElement(By.xpath("//a[@onclick=\"app.showLoginModal();\"]")).click();
        driver.findElement(By.xpath("//input[@data-bind=\"textInput: login\"]")).sendKeys("sergeshukin@inbox.ru");
        driver.findElement(By.xpath("//input[@data-bind=\"textInput: password\"]")).sendKeys("Zecy4413");
        driver.findElement(By.xpath("//button[@data-bind=\"btn: processing\"]")).click();
        ArrayList icons = (ArrayList) driver.findElements(By.xpath("//button[@class=\"btn btn-transparent btn-nav-add\"]"));
        Assertions.assertTrue(icons.size() > 0);

        driver.findElement(By.xpath("//div[@class='avatar default-avatar']")).click();
        driver.findElement(By.xpath("//a[@href=\"/u/sergeshukin/posts/edit\"]")).click();

        driver.findElement(By.xpath("//a[@class=\"btn btn-default mt-sm\"]")).click();
        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();
        driver.findElement(By.xpath("//a[@class=\"btn btn-default mt-sm\"]")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-gray btn-with-icon mt-lg']")).click();
        driver.findElement(By.xpath("//select[@name='PrivacyDisplay']")).click();
        driver.findElement(By.xpath("//select[@name='PrivacyDisplay']/option[2]")).click();
        driver.findElement(By.xpath("//span[@class='icon-check-bold']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Выберите от одного до трех редакторов']")).sendKeys("russia");
        driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__option--highlighted']")).click();
        driver.findElement(By.xpath("//i[@class='icon-cross']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-simple-danger mr']")).click();
        driver.findElement(By.xpath("//span[contains(text(),\"×\")]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-simple-danger mr']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-simple-danger ml-sm']")).click();



        driver.close();
        driver.quit();
    }
}
