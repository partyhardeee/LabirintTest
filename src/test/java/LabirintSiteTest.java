import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LabirintSiteTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static MainPage mainPage;



    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.manage().window().maximize();
        driver.get("https://www.labirint.ru/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body//span[@class='b-header-b-logo-e-logo']")));
    }

    @Test
    public void test() {
        Assertions.assertTrue(mainPage.booksLink().contains("https://www.labirint.ru/books/"));
    }

    @AfterAll
    public static void close() {
        driver.close();
    }

}

