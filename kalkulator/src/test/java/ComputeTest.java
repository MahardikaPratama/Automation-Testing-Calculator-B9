import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.calculator.Compute;

@Epic("Calculator Operations")
@Feature("Perform Calculation")
public class ComputeTest {
    private Compute sut;

    @BeforeEach
    public void setUp() throws Exception {
        sut = new Compute();
    }

    @AfterEach
    public void tearDown() throws Exception {
        sut = null;
    }

    @Test
    @Story("Addition")
    @Description("Menguji pemanggilan modul add")
    public void testPerformCalculation_Addition() {
        // (1) Persiapan (arrange, build)
        int num1 = 5;
        int num2 = 3;
        String operator = "+";

        // (2) Eksekusi (act, operate)
        String result = sut.performCalculation(num1, num2, operator);

        // (3) Verifikasi (assert, check)
        String expected = "8";
        assertEquals(expected, result);
    }
}