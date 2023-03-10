import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Map;

public class LabyrinthSiteTest {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeAll
    public static void prop() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.labirint.ru/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body//span[@class='b-header-b-logo-e-logo']")));
    }

    @Test
    public void moveToBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).booksLink().contains("https://www.labirint.ru/books/"));
    }

    @Test
    public void moveToForeignBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).foreignBooksLink().contains("https://www.labirint.ru/foreignbooks/"));
    }

    @Test
    public void moveToBestBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).bestBooksLink().contains("https://www.labirint.ru/best/"));
    }

    @Test
    public void moveToOfficeBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).officeBooksLink().contains("https://www.labirint.ru/office/"));
    }

    @Test
    public void moveToSchoolBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).schoolBooksLink().contains("https://www.labirint.ru/school/"));
    }

    @Test
    public void moveToGamesBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).gamesBooksLink().contains("https://www.labirint.ru/games/"));
    }

    @Test
    public void searchTest() {
        String searchResult = new MainPage(driver, wait)
                .goToSearchPage("Остров сокровищ")
                .getSearchResult();
        Assertions.assertTrue(searchResult.contains("Остров сокровищ"));
    }

    @Test
    public void checkCartPrice() {
        Map<String, String> getBothPrices = new MainPage(driver, wait)
                .goToSearchPage("Остров сокровищ")
                .addBookToCart()
                .goToCartPage()
                .getBothPrices();
        Assertions.assertEquals(getBothPrices.get("bookPrice"), getBothPrices.get("totalPrice"));
    }

    @Test
    public void deleteCart() {
        new MainPage(driver, wait).goToSearchPage("Остров сокровищ").addBookToCart();
        boolean isCartCleared = new MainPage(driver, wait).goToCartPage().clearCart().isCartCleared();
        Assertions.assertTrue(isCartCleared);
    }

    @Test
    public void checkRestore() {
        String restoredBooks = new MainPage(driver, wait).goToSearchPage("Остров сокровищ")
                .addBookToCart()
                .goToCartPage()
                .clearCart()
                .restoreBooks()
                .getBooks();
        Assertions.assertTrue(restoredBooks.contains("Остров Сокровищ"));
    }

    @Test
    public void checkPutOrder() {
        boolean isBookPuOrdered =
                new MainPage(driver, wait)
                        .goToSearchPage("Война и мир")
                        .putOrderBook()
                        .toPutOrder().isBookPutOrdered();
        Assertions.assertTrue(isBookPuOrdered);
    }

    @AfterEach
    public void close() {
        driver.close();
    }

}

