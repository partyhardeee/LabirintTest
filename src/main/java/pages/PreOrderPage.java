package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PreOrderPage {
    public WebDriver driver;
    public WebDriverWait wait;

    public PreOrderPage(WebDriver driver, WebDriverWait wait) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;

    }

    @FindBy(xpath = "//h1[@class='_title-generic']")
    private WebElement title;

    @FindBy(xpath = "//div[@class='product-buy-margin']//a[@data-position='1']")
    private WebElement preOrderBook;


    @Step("Предзаказать книгу")
    public PreOrderPage preOrderBook() {
        preOrderBook.click();
        return this;
    }

    public String getTitle() {
        return title.getText();
    }

}