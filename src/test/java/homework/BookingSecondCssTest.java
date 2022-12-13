package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class BookingSecondCssTest {

    static WebDriver driver = new ChromeDriver();

    @Test
    public void bookingSecondCssTest() throws InterruptedException {

//        3. задание booking 2:
//        3.1. Перейти на сайт booking.com
//        3.2. Выбрать нужные (любые) даты
//        3.3 Ввести в поиск «Izmir», выбрать для проживания 2 гостей и 1 номер.
//        3.4 Отфильтровать отели с максимальным рейтингом
//        3.5 Открыть страницу с первым таким отелем и проверить, что его рейтинг >=9

        driver.get("https://booking.com/");

        try {
            driver.findElement(By.cssSelector("div.xp__dates.xp__group")).click();
            driver.findElement(By.cssSelector("div[data-bui-ref='calendar-content'] div.bui-calendar__wrapper:nth-child(2) tbody tr:nth-child(3) td:nth-child(1)")).click();
            driver.findElement(By.cssSelector("div[data-bui-ref='calendar-content'] div.bui-calendar__wrapper:nth-child(2) tbody tr:nth-child(3) td:nth-child(7)")).click();
        } catch (NoSuchElementException e) {
            driver.findElement(By.cssSelector("div[data-testid='searchbox-dates-container']")).click();
            driver.findElement(By.cssSelector("div[data-testid='searchbox-datepicker'] div div:nth-child(2) div:nth-child(2) tbody tr:nth-child(3) td:nth-child(1)")).click();
            driver.findElement(By.cssSelector("div[data-testid='searchbox-datepicker'] div div:nth-child(2) div:nth-child(2) tbody tr:nth-child(3) td:nth-child(7)")).click();
        }

        WebElement search = driver.findElement(By.cssSelector("input[name='ss']"));
        search.sendKeys("Izmir");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        driver.findElement(By.cssSelector("button[data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.cssSelector("button[data-id='review_score_and_price']")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("div[data-testid='title']")).click();
        Thread.sleep(15000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(5000);
        Float rate = Float.parseFloat(driver.findElement(By.cssSelector("div[data-testid='review-score-right-component'] div"))
                .getText()
                .replace(',', '.'));

        Assert.assertTrue("Рейтинг отеля менее 9.0", rate >= 9.0);

        driver.close();
        driver.quit();
    }
}
