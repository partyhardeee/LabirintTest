import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LabyrinthSiteTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static MainPage mainPage;
    public static SearchPage searchPage;


    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
        driver.manage().window().maximize();
        driver.get("https://www.labirint.ru/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body//span[@class='b-header-b-logo-e-logo']")));
    }

    @Test
    public void moveToBooks() {
        Assertions.assertTrue(mainPage.booksLink().contains("https://www.labirint.ru/books/"));
    }

    @Test
    public void moveToForeignBooks() {
        Assertions.assertTrue(mainPage.foreignBooksLink().contains("https://www.labirint.ru/foreignbooks/"));
    }

    @Test
    public void moveToBestBooks() {
        Assertions.assertTrue(mainPage.bestBooksLink().contains("https://www.labirint.ru/best/"));
    }

    @Test
    public void moveToOfficeBooks() {
        Assertions.assertTrue(mainPage.officeBooksLink().contains("https://www.labirint.ru/office/"));
    }

    @Test
    public void moveToSchoolBooks() {
        Assertions.assertTrue(mainPage.schoolBooksLink().contains("https://www.labirint.ru/school/"));
    }

    @Test
    public void moveToGamesBooks() {
        Assertions.assertTrue(mainPage.gamesBooksLink().contains("https://www.labirint.ru/games/"));
        toMain();
    }
    @Test
    public void searchTest(){
        Assertions.assertTrue(searchPage.searchResult("Остров сокровищ").contains("Остров сокровищ"));
    }

    public void toMain() {
        driver.findElement(By.xpath("//div//a//span[@class='b-header-b-logo-e-logo']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body//span[@class='b-header-b-logo-e-logo']")));
    }

    @AfterAll
    public static void close() {
        driver.close();
    }

}

