import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import pages.MainPage;

import java.util.Map;


public class LabyrinthSite extends BaseClass {

    @Epic(value = "Переход на страницу")
    @Story(value = "Проверка перехода на страницу books")
    @Test
    public void moveToBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).booksLink().contains(ConfClass.getProperty("url") + "/books/"));
    }

    @Epic(value = "Переход на страницу")
    @Story(value = "Проверка перехода на страницу foreign books")
    @Test
    public void moveToForeignBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).foreignBooksLink().contains(ConfClass.getProperty("url") + "/foreignbooks/"));
    }

    @Epic(value = "Переход на страницу")
    @Story(value = "Проверка перехода на страницу best")
    @Test
    public void moveToBestBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).bestBooksLink().contains(ConfClass.getProperty("url") + "/best/"));
    }

    @Epic(value = "Переход на страницу")
    @Story(value = "Проверка перехода на страницу office")
    @Test
    public void moveToOfficeBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).officeBooksLink().contains(ConfClass.getProperty("url") + "/office/"));
    }

    @Epic(value = "Переход на страницу")
    @Story(value = "Проверка перехода на страницу school")
    @Test
    public void moveToSchoolBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).schoolBooksLink().contains(ConfClass.getProperty("url") + "/school/"));
    }

    @Epic(value = "Переход на страницу")
    @Story(value = "Проверка перехода на страницу games")
    @Test
    public void moveToGamesBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).gamesBooksLink().contains(ConfClass.getProperty("url") + "/games/"));
    }

    @Epic(value = "Поиск")
    @Story(value = "Проверка отображения результатов поиска")
    @Test
    public void searchTest() {
        String searchResult = new MainPage(driver, wait)
                .goToSearchPage("Остров сокровищ")
                .getSearchResult();
        Assertions.assertTrue(searchResult.contains("Остров сокровищ"));
    }

    @Epic(value = "Корзина")
    @Story(value = "Проверка цены в корзине")
    @Test
    public void checkCartPrice() {
        Map<String, String> getBothPrices = new MainPage(driver, wait)
                .goToSearchPage("Остров сокровищ")
                .addBookToCart()
                .goToCartPage()
                .getBothPrices();
        Assertions.assertEquals(getBothPrices.get("bookPrice"), getBothPrices.get("totalPrice"));
    }

    @Epic(value = "Поиск")
    @Story(value = "Проверка очистки корзины")
    @Test
    public void deleteCart() {
        new MainPage(driver, wait).goToSearchPage("Остров сокровищ").addBookToCart();
        boolean isCartCleared = new MainPage(driver, wait).goToCartPage().clearCart().isCartCleared();
        Assertions.assertTrue(isCartCleared);
    }

    @Epic(value = "Поиск")
    @Story(value = "Проверка восстановления корзины")
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

    @Epic(value = "Поиск")
    @Story(value = "Кнопка 'Отложить книгу'")
    @Test
    public void checkPutOrder() {
        boolean isBookPuOrdered =
                new MainPage(driver, wait)
                        .goToSearchPage("Война и мир")
                        .putOrderBook()
                        .toPutOrder().isBookPutOrdered();
        Assertions.assertTrue(isBookPuOrdered);
    }

    @Epic(value = "Предзаказ")
    @Story(value = "Предзаказ книги'")
    @Test
    public void preOrderBooks() {
        String title =
                new MainPage(driver, wait)
                        .toPreorderBooks()
                        .preOrderBook()
                        .getTitle();
        Assertions.assertTrue(title.contains("Оформление предзаказа"));
    }

    @AfterEach
    public void close() {
        driver.close();
    }

}

