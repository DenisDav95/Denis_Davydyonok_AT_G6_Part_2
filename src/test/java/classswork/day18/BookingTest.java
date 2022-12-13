package classswork.day18;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BookingTest {

    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://booking.com/");

        try {
            driver.findElement(By.xpath("//div[@class='xp__dates-inner']")).click();
            driver.findElement(By.xpath("//div[@data-bui-ref='calendar-month'][2]//tr[@class='bui-calendar__row'][3]/td[1]")).click();
            driver.findElement(By.xpath("//div[@data-bui-ref='calendar-month'][2]//tr[@class='bui-calendar__row'][3]/td[7]")).click();
            driver.findElement(By.xpath("//label[@id='xp__guests__toggle']")).click();
            WebElement addGuest = driver.findElement(By.xpath("//div[@class='sb-group__field sb-group__field-adults']//button[@data-bui-ref='input-stepper-add-button']"));
            addGuest.click();
            addGuest.click();
            WebElement addRoom = driver.findElement(By.xpath("//div[@class='sb-group__field sb-group__field-rooms']//button[@data-bui-ref='input-stepper-add-button']"));
            addRoom.click();
        } catch (NoSuchElementException e) {
            driver.findElement(By.xpath("//div[@data-testid='searchbox-dates-container']")).click();
            driver.findElement(By.xpath("//div[@data-testid='searchbox-datepicker']/div/div/div[2]//tbody/tr[3]/td[1]")).click();
            driver.findElement(By.xpath("//div[@data-testid='searchbox-datepicker']/div/div/div[2]//tbody/tr[3]/td[7]")).click();
            driver.findElement(By.xpath("//button[@data-testid='occupancy-config']")).click();
            WebElement addGuest = driver.findElement(By.xpath("//input[@id='group_adults']/../div[2]/button[2]"));
            addGuest.click();
            addGuest.click();
            WebElement addRoom = driver.findElement(By.xpath("//input[@id='no_rooms']/../div[2]/button[2]"));
            addRoom.click();
        }

        WebElement search = driver.findElement(By.xpath("//input[@name='ss']"));
        search.sendKeys("Париж");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//div[@data-testid='filters-sidebar']/div[2]//div[@data-filters-item='pri:pri=5']")).click();
    }
}
