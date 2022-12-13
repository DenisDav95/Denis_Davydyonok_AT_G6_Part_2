package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class GoogleWeatherTest {

    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.google.com/");

        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("погода минск");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@role='listbox']/li[1]//span[text()='погода минск']")).click();
        driver.findElement(By.xpath("//div[@data-wob-di='1']")).click();

        String tomorrow = DayOfWeek.from(LocalDate.now()).plus(1).getDisplayName(TextStyle.FULL, new Locale("ru"));
        String weather = driver.findElement(By.xpath(String.format("//*[contains(@aria-label, '%s 12:00')][1]", tomorrow))).getAttribute("aria-label");
        List<String> parsingWeather = new ArrayList<>(Arrays.asList(weather.split(tomorrow)));
        driver.close();
        driver.quit();
        System.out.println(parsingWeather.get(0));
    }
}
