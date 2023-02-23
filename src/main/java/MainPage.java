import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    @FindBy(xpath = "//div[@class='b-header-b-menu-wrapper']//a[@href='/school/']")
    private WebElement school;

    @FindBy(xpath = "//div[@class='b-header-b-menu-wrapper']//a[@href='/office/']")
    private WebElement office;

    @FindBy(xpath = "//div[@class='b-header-b-menu-wrapper']//a[@href='/games/']")
    private WebElement games;


    public String booksLink() {
        books.click();
        return driver.getCurrentUrl();
    }

    public String foreignBooksLink() {
        foreignBooks.click();
        return driver.getCurrentUrl();
    }

    public String bestBooksLink() {
        best.click();
        return driver.getCurrentUrl();
    }

    public String schoolBooksLink() {
        school.click();
        return driver.getCurrentUrl();
    }

    public String officeBooksLink() {
        office.click();
        return driver.getCurrentUrl();
    }

    public String gamesBooksLink() {
        games.click();
        return driver.getCurrentUrl();
    }

}
