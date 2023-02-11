import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SampleCalcTest {

    @Test
    void add() {
        // 成功
        assertEquals(4, new SampleCalc().add(2, 2), "2 + 2 = 4");
        // 失敗
        assertEquals(6, new SampleCalc().add(2, 4), "2 + 4 = 6");
    }
}