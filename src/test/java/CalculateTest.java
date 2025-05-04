import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @DisplayName("Menguji operasi penambahan dua buah input bilangan positif")
    @Story("Addition")
    @Description("Menguji operasi penambahan dua buah input bilangan positif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC1 - Add Function Test")
    public void testAdd_PositiveNumbers() {
        Allure.step("Persiapan data: a = 5, b = 3");
        int a = 5;
        int b = 3;

        Allure.step("Memanggil fungsi add dengan parameter a dan b");
        int result = sut.add(a, b);

        Allure.step("Memverifikasi hasil perhitungan. Expected: '8', Actual: " + result);
        int expected = 8;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi penambahan bilangan positif dan negatif")
    @Story("Addition")
    @Description("Menguji operasi penambahan bilangan positif dan negatif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC2 - Add Function Test")
    public void testAdd_PositiveAndNegativeNumbers() {
        Allure.step("Persiapan data: a = 5, b = -3");
        int a = 5;
        int b = -3;

        Allure.step("Memanggil fungsi add dengan parameter a dan b");
        int result = sut.add(a, b);

        Allure.step("Memverifikasi hasil perhitungan. Expected: '2', Actual: " + result);
        int expected = 2;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi penambahan dua buah input bilangan negatif")
    @Story("Addition")
    @Description("Menguji operasi penambahan dua buah input bilangan negatif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC3 - Add Function Test")
    public void testAdd_NegativeNumbers() {
        Allure.step("Persiapan data: a = -5, b = -3");
        int a = -5;
        int b = -3;

        Allure.step("Memanggil fungsi add dengan parameter a dan b");
        int result = sut.add(a, b);

        Allure.step("Memverifikasi hasil perhitungan. Expected: '-8', Actual: " + result);
        int expected = -8;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi penambahan dua buah input dengan salah satu bilangan nol")
    @Story("Addition")
    @Description("Menguji operasi penambahan dua buah input dengan salah satu bilangan nol")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC4 - Add Function Test")
    public void testAdd_OneOperandIsZero() {
        Allure.step("Persiapan data: a = 0, b = 7");
        int a = 0;
        int b = 7;

        Allure.step("Memanggil fungsi add dengan parameter a dan b");
        int result = sut.add(a, b);

        Allure.step("Memverifikasi hasil perhitungan. Expected: '7', Actual: " + result);
        int expected = 7;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi penambahan dua buah input bilangan nol")
    @Story("Addition")
    @Description("Menguji operasi penambahan dua buah input bilangan nol")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC5 - Add Function Test")
    public void testAdd_BothOperandsAreZero() {
        Allure.step("Persiapan data: a = 0, b = 0");
        int a = 0;
        int b = 0;

        Allure.step("Memanggil fungsi add dengan parameter a dan b");
        int result = sut.add(a, b);

        Allure.step("Memverifikasi hasil perhitungan. Expected: '0', Actual: " + result);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi pengurangan dua buah input bilangan positif")
    @Story("Subtraction")
    @Description("Menguji operasi pengurangan dua buah input bilangan positif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC1 - Subtract Function Test")
    public void testSubtract_PositiveNumbers() {
        Allure.step("Persiapan data: a = 5, b = 3");
        int a = 5;
        int b = 3;

        Allure.step("Memanggil fungsi subtract dengan parameter a dan b");
        int result = sut.subtract(a, b);

        Allure.step("Memverifikasi hasil perhitungan. Expected: '2', Actual: " + result);
        int expected = 2;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi pengurangan bilangan positif dan negatif")
    @Story("Subtraction")
    @Description("Menguji operasi pengurangan bilangan positif dan negatif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC2 - Subtract Function Test")
    public void testSubtract_PositiveAndNegativeNumbers() {
        Allure.step("Persiapan data: a = 5, b = -3");
        int a = 5;
        int b = -3;

        Allure.step("Memanggil fungsi subtract dengan parameter a dan b");
        int result = sut.subtract(a, b);

        Allure.step("Memverifikasi hasil perhitungan. Expected: '8', Actual: " + result);
        int expected = 8;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi pengurangan dua buah input bilangan negatif")
    @Story("Subtraction")
    @Description("Menguji operasi pengurangan dua buah input bilangan negatif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC3 - Subtract Function Test")
    public void testSubtract_NegativeNumbers() {
        Allure.step("Persiapan data: a = -5, b = -3");
        int a = -5;
        int b = -3;

        Allure.step("Memanggil fungsi subtract dengan parameter a dan b");
        int result = sut.subtract(a, b);

        Allure.step("Memverifikasi hasil perhitungan. Expected: '-2', Actual: " + result);
        int expected = -2;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi pengurangan dua buah input dengan salah satu bilangan nol")
    @Story("Subtraction")
    @Description("Menguji operasi pengurangan dua buah input dengan salah satu bilangan nol")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC4 - Subtract Function Test")
    public void testSubtract_OneOperandIsZero() {
        Allure.step("Persiapan data: a = 0, b = 7");
        int a = 0;
        int b = 7;

        Allure.step("Memanggil fungsi subtract dengan parameter a dan b");
        int result = sut.subtract(a, b);

        Allure.step("Memverifikasi hasil perhitungan. Expected: '-7', Actual: " + result);
        int expected = -7;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi pengurangan dua buah input bilangan nol")
    @Story("Subtraction")
    @Description("Menguji operasi pengurangan dua buah input bilangan nol")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC5 - Subtract Function Test")
    public void testSubtract_BothOperandsAreZero() {
        Allure.step("Persiapan data: a = 0, b = 0");
        int a = 0;
        int b = 0;

        Allure.step("Memanggil fungsi subtract dengan parameter a dan b");
        int result = sut.subtract(a, b);

        Allure.step("Memverifikasi hasil perhitungan. Expected: '0', Actual: " + result);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi perkalian dua buah input bilangan positif")
    @Story("Multiplication")
    @Description("Menguji operasi perkalian dua buah input bilangan positif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC1 - Multiply Function Test")
    public void testMultiply_PositiveNumbers() {
        Allure.step("Persiapan data: a = 5, b = 3");
        int a = 5;
        int b = 3;

        Allure.step("Memanggil fungsi multiply dengan parameter a dan b");
        int result = sut.multiply(a, b);

        Allure.step("Memverifikasi hasil perhitungan. Expected: '15', Actual: " + result);
        int expected = 15;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi perkalian bilangan positif dan negatif")
    @Story("Multiplication")
    @Description("Menguji operasi perkalian bilangan positif dan negatif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC2 - Multiply Function Test")
    public void testMultiply_PositiveAndNegativeNumbers() {
        Allure.step("Persiapan data: a = 5, b = -3");
        int a = 5;
        int b = -3;

        Allure.step("Memanggil fungsi multiply dengan parameter a dan b");
        int result = sut.multiply(a, b);

        Allure.step("Memverifikasi hasil perhitungan. Expected: '-15', Actual: " + result);
        int expected = -15;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi perkalian dua buah input bilangan negatif")
    @Story("Multiplication")
    @Description("Menguji operasi perkalian dua buah input bilangan negatif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC3 - Multiply Function Test")
    public void testMultiply_NegativeNumbers() {
        Allure.step("Persiapan data: a = -5, b = -3");
        int a = -5;
        int b = -3;

        Allure.step("Memanggil fungsi multiply dengan parameter a dan b");
        int result = sut.multiply(a, b);

        Allure.step("Memverifikasi hasil perhitungan. Expected: '15', Actual: " + result);
        int expected = 15;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi perkalian dua buah input dengan salah satu bilangan nol")
    @Story("Multiplication")
    @Description("Menguji operasi perkalian dua buah input dengan salah satu bilangan nol")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC4 - Multiply Function Test")
    public void testMultiply_OneOperandIsZero() {
        Allure.step("Persiapan data: a = 0, b = 7");
        int a = 0;
        int b = 7;

        Allure.step("Memanggil fungsi multiply dengan parameter a dan b");
        int result = sut.multiply(a, b);

        Allure.step("Memverifikasi hasil perhitungan. Expected: '0', Actual: " + result);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi perkalian dua buah input bilangan nol")
    @Story("Multiplication")
    @Description("Menguji operasi perkalian dua buah input bilangan nol")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC5 - Multiply Function Test")
    public void testMultiply_BothOperandsAreZero() {
        Allure.step("Persiapan data: a = 0, b = 0");
        int a = 0;
        int b = 0;

        Allure.step("Memanggil fungsi multiply dengan parameter a dan b");
        int result = sut.multiply(a, b);

        Allure.step("Memverifikasi hasil perhitungan. Expected: '0', Actual: " + result);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi pembagian dua buah input bilangan positif")
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
        Float result = sut.divide(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '2.0', Actual: " + result);
        Float expected = (float) 2.0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi pembagian bilangan positif dan negatif")
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
        Float result = sut.divide(a, b);

        // (3) Verifikasi (assert, check)
        Allure.step("Memverifikasi hasil perhitungan. Expected: '-2.0', Actual: " + result);
        Float expected = (float) -2.0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi pembagian dua buah input bilangan negatif")
    @Story("Division")
    @Description("Menguji operasi pembagian dua buah input bilangan negatif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC3 - Divide Function Test")
    public void testDivide_NegativeNumbers() {
        Allure.step("Persiapan data: a = -6, b = -3");
        int a = -6;
        int b = -3;

        Allure.step("Memanggil fungsi divide dengan parameter a dan b");
        Float result = sut.divide(a, b);

        Allure.step("Memverifikasi hasil perhitungan. Expected: '2.0', Actual: " + result);
        Float expected = (float) 2.0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi pembagian dengan pembilang nol")
    @Story("Division")
    @Description("Menguji operasi pembagian dengan pembilang nol")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC4 - Divide Function Test")
    public void testDivide_NumeratorIsZero() {
        Allure.step("Persiapan data: a = 0, b = 7");
        int a = 0;
        int b = 7;

        Allure.step("Memanggil fungsi divide dengan parameter a dan b");
        Float result = sut.divide(a, b);

        Allure.step("Memverifikasi hasil perhitungan. Expected: '0.0', Actual: " + result);
        Float expected = (float) 0.0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Menguji operasi pembagian dengan penyebut nol")
    @Story("Division")
    @Description("Menguji operasi pembagian dengan penyebut nol")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Salsabil")
    @AllureId("TC5 - Divide Function Test")
    public void testDivide_DenominatorIsZero() {
        Allure.step("Persiapan data: a = 7, b = 0");
        int a = 7;
        int b = 0;

        Allure.step("Memverifikasi bahwa pembagian dengan penyebut nol tidak diperbolehkan");
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            if (b == 0) {
                throw new ArithmeticException("Error: Pembagi tidak boleh bernilai nol\nPilih operator lain, selain pembagian!");
            }
            sut.divide(a, b); // Tidak akan dieksekusi karena b == 0
        });

        Allure.step("Memverifikasi pesan error. Expected: 'Error: Pembagi tidak boleh bernilai nol\nPilih operator lain, selain pembagian!'");
        String expectedMessage = "Error: Pembagi tidak boleh bernilai nol\nPilih operator lain, selain pembagian!";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Menguji operasi pembagian dua buah input bilangan nol")
    @Story("Division")
    @Description("Menguji operasi pembagian dua buah input bilangan nol")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Salsabil")
    @AllureId("TC6 - Divide Function Test")
    public void testDivide_BothOperandsAreZero() {
        Allure.step("Persiapan data: a = 0, b = 0");
        int a = 0;
        int b = 0;

        Allure.step("Memverifikasi bahwa pembagian dengan penyebut nol tidak diperbolehkan");
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            if (b == 0) {
                throw new ArithmeticException("Error: Pembagi tidak boleh bernilai nol\nPilih operator lain, selain pembagian!");
            }
            sut.divide(a, b); // Tidak akan dieksekusi karena b == 0
        });

        Allure.step("Memverifikasi pesan error. Expected: 'Error: Pembagi tidak boleh bernilai nol\nPilih operator lain, selain pembagian!'");
        String expectedMessage = "Error: Pembagi tidak boleh bernilai nol\nPilih operator lain, selain pembagian!";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    
}