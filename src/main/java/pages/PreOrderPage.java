package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PreOrderPage extends MainPage {

    public PreOrderPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//h1[@class='_title-generic']")
    private WebElement title;

    @FindBy(xpath = "//div[@class='product-buy-margin']//a[@data-position='1']")
    private WebElement preOrderBook;

    @FindBy(xpath = "//div[@class='pt20 pb20 text-s v-color--greyer text-xs']")
    private WebElement placesToFill;

    @FindBy(xpath = "//input[@placeholder='Имя']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@placeholder='Фамилия']")
    private WebElement surnameInput;


    @Step("Предзаказать книгу")
    public PreOrderPage preOrderBook() {
        preOrderBook.click();
        return this;
    }

    public String getTitle() {
        return title.getText();
    }

    public String getPlacesToFill(){
        return placesToFill.getText();
    }

    public PreOrderPage fillTheName(String name){
        nameInput.sendKeys(name);
        return this;
    }

    public PreOrderPage fillSurname(String surname){
        surnameInput.sendKeys(surname);
        return this;
    }

}
