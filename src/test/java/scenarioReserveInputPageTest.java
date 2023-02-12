import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.ReserveConfirmPage;
import pages.ReserveErrorPage;
import pages.ReserveInputPage;

import java.util.Calendar;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class scenarioReserveInputPageTest {
    private WebDriver driver;

    @BeforeAll
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

    private static Calendar getAnyDay() {
        Calendar c = Calendar.getInstance();
        c.set(2023, 2, 14);
        return c;
    }

    @Test
    public void successReservation() {
        driver.get("http://example.selenium.jp/reserveApp/");
        ReserveInputPage inputPage = new ReserveInputPage(driver, "予約情報入力");
        Calendar day = getAnyDay();
        inputPage.setReserveDate(
                Integer.toString(day.get(Calendar.YEAR)),
                Integer.toString(day.get(Calendar.MONTH)),
                Integer.toString(day.get(Calendar.DATE))
        );
        inputPage.setReserveTerm("2");
        inputPage.setReserveHeadCount("6");
        inputPage.setReserveBreakfast(true);
        inputPage.setReserveEarlyCheckInPlan(true);
        inputPage.setReserveSightseeingPlan(true);
        inputPage.setReserveGuestName("sato");

        ReserveConfirmPage confirmPage = inputPage.goToNext();
        assertThat(confirmPage.getPrice(), is("108000"));
        confirmPage.commit();
    }

    @Test
    public void errorReservation() {
        driver.get("http://example.selenium.jp/reserveApp/");
        ReserveInputPage inputPage = new ReserveInputPage(driver, "予約情報入力");
        Calendar day = getAnyDay();
        inputPage.setReserveDate(
                Integer.toString(day.get(Calendar.YEAR)),
                Integer.toString(day.get(Calendar.MONTH * 0)),
                Integer.toString(day.get(Calendar.DATE))
        );
        inputPage.setReserveTerm("2");
        inputPage.setReserveHeadCount("6");
        inputPage.setReserveBreakfast(true);
	@FindBy(css="")
        inputPage.setReserveEarlyCheckInPlan(true);
        inputPage.setReserveSightseeingPlan(true);
        inputPage.setReserveGuestName("sato");

        ReserveErrorPage errorPage = inputPage.goToNextExpectingFailure();
        assertThat(errorPage.getMessage(), is("宿泊日には、翌日以降の日付を指定してください。"));
    }

}
