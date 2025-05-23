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

    @Test
    @DisplayName("Test Perform Calculation - Subtraction")
    @Story("Subtraction")
    @Description("Menguji pemanggilan modul subtract")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC2 - Perform Calculation Test")
    public void testPerformCalculation_Subtraction() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: num1 = 5, num2 = 3, operator = '-'");
        int num1 = 5;
        int num2 = 3;
        String operator = "-";

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi performCalculation dengan parameter num1, num2, dan operator");
        String result = sut.performCalculation(num1, num2, operator);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '2', Actual: " + result);
        String expected = "2";
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Perform Calculation - Multiplication")
    @Story("Multiplication")
    @Description("Menguji pemanggilan modul multiply")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC3 - Perform Calculation Test")
    public void testPerformCalculation_Multiplication() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: num1 = 5, num2 = 3, operator = '*'");
        int num1 = 5;
        int num2 = 3;
        String operator = "*";

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi performCalculation dengan parameter num1, num2, dan operator");
        String result = sut.performCalculation(num1, num2, operator);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '15', Actual: " + result);
        String expected = "15";
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Perform Calculation - Division")
    @Story("Division")
    @Description("Menguji pemanggilan modul divide")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC4 - Perform Calculation Test")
    public void testPerformCalculation_Division() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: num1 = 6, num2 = 3, operator = '/'");
        int num1 = 6;
        int num2 = 3;
        String operator = "/";

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi performCalculation dengan parameter num1, num2, dan operator /");
        String result = sut.performCalculation(num1, num2, operator);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '2.00', Actual: " + result);
        String expected = "2.00";
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Perform Calculation - Invalid Operator")
    @Story("Invalid Operator")
    @Description("Menguji pemanggilan modul tidak valid karena bukan modul (add, subtract, multiply, atau divide)")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC5 - Perform Calculation Test")
    public void testPerformCalculation_InvalidOperator() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: num1 = 6, num2 = 3, operator = 'x'");
        int num1 = 6;
        int num2 = 3;
        String operator = "x";

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi performCalculation dengan parameter num1, num2, dan operator tidak valid");
        String result = sut.performCalculation(num1, num2, operator);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: 'Error: Operator tidak valid', Actual: " + result);
        String expected = "Error: Operator tidak valid";
        assertEquals(expected, result);
    }
}