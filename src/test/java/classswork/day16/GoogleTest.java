package classswork.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.google.com/");

        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("погода минск");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//ul[@role='listbox']/li[1]//span[text()='погода минск']")).click();

        driver.findElement(By.xpath("//div[@data-wob-di='1']")).click();

        String weather = driver.findElement(By.xpath("//*[contains(@aria-label, '12:00')][1]")).getAttribute("aria-label");

        System.out.println(weather);

    }
}
