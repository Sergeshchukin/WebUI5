package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;



public class SecondTest {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        chromeOptions.addArguments("incognito");


        driver.get("https://author.today/");
        driver.findElement(By.xpath("//a[@onclick=\"app.showLoginModal();\"]")).click();
        driver.findElement(By.xpath("//input[@data-bind=\"textInput: login\"]")).sendKeys("sergeshukin@inbox.ru");
        driver.findElement(By.xpath("//input[@data-bind=\"textInput: password\"]")).sendKeys("Zecy4413");
        driver.findElement(By.xpath("//button[@data-bind=\"btn: processing\"]")).click();


        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[@class='avatar default-avatar']")).click();
        driver.findElement(By.xpath("//a[@href=\"/u/brat2_kv/posts/edit\"]")).click();
        driver.findElement(By.xpath("//a[@class=\"btn btn-gray btn-with-icon mr-sm\"]")).click();
        driver.findElement(By.xpath("//div[@class=\"fr-element fr-view\"]")).sendKeys("ololo123");
        driver.findElement(By.xpath("//button[@data-bind=\"btn: processing\"]")).click();

        driver.close();
        driver.quit();
    }
}
