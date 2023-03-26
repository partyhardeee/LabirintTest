package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    public WebDriver driver;
    public WebDriverWait wait;

    public MainPage(WebDriver driver, WebDriverWait wait) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;


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

    @FindBy(xpath = "//input[@placeholder='Поиск по Лабиринту']")
    private WebElement input;

    @FindBy(xpath = "//li/a[@href='/cart/']")
    private WebElement toCartButton;

    @FindBy(xpath = "//a[@href='/club/']/parent::span")
    private WebElement club;

    @FindBy(xpath = "//div[@class='b-club-content']//a[@href='/top/skoro-v-prodazhe/']")
    private WebElement toPreorderButton;


    @Step("Поиск по запросу {request}")
    public SearchPage goToSearchPage(String request) {
        input.sendKeys(request, Keys.ENTER);
        return new SearchPage(driver, wait);
    }

    @Step("Переход в корзину")
    public CartPage goToCartPage() {
        if (driver.getCurrentUrl() != ("https://www.labirint.ru/cart/")) {
            toCartButton.click();
        }
        return new CartPage(driver, wait);
    }

    @Step("Переход на страницу Книги")
    public String booksLink() {
        wait.until(ExpectedConditions.elementToBeClickable(books));
        books.click();
        return driver.getCurrentUrl();
    }

    @Step("Переход на страницу Иностранные книги")
    public String foreignBooksLink() {
        wait.until(ExpectedConditions.elementToBeClickable(foreignBooks));
        foreignBooks.click();
        return driver.getCurrentUrl();
    }

    @Step("Переход на страницу Лучшие книги")
    public String bestBooksLink() {
        wait.until(ExpectedConditions.elementToBeClickable(best));
        best.click();
        return driver.getCurrentUrl();
    }

    @Step("Переход на страницу Школьные книги")
    public String schoolBooksLink() {
        Actions actions = new Actions(driver);
        try {
            school.click();
        } catch (ElementNotInteractableException e) {
            actions.moveToElement(driver.findElement(By.xpath("//span[@class='b-header-b-menu-e-link top-link-main have-dropdown-touchlink']")));
            driver.findElement(By.xpath("//span[@class='b-header-b-menu-e-link top-link-main have-dropdown-touchlink']")).click();
            driver.findElement(By.xpath("//li[@class='b-menu-second-item second-item-hide']//a[@href='/school/']")).click();
        }

        return driver.getCurrentUrl();
    }

    @Step("Переход на страницу Книги для офиса")
    public String officeBooksLink() {
        Actions actions = new Actions(driver);
        try {
            office.click();
        } catch (ElementNotInteractableException e) {
            actions.moveToElement(driver.findElement(By.xpath("//span[@class='b-header-b-menu-e-link top-link-main have-dropdown-touchlink']")));
            driver.findElement(By.xpath("//span[@class='b-header-b-menu-e-link top-link-main have-dropdown-touchlink']")).click();
            driver.findElement(By.xpath("//li[@class='b-menu-second-item second-item-hide']//a[@href='/office/']")).click();
        }
        return driver.getCurrentUrl();
    }

    @Step("Переход на страницу Игры")
    public String gamesBooksLink() {
        Actions actions = new Actions(driver);
        try {
            games.click();
        } catch (ElementNotInteractableException e) {
            actions.moveToElement(driver.findElement(By.xpath("//span[@class='b-header-b-menu-e-link top-link-main have-dropdown-touchlink']")));
            driver.findElement(By.xpath("//span[@class='b-header-b-menu-e-link top-link-main have-dropdown-touchlink']")).click();
            driver.findElement(By.xpath("//li[@class='b-menu-second-item second-item-hide']//a[@href='/games/']")).click();
        }
        return driver.getCurrentUrl();
    }

    @Step("Переход на страницу предзаказов")
    public PreOrderPage toPreorderBooks() {
        wait.until(ExpectedConditions.elementToBeClickable(club));
        club.click();
        toPreorderButton.click();
        return new PreOrderPage(driver, wait);
    }
}
