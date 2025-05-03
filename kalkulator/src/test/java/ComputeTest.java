import static org.junit.jupiter.api.Assertions.assertEquals;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Test Perform Calculation - Addition")
    @Story("Addition")
    @Description("Menguji pemanggilan modul add")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC1 - Perform Calculation Test")
    public void testPerformCalculation_Addition() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: num1 = 5, num2 = 3, operator = '+'");
        int num1 = 5;
        int num2 = 3;
        String operator = "+";

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi performCalculation dengan parameter num1, num2, dan operator");
        String result = sut.performCalculation(num1, num2, operator);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '8', Actual: " + result);
        String expected = "8";
        assertEquals(expected, result);
    }
}