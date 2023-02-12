import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// @TestInstance(Lifecycle.PER_CLASS)を指定したクラスは、テスト時にインスタンスの生成が1回しか行われない
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SampleTest {
    private WebDriver driver;

    // 毎処理前に実行
    @BeforeAll
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public void 処理Aが成功すること() {}

    @Test
    public void 処理Bが失敗すること() {}

    // 毎処理後に実行
    @AfterAll
    public void testDown() {
        driver.quit();
    }

}
