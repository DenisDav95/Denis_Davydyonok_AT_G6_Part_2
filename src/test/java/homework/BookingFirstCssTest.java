package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookingFirstCssTest {

    static WebDriver driver = new ChromeDriver();

    @Test
    public void bookingTest() throws InterruptedException {

//        2. задание booking 1:
//        2.1. Перейти на сайт booking.com
//        2.2. Выбрать нужные (любые) даты
//        2.3. Ввести в поиск «Milano», выбрать для проживания 2 гостей и 1 номер.
//        2.4. Проверить, что в Милане есть отели на введенные даты

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
        search.sendKeys("Milano");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertTrue("Нет отелей на введенные даты", driver.findElement(By.cssSelector("h1[class]")).isDisplayed());

        driver.close();
        driver.quit();
    }
}
