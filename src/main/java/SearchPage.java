import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SearchPage {
    public WebDriver driver;
    public static WebDriverWait wait;

    public SearchPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//input[@placeholder='Поиск по Лабиринту']")
    private WebElement input;

    @FindBy(xpath = "//div[@data-title]")
    private WebElement result;



    public String searchResult(String request) {
        input.sendKeys(request, Keys.ENTER);
        String requestResult = result.getText();
        return requestResult;
    }
}