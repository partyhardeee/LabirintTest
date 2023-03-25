package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import pages.MainPage;

public class SearchTest extends BaseClass {

    @Epic(value = "Поиск")
    @Story(value = "Проверка отображения результатов поиска")
    @Test
    public void searchTest() {
        String searchResult = new MainPage(driver, wait)
                .goToSearchPage("Остров сокровищ")
                .getSearchResult();
        Assertions.assertTrue(searchResult.contains("Остров сокровищ"));
    }

    @Epic(value = "Поиск")
    @Story(value = "Поиск по автору")
    @Test
    public void searchAuthor() {
        String request = "Роулинг Джоан Кэтлин";
        String searchResult = new MainPage(driver, wait)
                .goToSearchPage(request)
                .getAuthor();
        Assertions.assertTrue(searchResult.contains(request));
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
    @Story(value = "Проверка неудачного поиска")
    @Test
    public void wrongSearch() {
        boolean isSearchWrong = new MainPage(driver, wait)
                .goToSearchPage("123123123123")
                .isErrorDisplayed();
        Assertions.assertTrue(isSearchWrong);
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
}
