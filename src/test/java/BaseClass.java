import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void classLevelSetup() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(ConfClass.getProperty("url"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body//span[@class='b-header-b-logo-e-logo']")));
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
