import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.calculator.MainApp;
import com.calculator.Validate;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Validasi MainApp")
@Feature("MainApp")
public class MainAppTest {
    @BeforeEach
    public void setUp() throws Exception {
        new MainApp();
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    @DisplayName("Menguji kalkulator dijalankan dua kali lalu keluar")
    @Story("Kalkulator dijalankan dua kali")
    @Description("Menguji runCalculator() saat pengguna memilih 'y' lalu 'n'.")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Mahardika")
    @AllureId("TC1-MainApp-runCalculator")
    public void testRunCalculator_RunTwiceThenExit() throws Exception {
        Allure.step("1. Simulasikan input: 10 + 20 =, ulang (y), 30 - 15 =, keluar (n)");
        String simulatedInput = "10\n20\n+\ny\n30\n15\n-\nn\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Allure.step("2. Alihkan System.out untuk menangkap output program");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Allure.step("3. Siapkan Scanner dan akses fungsi runCalculator(scanner) via refleksi");
        Scanner scanner = new Scanner(System.in);
        Method method = MainApp.class.getDeclaredMethod("runCalculator", Scanner.class);
        method.setAccessible(true);
        method.invoke(null, scanner);

        String output = outContent.toString();

        Allure.step("4. Verifikasi header program dicetak");
        assertTrue(output.contains("Kalkulator Sederhana"), "Header tidak ditampilkan");

        Allure.step("5. Verifikasi perhitungan dijalankan dua kali");
        long hasilCount = output.lines().filter(line -> line.contains("Hasil dari")).count();
        assertEquals(2, hasilCount, "Perhitungan seharusnya dijalankan dua kali");

        Allure.step("6. Verifikasi pesan keluar ditampilkan setelah input 'n'");
        assert output.contains("Terima kasih telah menggunakan kalkulator!") : "Pesan keluar tidak ditemukan";
    }

    @Test
    @DisplayName("Menguji kalkulator dijalankan satu kali lalu keluar")
    @Story("Kalkulator dijalankan satu kali")
    @Description("Menguji runCalculator() saat pengguna langsung memilih 'n' setelah perhitungan.")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Mahardika")
    @AllureId("TC2-MainApp-runCalculator")
    public void testRunCalculator_RunOnceThenExit() throws Exception {
        Allure.step("1. Simulasikan input: 5 * 3 =, lalu keluar (n)");
        String simulatedInput = "5\n3\n*\nn\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Allure.step("2. Alihkan System.out untuk menangkap output");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Allure.step("3. Siapkan Scanner dan akses fungsi runCalculator(scanner) via refleksi");
        Scanner scanner = new Scanner(System.in);
        Method method = MainApp.class.getDeclaredMethod("runCalculator", Scanner.class);
        method.setAccessible(true);
        method.invoke(null, scanner);

        String output = outContent.toString();

        Allure.step("4. Verifikasi header program dicetak");
        assertTrue(output.contains("Kalkulator Sederhana"), "Header tidak ditampilkan");

        Allure.step("5. Verifikasi perhitungan hanya dijalankan sekali");
        long hasilCount = output.lines().filter(line -> line.contains("Hasil dari")).count();
        assertEquals(1, hasilCount, "Perhitungan seharusnya dijalankan sekali");

        Allure.step("6. Verifikasi program keluar setelah input 'n'");
        assert output.contains("Terima kasih telah menggunakan kalkulator!") : "Pesan keluar tidak ditemukan";
    }

    @Test
    @DisplayName("Menguji pengubahan input string menjadi bilangan bulat")
    @Story("parseValidNumber")
    @Description("Menguji apakah fungsi parseValidNumber() berhasil mengubah string valid menjadi int.")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mahardika")
    @AllureId("TC1-parseValidNumber")
    public void testParseValidNumber() throws Exception {
        String input = "123";

        Allure.step("1. Siapkan input string: \"" + input + "\"");

        Allure.step("2. Akses metode private static parseValidNumber(String) menggunakan refleksi");
        Method method = MainApp.class.getDeclaredMethod("parseValidNumber", String.class);
        method.setAccessible(true); // membuka akses private

        Allure.step("3. Panggil fungsi parseValidNumber(input)");
        int result = (int) method.invoke(null, input);
        Allure.step("4. Verifikasi hasil: fungsi mengembalikan nilai int 123");
        assertEquals(123, result);
    }

    @Test
    @DisplayName("Menguji pemanggilan fungsi isNumeric menghasilkan false")
    @Story("isValidNumberInput")
    @Description("Menguji apakah fungsi isNumeric menghasilkan false.")
    @Severity(SeverityLevel.MINOR)
    @Owner("Mahardika")
    @AllureId("TC1-isValidNumberInput")
    public void testIsNumericFalse() throws Exception {
        String input = "abc";

        Allure.step("1. Siapkan input string: \"" + input + "\"");

        Allure.step("2. Akses metode private static isValidNumberInput(Validate, String) menggunakan refleksi");
        Method method = MainApp.class.getDeclaredMethod("isValidNumberInput", Validate.class, String.class);
        method.setAccessible(true); // membuka akses private

        Allure.step("3. Panggil fungsi isValidNumberInput(validate, input)");
        boolean result = (boolean) method.invoke(null, new Validate(), input);
        Allure.step("4. Verifikasi hasil: fungsi mengembalikan nilai false");
        assertFalse(result);
    }

    @Test
    @DisplayName("Menguji pemanggilan fungsi isInRange menghasilkan false")
    @Story("isValidNumberInput")
    @Description("Menguji apakah fungsi isInRange menghasilkan false.")
    @Severity(SeverityLevel.MINOR)
    @Owner("Mahardika")
    @AllureId("TC2-isValidNumberInput")
    public void testIsInRangeFalse() throws Exception {
        String input = "40000";

        Allure.step("1. Siapkan input string: \"" + input + "\"");

        Allure.step("2. Akses metode private static isValidNumberInput(Validate, String) menggunakan refleksi");
        Method method = MainApp.class.getDeclaredMethod("isValidNumberInput", Validate.class, String.class);
        method.setAccessible(true); // membuka akses private

        Allure.step("3. Panggil fungsi isValidNumberInput(validate, input)");
        boolean result = (boolean) method.invoke(null, new Validate(), input);
        Allure.step("4. Verifikasi hasil: fungsi mengembalikan nilai false");
        assertFalse(result);
    }

    @Test
    @DisplayName("Menguji pemanggilan fungsi isValidNumberInput menghasilkan true")
    @Story("isValidNumberInput")
    @Description("Menguji apakah fungsi isValidNumberInput menghasilkan true")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mahardika")
    @AllureId("TC3-isValidNumberInput")
    public void testIsNumericAndIsInRangeTrue() throws Exception {
        String input = "123";

        Allure.step("1. Siapkan input string: \"" + input + "\"");

        Allure.step("2. Akses metode private static isValidNumberInput(Validate, String) menggunakan refleksi");
        Method method = MainApp.class.getDeclaredMethod("isValidNumberInput", Validate.class, String.class);
        method.setAccessible(true); // membuka akses private

        Allure.step("3. Panggil fungsi isValidNumberInput(validate, input)");
        boolean result = (boolean) method.invoke(null, new Validate(), input);
        Allure.step("4. Verifikasi hasil: fungsi mengembalikan nilai false");
        assertTrue(result);
    }

    @Test
    @DisplayName("Menguji input valid: diterima dan dikonversi menjadi angka")
    @Story("inputNumber")
    @Description("Menguji inputNumber() saat pengguna langsung menginput angka valid.")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Mahardika")
    @AllureId("TC1-inputNumber")
    public void testInputNumber_InputValid() throws Exception {
        Allure.step("1. Siapkan input simulasi: \"123\"");
        String simulatedInput = "123\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Allure.step("2. Buat objek Scanner dan Validate");
        Scanner scanner = new Scanner(System.in);
        Validate validate = new Validate();

        Allure.step("3. Akses metode private inputNumber(scanner, validate, prompt) menggunakan refleksi");
        Method method = MainApp.class.getDeclaredMethod("inputNumber", Scanner.class, Validate.class, String.class);
        method.setAccessible(true);

        Allure.step("4. Panggil fungsi inputNumber(scanner, validate, \"Masukkan angka:\")");
        int result = (int) method.invoke(null, scanner, validate, "Masukkan angka:");

        Allure.step("5. Verifikasi: hasil akhir adalah angka 123");
        assertEquals(123, result);
    }

    @Test
    @DisplayName("Menguji input tidak valid: diminta input ulang hingga valid")
    @Story("inputNumber")
    @Description("Menguji inputNumber() saat input pertama tidak valid dan input kedua valid.")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Mahardika")
    @AllureId("TC2-inputNumber")
    public void testInputNumber_InvalidThenValid() throws Exception {
        Allure.step("1. Siapkan input simulasi: \"abc\" (tidak valid), lalu \"456\" (valid)");
        String simulatedInput = "abc\n456\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Allure.step("2. Buat objek Scanner dan Validate");
        Scanner scanner = new Scanner(System.in);
        Validate validate = new Validate();

        Allure.step("3. Akses metode private inputNumber(scanner, validate, prompt) menggunakan refleksi");
        Method method = MainApp.class.getDeclaredMethod("inputNumber", Scanner.class, Validate.class, String.class);
        method.setAccessible(true);

        Allure.step("4. Panggil fungsi inputNumber(scanner, validate, \"Masukkan angka:\")");
        int result = (int) method.invoke(null, scanner, validate, "Masukkan angka:");

        Allure.step("5. Verifikasi: hasil akhir adalah angka 456");
        assertEquals(456, result);
    }

    @Test
    @DisplayName("Menguji pengambilan input dari pengguna")
    @Story("Fungsi input dasar")
    @Description("Menguji bahwa getInput() mencetak prompt dan membaca input dari pengguna dengan benar.")
    @Severity(SeverityLevel.MINOR)
    @Owner("Mahardika")
    @AllureId("TC1-getInput")
    public void testGetInput_ReturnsUserInput() throws Exception {
        Allure.step("1. Simulasikan input pengguna dengan string \"123\"");
        String simulatedInput = "123\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Allure.step("2. Alihkan System.out untuk menangkap prompt yang dicetak");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Scanner scanner = new Scanner(System.in);

        Allure.step("3. Panggil getInput(scanner, \"Masukkan angka pertama: \")");
        Method method = MainApp.class.getDeclaredMethod("getInput", Scanner.class, String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, scanner, "Masukkan angka pertama: ");

        Allure.step("4. Verifikasi prompt dicetak ke layar");
        assertTrue(outContent.toString().contains("Masukkan angka pertama:"), "Prompt tidak dicetak dengan benar");

        Allure.step("5. Verifikasi nilai yang dikembalikan adalah '123'");
        assertEquals("123", result, "Input yang dibaca tidak sesuai");
    }

}
