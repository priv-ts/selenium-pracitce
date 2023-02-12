package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ReserveErrorPage {
    private WebDriver driver;

    public ReserveErrorPage(WebDriver driver, String pageMetaTitle) {
        this.driver = driver;
        if(!pageMetaTitle.equals(this.driver.getTitle())) {
            throw new IllegalStateException("現在のページが間違っています: " + this.driver.getTitle());
        }
    }

    public String getMessage() {
        return driver.findElement(By.id("errorcheck_result")).getText();
    }
}
