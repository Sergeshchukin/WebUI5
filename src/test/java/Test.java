import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Test {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String BASE_URL = "https://www.film.ru/compilation/luchshie-multfilmy-disney";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(BASE_URL);
    }

    @Test
    void likeRandomFilmTest() {
        List<WebElement> filmsList = driver.findElements(By.xpath("//a[contains(@class, 'b-lazy') and (@class, 'b-loaded']"));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'b-lazy') and (@class, 'b-loaded']")));


        Boolean loginFrameAppeared = false;

        while (!loginFrameAppeared) {
            driver.findElement(By.xpath("//a[contains(@class, 'b-lazy') and (@class, 'b-loaded']")).click();
            if (driver.findElements(By.xpath("//iframe[contains(@src,'id.rambler.ru/login-20/')]")).size() > 0) {
                loginFrameAppeared = true;
            }
        }

        driver.findElement(By.xpath("//a[contains(@class, 'b-lazy') and (@class, 'b-loaded']")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'id.rambler.ru/login-20/')]")));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        Assertions.assertEquals(driver.findElement(By.id("login")).getText(), true);

        String a = "";
    }

    @Test
    void hoverItemTest() {
        actions.moveToElement(driver.findElement(By.xpath("//a[contains(@class, 'b-lazy') and (@class, 'b-loaded']")))
                .build()
                .perform();
        driver.findElement(By.xpath("//a[contains(@class, 'b-lazy') and (@class, 'b-loaded']")).click();
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.film.ru/compilation/luchshie-multfilmy-disney");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
