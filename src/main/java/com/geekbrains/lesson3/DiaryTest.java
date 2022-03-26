package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DiaryTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://diary.ru/*");

        WebElement loginButton = driver.findElement(By.ByXPath("//a[.='Вход'"));
        loginButton.click();

        driver.findElement(By.id("loginform-username")).sendKeys("spartalex");
        driver.findElement(By.id("loginform-password")).sendKeys("123456");

        driver.switchTo().frame(driver.findElement(By.ByXPath("//iframe[@title='reCAPTCHA']")));
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-barder']")).click();
        driver.switchTo().parentFrame();

        driver.findElement(By.id("login_btn")).click();


        Thread.sleep(5000);
        driver.quit();


    }

}

