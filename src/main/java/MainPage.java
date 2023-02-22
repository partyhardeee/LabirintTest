import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    public WebDriver driver;
    public static WebDriverWait wait;

    public MainPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//div[@class='b-header-b-menu-wrapper']//a[@href='/books/']")
    private WebElement books;

    @FindBy(xpath = "//div[@class='b-header-b-menu-wrapper']//a[@href='/foreignbooks/']")
    private WebElement foreignBooks;

    @FindBy(xpath = "//div[@class='b-header-b-menu-wrapper']//a[@href='/best/']")
    private WebElement best;

    @FindBy(xpath = "//div[@class='b-header-b-menu-wrapper']//a[@href='/best/']")
    private WebElement school;

    @FindBy(xpath = "//div[@class='b-header-b-menu-wrapper']//a[@href='/office/']")
    private WebElement office;

    @FindBy(xpath = "//div[@class='b-header-b-menu-wrapper']//a[@href='/games/']")
    private WebElement games;

    @FindBy(xpath = "//div[@class='b-header-b-menu-wrapper']//a[@href='/household/']")
    private WebElement household;

    public String booksLink(){
        books.click();
        return driver.getCurrentUrl();
    }
}
