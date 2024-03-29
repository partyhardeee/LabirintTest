package tests;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssertions softAssertions;

    @BeforeEach
    public void classLevelSetup() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        softAssertions = new SoftAssertions();

        //Получение ссылки с POM в зависимости от профиля оставил, но можно прописать и в conf
        //driver.get(ConfClass.getProperty("url"));

        driver.get(System.getProperty("test.url"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Поиск по Лабиринту']")));

    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
