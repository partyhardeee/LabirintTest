package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class CartPage extends MainPage {
    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

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


    @FindBy(xpath = "//a[@data-tooltip_title='Убрать']//span[@class='header-sprite']")
    private WebElement removeFromPutOrder;

    @FindBy(xpath = "//span[@class='price-gray']")
    private WebElement grayPrice;

    @FindBy(xpath = "//span[@id='basket-default-total-sumprice-nodiscount']")
    private WebElement totalBasketPrice;


    public String getBookPrice() {
        return bookPrice.getText().replaceAll(" ", "");
    }

    public String getTotalPrice() {
        return totalPrice.getText().replaceAll(" ", "");
    }

    public String getGrayPrice() {
        return grayPrice.getText().replaceAll(" ", "");
    }

    public String getTotalBasketPrice() {
        return totalBasketPrice.getText().replaceAll(" ", "");
    }

    public Map<String, String> getBothPrices() {
        Map<String, String> bothPrices = new HashMap<>();
        bothPrices.put("bookPrice", getBookPrice());
        bothPrices.put("totalPrice", getTotalPrice());
        bothPrices.put("totalWithoutDiscount", getTotalBasketPrice());
        bothPrices.put("bookWithoutDiscount", getGrayPrice());

        return bothPrices;
    }

    @Step("Очистка корзины")
    public CartPage clearCart() {
        clearCartButton.click();
        return this;
    }

    public boolean isCartCleared() {
        return myCartField.isDisplayed();
    }

    @Step("Восстановить корзину")
    public CartPage restoreBooks() {
        restoreBook.click();
        return this;
    }

    public boolean restoreBooksButton(){
        return restoreBook.isDisplayed();
    }

    public String getBooks() {
        return booksInCart.getText();
    }


    public void removeBookFromPutOrder() {
        removeFromPutOrder.click();
        driver.navigate().refresh();
    }


}
