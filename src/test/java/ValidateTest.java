import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

import com.calculator.Validate;

@Epic("Validasi Input")
@Feature("Validasi Input Angka dan Operator")
public class ValidateTest {
    private Validate sut;

    @BeforeEach
    public void setUp() throws Exception {
        sut = new Validate();
    }

    @AfterEach
    public void tearDown() throws Exception {
        sut = null;
    }

    @Test
    @DisplayName("Menguji input berupa angka positif")
    @Story("Validasi Angka")
    @Description("Menguji input valid berupa angka positif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mahardika")
    @AllureId("TC1 - isNumeric Test")
    public void testIsNumeric_PositiveNumber() {
        Allure.step("Persiapan data: numStr = \"123\"");
        String numStr = "123";

        Allure.step("Memanggil fungsi isNumeric()");
        boolean result = sut.isNumeric(numStr);

        Allure.step("Memverifikasi hasil. Expected: true, Actual: " + result);
        assertTrue(result);
    }

    @Test
    @DisplayName("Menguji input berupa angka negatif")
    @Story("Validasi Angka")
    @Description("Menguji input valid berupa angka negatif")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mahardika")
    @AllureId("TC2 - isNumeric Test")
    public void testIsNumeric_NegativeNumber() {
        Allure.step("Persiapan data: numStr = \"-456\"");
        String numStr = "-456";

        Allure.step("Memanggil fungsi isNumeric()");
        boolean result = sut.isNumeric(numStr);

        Allure.step("Memverifikasi hasil. Expected: true, Actual: " + result);
        assertTrue(result);
    }

    @Test
    @DisplayName("Menguji input berupa huruf non-numerik")
    @Story("Validasi Angka")
    @Description("Menguji input invalid berupa huruf")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mahardika")
    @AllureId("TC3 - isNumeric Test")
    public void testIsNumeric_NonNumericLetters() {
        Allure.step("Persiapan data: numStr = \"abc\"");
        String numStr = "abc";

        Allure.step("Memanggil fungsi isNumeric()");
        boolean result = sut.isNumeric(numStr);

        Allure.step("Memverifikasi hasil. Expected: false, Actual: " + result);
        assertFalse(result);
    }

    @Test
    @DisplayName("Menguji input berupa campuran angka dan huruf")
    @Story("Validasi Angka")
    @Description("Menguji input invalid berupa campuran angka dan huruf")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mahardika")
    @AllureId("TC4 - isNumeric Test")
    public void testIsNumeric_MixedCharacters() {
        Allure.step("Persiapan data: numStr = \"12ab\"");
        String numStr = "12ab";

        Allure.step("Memanggil fungsi isNumeric()");
        boolean result = sut.isNumeric(numStr);

        Allure.step("Memverifikasi hasil. Expected: false, Actual: " + result);
        assertFalse(result);
    }

    @Test
    @DisplayName("Menguji input kosong")
    @Story("Validasi Angka")
    @Description("Menguji input invalid berupa string kosong")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mahardika")
    @AllureId("TC5 - isNumeric Test")
    public void testIsNumeric_EmptyString() {
        Allure.step("Persiapan data: numStr = \"\"");
        String numStr = "";

        Allure.step("Memanggil fungsi isNumeric()");
        boolean result = sut.isNumeric(numStr);

        Allure.step("Memverifikasi hasil. Expected: false, Actual: " + result);
        assertFalse(result);
    }

    @Test
    @DisplayName("Menguji input lebih besar dari batas atas")
    @Story("Validasi Rentang Angka")
    @Description("Menguji input angka yang melebihi batas atas dari rentang valid (32,767)")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mahardika")
    @AllureId("TC1 - isInRange Test")
    public void testIsInRange_AboveUpperBound() {
        Allure.step("Persiapan data: numStr = \"40000\"");
        String numStr = "40000";

        Allure.step("Memanggil fungsi isInRange()");
        boolean result = sut.isInRange(numStr);

        Allure.step("Memverifikasi hasil. Expected: false, Actual: " + result);
        assertFalse(result);
    }

