package classswork.day18;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BookingJsTest {

    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://booking.com/");

        WebElement search = driver.findElement(By.xpath("//input[@name='ss']"));
        search.sendKeys("London");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement element = driver.findElement(By.xpath("//div[@data-testid='property-card'][10]"));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor = 'green'", element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color = 'red'", element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", element);
    }
}
