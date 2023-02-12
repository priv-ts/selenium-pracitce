package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReserveConfirmPage {
    private WebDriver driver;

    public ReserveConfirmPage(WebDriver driver, String pageMetaTitle) {
        this.driver = driver;
        if(!pageMetaTitle.equals(this.driver.getTitle())) {
            throw new IllegalStateException("現在のページが間違っています: " + this.driver.getTitle());
        }
    }

    public String getPrice() {
        return driver.findElement(By.id("price")).getText();
    }

    public void commit() {
        driver.findElement(By.id("commit")).click();
    }
}
