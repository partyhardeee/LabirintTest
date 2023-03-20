import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Map;

public class LabyrinthSite {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeAll
    public static void prop() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
    }

    @BeforeEach
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("url"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body//span[@class='b-header-b-logo-e-logo']")));
    }

    @Test
    public void moveToBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).booksLink().contains(ConfProperties.getProperty("url") + "/books/"));
    }

    @Test
    public void moveToForeignBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).foreignBooksLink().contains(ConfProperties.getProperty("url") + "/foreignbooks/"));
    }

//    @Test
//    public void moveToBestBooks() {
//        Assertions.assertTrue(new MainPage(driver, wait).bestBooksLink().contains(ConfProperties.getProperty("url") + "/best/"));
//    }
//
//    @Test
//    public void moveToOfficeBooks() {
//        Assertions.assertTrue(new MainPage(driver, wait).officeBooksLink().contains(ConfProperties.getProperty("url") + "/office/"));
//    }
//
//    @Test
//    public void moveToSchoolBooks() {
//        Assertions.assertTrue(new MainPage(driver, wait).schoolBooksLink().contains(ConfProperties.getProperty("url") + "/school/"));
//    }
//
//    @Test
//    public void moveToGamesBooks() {
//        Assertions.assertTrue(new MainPage(driver, wait).gamesBooksLink().contains(ConfProperties.getProperty("url") + "/games/"));
//    }
//
//    @Test
//    public void searchTest() {
//        String searchResult = new MainPage(driver, wait)
//                .goToSearchPage("Остров сокровищ")
//                .getSearchResult();
//        Assertions.assertTrue(searchResult.contains("Остров сокровищ"));
//    }
//
//    @Test
//    public void checkCartPrice() {
//        Map<String, String> getBothPrices = new MainPage(driver, wait)
//                .goToSearchPage("Остров сокровищ")
//                .addBookToCart()
//                .goToCartPage()
//                .getBothPrices();
//        Assertions.assertEquals(getBothPrices.get("bookPrice"), getBothPrices.get("totalPrice"));
//    }
//
//    @Test
//    public void deleteCart() {
//        new MainPage(driver, wait).goToSearchPage("Остров сокровищ").addBookToCart();
//        boolean isCartCleared = new MainPage(driver, wait).goToCartPage().clearCart().isCartCleared();
//        Assertions.assertTrue(isCartCleared);
//    }
//
//    @Test
//    public void checkRestore() {
//        String restoredBooks = new MainPage(driver, wait).goToSearchPage("Остров сокровищ")
//                .addBookToCart()
//                .goToCartPage()
//                .clearCart()
//                .restoreBooks()
//                .getBooks();
//        Assertions.assertTrue(restoredBooks.contains("Остров Сокровищ"));
//    }
//
//    @Test
//    public void checkPutOrder() {
//        boolean isBookPuOrdered =
//                new MainPage(driver, wait)
//                        .goToSearchPage("Война и мир")
//                        .putOrderBook()
//                        .toPutOrder().isBookPutOrdered();
//        Assertions.assertTrue(isBookPuOrdered);
//    }

    @AfterEach
    public void close() {
        driver.close();
    }

}

