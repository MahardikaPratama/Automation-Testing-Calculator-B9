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

import com.calculator.Calculate;

@Epic("Calculator Operations")
@Feature("Calculate")
public class CalculateTest {
    private Calculate sut;

    @BeforeEach
    public void setUp() throws Exception {
        sut = new Calculate();
    }

    @AfterEach
    public void tearDown() throws Exception {
        sut = null;
    }

    @Test
    @DisplayName("Test Add Function - Positive Numbers")
    @Story("Addition")
    @Description("Menguji operasi penambahan dua buah input bilangan positif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC1 - Add Function Test")
    public void testAdd_PositiveNumbers() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: a = 5, b = 3");
        int a = 5;
        int b = 3;

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi add dengan parameter a dan b");
        int result = sut.add(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '8', Actual: " + result);
        int expected = 8;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Add Function - Positive and Negative Numbers")
    @Story("Addition")
    @Description("Menguji operasi penambahan bilangan positif dan negatif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC2 - Add Function Test")
    public void testAdd_PositiveAndNegativeNumbers() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: a = 5, b = -3");
        int a = 5;
        int b = -3;

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi add dengan parameter a dan b");
        int result = sut.add(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '2', Actual: " + result);
        int expected = 2;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Add Function - Negative Numbers")
    @Story("Addition")
    @Description("Menguji operasi penambahan dua buah input bilangan negatif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC3 - Add Function Test")
    public void testAdd_NegativeNumbers() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: a = -5, b = -3");
        int a = -5;
        int b = -3;

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi add dengan parameter a dan b");
        int result = sut.add(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '-8', Actual: " + result);
        int expected = -8;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Add Function - One Operand is Zero")
    @Story("Addition")
    @Description("Menguji operasi penambahan dua buah input dengan salah satu bilangan nol")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC4 - Add Function Test")
    public void testAdd_OneOperandIsZero() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: a = 0, b = 7");
        int a = 0;
        int b = 7;

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi add dengan parameter a dan b");
        int result = sut.add(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '7', Actual: " + result);
        int expected = 7;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Add Function - Both Operands are Zero")
    @Story("Addition")
    @Description("Menguji operasi penambahan dua buah input bilangan nol")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC5 - Add Function Test")
    public void testAdd_BothOperandsAreZero() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: a = 0, b = 0");
        int a = 0;
        int b = 0;

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi add dengan parameter a dan b");
        int result = sut.add(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '0', Actual: " + result);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Subtract Function - Positive Numbers")
    @Story("Subtraction")
    @Description("Menguji operasi pengurangan dua buah input bilangan positif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC1 - Subtract Function Test")
    public void testSubtract_PositiveNumbers() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: a = 5, b = 3");
        int a = 5;
        int b = 3;

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi subtract dengan parameter a dan b");
        int result = sut.subtract(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '2', Actual: " + result);
        int expected = 2;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Subtract Function - Positive and Negative Numbers")
    @Story("Subtraction")
    @Description("Menguji operasi pengurangan bilangan positif dan negatif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC1 - Subtract Function Test")
    public void testSubtract_PositiveAndNegativeNumbers() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: a = 5, b = -3");
        int a = 5;
        int b = -3;

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi subtract dengan parameter a dan b");
        int result = sut.subtract(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '8', Actual: " + result);
        int expected = 8;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Subtract Function - Negative Numbers")
    @Story("Subtraction")
    @Description("Menguji operasi pengurangan dua buah input bilangan negatif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC3 - Subtract Function Test")
    public void testSubtract_NegativeNumbers() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: a = -5, b = -3");
        int a = -5;
        int b = -3;

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi subtract dengan parameter a dan b");
        int result = sut.subtract(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '-2', Actual: " + result);
        int expected = -2;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Subtract Function - One Operand is Zero")
    @Story("Subtraction")
    @Description("Menguji operasi pengurangan dua buah input dengan salah satu bilangan nol")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC4 - Subtract Function Test")
    public void testSubtract_OneOperandIsZero() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: a = 0, b = 7");
        int a = 0;
        int b = 7;

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi subtract dengan parameter a dan b");
        int result = sut.subtract(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '-7', Actual: " + result);
        int expected = -7;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Subtract Function - Both Operands are Zero")
    @Story("Subtraction")
    @Description("Menguji operasi pengurangan dua buah input bilangan nol")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC5 - Subtract Function Test")
    public void testSubtract_BothOperandsAreZero() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: a = 0, b = 0");
        int a = 0;
        int b = 0;

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi subtract dengan parameter a dan b");
        int result = sut.subtract(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '0', Actual: " + result);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Multiply Function - Positive Numbers")
    @Story("Multiplication")
    @Description("Menguji operasi perkalian dua buah input bilangan positif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC1 - Multiply Function Test")
    public void testMultiply_PositiveNumbers() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: a = 5, b = 3");
        int a = 5;
        int b = 3;

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi multiply dengan parameter a dan b");
        int result = sut.multiply(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '15', Actual: " + result);
        int expected = 15;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Multiply Function - Positive and Negative Numbers")
    @Story("Multiplication")
    @Description("Menguji operasi perkalian bilangan positif dan negatif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC2 - Multiply Function Test")
    public void testMultiply_PositiveAndNegativeNumbers() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: a = 5, b = -3");
        int a = 5;
        int b = -3;

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi multiply dengan parameter a dan b");
        int result = sut.multiply(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '-15', Actual: " + result);
        int expected = -15;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Multiply Function - Negative Numbers")
    @Story("Multiplication")
    @Description("Menguji operasi perkalian dua buah input bilangan negatif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC3 - Multiply Function Test")
    public void testMultiply_NegativeNumbers() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: a = -5, b = -3");
        int a = -5;
        int b = -3;

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi multiply dengan parameter a dan b");
        int result = sut.multiply(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '15', Actual: " + result);
        int expected = 15;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Multiply Function - One Operand is Zero")
    @Story("Multiplication")
    @Description("Menguji operasi perkalian dua buah input dengan salah satu bilangan nol")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC4 - Multiply Function Test")
    public void testMultiply_OneOperandIsZero() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: a = 0, b = 7");
        int a = 0;
        int b = 7;

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi multiply dengan parameter a dan b");
        int result = sut.multiply(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '0', Actual: " + result);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Multiply Function - Both Operands are Zero")
    @Story("Multiplication")
    @Description("Menguji operasi perkalian dua buah input bilangan nol")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC5 - Multiply Function Test")
    public void testMultiply_BothOperandsAreZero() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: a = 0, b = 0");
        int a = 0;
        int b = 0;

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi multiply dengan parameter a dan b");
        int result = sut.multiply(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '0', Actual: " + result);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Divide Function - Positive Numbers")
    @Story("Division")
    @Description("Menguji operasi pembagian dua buah input bilangan positif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC1 - Divide Function Test")
    public void testDivide_PositiveNumbers() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: a = 6, b = 3");
        int a = 6;
        int b = 3;

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi divide dengan parameter a dan b");
        float result = sut.divide(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '2.00', Actual: " + result);
        String expected = "2.00";
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Divide Function - Positive and Negative Numbers")
    @Story("Division")
    @Description("Menguji operasi pembagian bilangan positif dan negatif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC2 - Divide Function Test")
    public void testDivide_PositiveAndNegativeNumbers() {
        // (1) Persiapan (arrange, build)
        Allure.step("Persiapan data: a = 6, b = -3");
        int a = 6;
        int b = -3;

        // (2) Eksekusi (act, operate)
        Allure.step("Memanggil fungsi divide dengan parameter a dan b");
        float result = sut.divide(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '-2.00', Actual: " + result);
        String expected = "-2.00";
        assertEquals(expected, result);
    }

    
}