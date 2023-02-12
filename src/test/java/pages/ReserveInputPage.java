package pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ReserveInputPage {
    private WebDriver driver;
    private String confirmPageMetaTitle = "予約内容確認";
    private String errorPageMetaTitle = "予約エラー";


    public ReserveInputPage(WebDriver driver, String pageMetaTitle) {
        this.driver = driver;
        if(!pageMetaTitle.equals(this.driver.getTitle())) {
            throw new IllegalStateException("現在のページが間違っています: " + this.driver.getTitle());
        }
    }

    public void setReserveDate(String year, String month, String day) {
        driver.findElement(By.name("reserve_y")).clear();
        driver.findElement(By.name("reserve_y")).sendKeys(year);
        driver.findElement(By.name("reserve_m")).clear();
        driver.findElement(By.name("reserve_m")).sendKeys(month);
        driver.findElement(By.name("reserve_d")).clear();
        driver.findElement(By.name("reserve_d")).sendKeys(day);
    }

    public void setReserveTerm(String term) {
        driver.findElement(By.name("reserve_t")).clear();
        driver.findElement(By.name("reserve_t")).sendKeys(term);
    }

    public void setReserveHeadCount(String headCount) {
        driver.findElement(By.name("hc")).clear();
        driver.findElement(By.name("hc")).sendKeys(headCount);
    }

    public void setReserveBreakfast(boolean onFlg) {
        if (onFlg) {
            driver.findElement(By.id("breakfast_on")).click();
        } else {
            driver.findElement(By.id("breakfast_off")).click();
        }
    }

    public void setReserveEarlyCheckInPlan(boolean checked) {
        if(driver.findElement(By.name("plan_a")).isSelected() != checked) {
            driver.findElement(By.name("plan_a")).click();
        }
    }

    public void setReserveSightseeingPlan(boolean checked) {
        if(driver.findElement(By.name("plan_b")).isSelected() != checked) {
            driver.findElement(By.name("plan_b")).click();
        }
    }

    public void setReserveGuestName(String guestName) {
        driver.findElement(By.name("gname")).clear();
        driver.findElement(By.name("gname")).sendKeys(guestName);
    }

    public ReserveConfirmPage goToNext() {
        driver.findElement(By.id("goto_next")).click();
        return new ReserveConfirmPage(driver, confirmPageMetaTitle);
    }

    public ReserveErrorPage goToNextExpectingFailure() {
        driver.findElement(By.id("goto_next")).click();
        return new ReserveErrorPage(driver, errorPageMetaTitle);
    }
}


