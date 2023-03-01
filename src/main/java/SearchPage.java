import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends MainPage {

    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Поиск по Лабиринту']")
    private WebElement input;

    @FindBy(xpath = "//div[@data-title]")
    private WebElement result;

    @FindBy(xpath = "//div[@class='product-buy-margin']//a")
    private WebElement addToCart;

    @FindBy(xpath = "//div[@data-position='1']//a[@data-tooltip_title='Отложить']//span[@class='header-sprite']")
    private WebElement putOrderButton;

    @FindBy(xpath = "//span[text()='Отложено']")
    private WebElement toPutOrder;
    @FindBy(xpath = "//span[@class='product-title']")
    private WebElement putOrderedBooks;


    public String getSearchResult() {
        return result.getText();
    }

    public SearchPage addBookToCart() {
        addToCart.click();
        return this;
    }


    public SearchPage putOrderBook() {
        putOrderButton.click();
        return this;
    }

    public boolean isBookPutOrdered() {
        return putOrderedBooks.isDisplayed();
    }

    public SearchPage toPutOrder() {
        toPutOrder.click();
        return this;
    }
}