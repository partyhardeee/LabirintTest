package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.PreOrderPage;

import java.util.Map;


public class LabyrinthSite extends BaseTest {

    @Epic(value = "Переход на страницу")
    @Story(value = "Проверка перехода на страницу books")
    @Test
    public void moveToBooks() {
//        Получение данных с conf - в зависимости от профиля
//        System.out.println(ConfClass.getProperty("login"));
//        System.out.println(ConfClass.getProperty("password"));
        Assertions.assertTrue(new MainPage(driver, wait).booksLink().contains(System.getProperty("test.url") + "/books/"));

    }

    @Epic(value = "Переход на страницу")
    @Story(value = "Проверка перехода на страницу foreign books")
    @Test
    public void moveToForeignBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).foreignBooksLink().contains(System.getProperty("test.url") + "/foreignbooks/"));
    }

    @Epic(value = "Переход на страницу")
    @Story(value = "Проверка перехода на страницу best")
    @Test
    public void moveToBestBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).bestBooksLink().contains(System.getProperty("test.url") + "/best/"));
    }

    @Epic(value = "Переход на страницу")
    @Story(value = "Проверка перехода на страницу office")
    @Test
    public void moveToOfficeBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).officeBooksLink().contains(System.getProperty("test.url") + "/office/"));
    }

    @Epic(value = "Переход на страницу")
    @Story(value = "Проверка перехода на страницу school")
    @Test
    public void moveToSchoolBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).schoolBooksLink().contains(System.getProperty("test.url") + "/school/"));
    }

    @Epic(value = "Переход на страницу")
    @Story(value = "Проверка перехода на страницу games")
    @Test
    public void moveToGamesBooks() {
        Assertions.assertTrue(new MainPage(driver, wait).gamesBooksLink().contains(System.getProperty("test.url") + "/games/"));
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
        softAssertions.assertThat(getBothPrices.get("bookPrice")).isEqualTo(getBothPrices.get("totalPrice"));
        softAssertions.assertThat(getBothPrices.get("totalWithoutDiscount")).isEqualTo(getBothPrices.get("bookWithoutDiscount"));
        softAssertions.assertAll();
    }


    @Epic(value = "Сортировка")
    @Story(value = "Проверка сортировки - Сначала дешевые")
    @Test
    public void sortByCheap() throws InterruptedException {
        Map<String, String> getBothPrices = new MainPage(driver, wait)
                .goToSearchPage("Стивен Кинг")
                .sortByPriceUp()
                .getPriceOfSorted();
        Assertions.assertTrue(Integer.parseInt(getBothPrices.get("firstBookPrice")) <= Integer.parseInt(getBothPrices.get("secBookPrice")));
    }

    @Epic(value = "Сортировка")
    @Story(value = "Проверка сортировки - Сначала дорогие")
    @Test
    public void sortByExpensive() throws InterruptedException {
        Map<String, String> getBothPrices = new MainPage(driver, wait)
                .goToSearchPage("Джек Лондон")
                .sortByPriceDown()
                .getPriceOfSorted();
        Assertions.assertTrue(Integer.parseInt(getBothPrices.get("secBookPrice")) <= Integer.parseInt(getBothPrices.get("firstBookPrice")));
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
        new PreOrderPage(driver, wait).fillTheName("Никита").fillSurname("Данилов");
        softAssertions.assertThat(new PreOrderPage(driver, wait).getPlacesToFill().contains("Имя")).isFalse();
        softAssertions.assertThat(new PreOrderPage(driver, wait).getPlacesToFill().contains("Фамилия")).isFalse();
        softAssertions.assertThat(title).contains("Оформление предзаказа");
        softAssertions.assertAll();

    }
}