    @Test
    @DisplayName("Menguji input lebih kecil dari batas bawah")
    @Story("Validasi Rentang Angka")
    @Description("Menguji input angka yang lebih kecil dari batas bawah rentang valid (-32,768)")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mahardika")
    @AllureId("TC2 - isInRange Test")
    public void testIsInRange_BelowLowerBound() {
        Allure.step("Persiapan data: numStr = \"-40000\"");
        String numStr = "-40000";

        Allure.step("Memanggil fungsi isInRange()");
        boolean result = sut.isInRange(numStr);

        Allure.step("Memverifikasi hasil. Expected: false, Actual: " + result);
        assertFalse(result);
    }

    @Test
    @DisplayName("Menguji input dalam rentang valid")
    @Story("Validasi Rentang Angka")
    @Description("Menguji input angka dalam rentang valid (-32,768 hingga 32,767)")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mahardika")
    @AllureId("TC3 - isInRange Test")
    public void testIsInRange_ValidRange() {
        Allure.step("Persiapan data: numStr = \"0\"");
        String numStr = "0";

        Allure.step("Memanggil fungsi isInRange()");
        boolean result = sut.isInRange(numStr);

        Allure.step("Memverifikasi hasil. Expected: true, Actual: " + result);
        assertTrue(result);
    }

    @Test
    @DisplayName("Menguji kondisi valid pembagian, saat penyebut (num2) bukan nol")
    @Story("Validasi Pembagian")
    @Description("Menguji kondisi valid pembagian, saat penyebut (num2) bukan nol")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC1 - isValidDivision Test")
    public void testIsValidDivision_Valid() {
        Allure.step("Persiapan data: num2 = 5");
        int num2 = 5;

        Allure.step("Memanggil fungsi isValidDivision dengan parameter num2");
        Validate validate = new Validate();
        boolean result = validate.isValidDivision(num2);

        Allure.step("Memverifikasi hasil validasi. Expected: true, Actual: " + result);
        assertTrue(result, "Fungsi isValidDivision seharusnya mengembalikan true untuk num2 != 0");
    }

    @Test
    @DisplayName("Menguji kondisi tidak valid pembagian, saat penyebut (num2) bernilai nol")
    @Story("Validasi Pembagian")
    @Description("Menguji kondisi tidak valid pembagian, saat penyebut (num2) bernilai nol")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC2 - isValidDivision Test")
    public void testIsValidDivision_Invalid() {
        Allure.step("Persiapan data: num2 = 0");
        int num2 = 0;

        Allure.step("Memanggil fungsi isValidDivision dengan parameter num2");
        Validate validate = new Validate();
        boolean result = validate.isValidDivision(num2);

        Allure.step("Memverifikasi hasil validasi. Expected: false, Actual: " + result);
        assertFalse(result, "Fungsi isValidDivision seharusnya mengembalikan false untuk num2 == 0");
    }

    @Test
    @DisplayName("Menguji input operator valid karena termasuk ke dalam (+, -, *, /)")
    @Story("Validasi Operator")
    @Description("Menguji input operator valid karena termasuk ke dalam (+, -, *, /)")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC1 - isValidOperator Test")
    public void testIsValidOperator_Valid() {
        Allure.step("Persiapan data: operator = \"+\"");
        String operator = "+";

        Allure.step("Memanggil fungsi isValidOperator dengan parameter operator");
        Validate validate = new Validate();
        boolean result = validate.isValidOperator(operator);

        Allure.step("Memverifikasi hasil validasi. Expected: true, Actual: " + result);
        assertTrue(result, "Fungsi isValidOperator seharusnya mengembalikan true untuk operator valid (+, -, *, /)");
    }

    @Test
    @DisplayName("Menguji input operator tidak valid karena bukan (+, -, *, /)")
    @Story("Validasi Operator")
    @Description("Menguji input operator tidak valid karena bukan (+, -, *, /)")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Salsabil")
    @AllureId("TC2 - isValidOperator Test")
    public void testIsValidOperator_Invalid() {
        Allure.step("Persiapan data: operator = \"x\"");
        String operator = "x";

        Allure.step("Memanggil fungsi isValidOperator dengan parameter operator");
        Validate validate = new Validate();
        boolean result = validate.isValidOperator(operator);

        Allure.step("Memverifikasi hasil validasi. Expected: false, Actual: " + result);
        assertFalse(result, "Fungsi isValidOperator seharusnya mengembalikan false untuk operator tidak valid");
    }


}
