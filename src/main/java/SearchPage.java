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


    public String searchResult(String request) {
        input.sendKeys(request, Keys.ENTER);
        return result.getText();
    }

    public void addBookToCart(String request) {
        input.sendKeys(request, Keys.ENTER);
        addToCart.click();
    }
}