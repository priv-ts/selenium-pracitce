import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class SampleScript {
    public static void main(String[] args) {
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("http://example.selenium.jp/reserveApp/");
        firefoxDriver.findElement(By.id("guestname")).sendKeys("サンプルユーザ");
        firefoxDriver.findElement(By.id("goto_next")).click();
        firefoxDriver.quit();

        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://example.selenium.jp/reserveApp/");
        chromeDriver.findElement(By.id("guestname")).sendKeys("サンプルユーザ");
        chromeDriver.findElement(By.id("goto_next")).click();
        chromeDriver.quit();
    }
}
