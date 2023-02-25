import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends MainPage {
    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li/a[@href='/cart/']")
    private WebElement toCartButton;

    @FindBy(xpath = "//span[@class='price-val']/span")
    private WebElement bookPrice;

    @FindBy(xpath = "//span[@id='basket-default-sumprice-discount']")
    private WebElement totalPrice;

    @FindBy(xpath = "//a[contains(text(),'Очистить корзину')]")
    private WebElement clearCartButton;

    @FindBy(xpath = "//span[text()='Ваша корзина пуста. Почему?']")
    private WebElement myCartField;

    @FindBy(xpath = "//a[text()='Восстановить удаленное']")
    private WebElement restoreBook;

    @FindBy(xpath = "//div[@data-title='Заказ']//span[@class='product-title']")
    private WebElement booksInCart;

    public void toCart() {
        toCartButton.click();
    }

    public String getBookPrice() {
        return bookPrice.getText().replaceAll(" ", "");
    }

    public String getTotalPrice() {
        return totalPrice.getText().replaceAll(" ", "");
    }

    public boolean clearCart() {
        clearCartButton.click();
        return myCartField.isDisplayed();
    }

    public void restoreBooks() {
        restoreBook.click();
    }

    public String getBooks() {
        return booksInCart.getText();
    }


}
