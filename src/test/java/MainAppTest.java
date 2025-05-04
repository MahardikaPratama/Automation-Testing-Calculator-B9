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

    @Test
    @DisplayName("TC1 - Menampilkan header kalkulator")
    @Story("printHeader")
    @Description("Menguji printHeader() untuk memastikan tampilan header sesuai dengan format yang diharapkan.")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Naia")
    @AllureId("TC1-printHeader")
    public void testPrintHeader_OutputCorrect() throws Exception {
        Allure.step("1. Redirect System.out ke stream sementara untuk menangkap output");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Allure.step("2. Akses metode private printHeader() menggunakan refleksi");
        Method method = MainApp.class.getDeclaredMethod("printHeader");
        method.setAccessible(true);

        Allure.step("3. Panggil fungsi printHeader()");
        method.invoke(null);

        Allure.step("4. Kembalikan System.out ke keadaan semula");
        System.setOut(originalOut);

        Allure.step("5. Verifikasi: hasil output sesuai dengan yang diharapkan");
        String nl = System.lineSeparator();
        String expectedOutput = 
            "------------------------------------------" + nl +
            "*******    Kalkulator Sederhana    *******" + nl +
            "------------------------------------------" + nl;

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    @DisplayName("TC1 - Menampilkan hasil perhitungan")
    @Story("displayResult")
    @Description("Menguji displayResult() untuk memastikan output hasil perhitungan ditampilkan dengan benar.")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Naia")
    @AllureId("TC1-displayResult")
    public void testDisplayResult_OutputCorrect() throws Exception {
        Allure.step("1. Redirect System.out ke stream sementara");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Allure.step("2. Akses metode private displayResult(int, int, String, String) menggunakan refleksi");
        Method method = MainApp.class.getDeclaredMethod("displayResult", int.class, int.class, String.class, String.class);
        method.setAccessible(true);

        Allure.step("3. Panggil fungsi displayResult(5, 2, \"+\", \"7\")");
        method.invoke(null, 5, 2, "+", "7");

        Allure.step("4. Kembalikan System.out ke keadaan semula");
        System.setOut(originalOut);

        Allure.step("5. Verifikasi hasil output sesuai harapan");
        String nl = System.lineSeparator();
        String expectedOutput = "Hasil dari 5 + 2 = 7" + nl + nl;

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    @DisplayName("TC1 - Menampilkan pesan keluar saat program selesai")
    @Story("printExitMessage")
    @Description("Menguji printExitMessage() untuk memastikan pesan perpisahan ditampilkan dengan benar.")
    @Severity(SeverityLevel.MINOR)
    @Owner("Naia")
    @AllureId("TC1-printExitMessage")
    public void testPrintExitMessage_OutputCorrect() throws Exception {
        Allure.step("1. Redirect System.out ke stream sementara");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Allure.step("2. Akses metode private printExitMessage() menggunakan refleksi");
        Method method = MainApp.class.getDeclaredMethod("printExitMessage");
        method.setAccessible(true);

        Allure.step("3. Panggil fungsi printExitMessage()");
        method.invoke(null);

        Allure.step("4. Kembalikan System.out ke keadaan semula");
        System.setOut(originalOut);

        Allure.step("5. Verifikasi hasil output sesuai harapan");
        String nl = System.lineSeparator();
        String expectedOutput = 
            "" + nl + 
            "Terima kasih telah menggunakan kalkulator!" + nl +
            nl;

        String actualOutput = outputStream.toString();
        assertEquals(expectedOutput.trim(), actualOutput.trim());    
    }

    @Test
    @DisplayName("Menguji input valid 'y' pada askRepeat")
    @Story("Fungsi pengulangan kalkulasi")
    @Description("Menguji bahwa fungsi askRepeat mengembalikan 'true' ketika input valid 'y' diberikan.")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Naia")
    @AllureId("TC1-askRepeat-y")
    public void testAskRepeat_InputY_ReturnsTrue() throws Exception {
        Allure.step("1. Simulasikan input pengguna dengan 'y'");
        String simulatedInput = "y\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Allure.step("2. Alihkan System.out untuk menangkap prompt yang dicetak");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Scanner scanner = new Scanner(System.in);

        Allure.step("3. Panggil askRepeat(scanner)");
        Method method = MainApp.class.getDeclaredMethod("askRepeat", Scanner.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(null, scanner);

        Allure.step("4. Verifikasi prompt dicetak ke layar");
        assertTrue(outContent.toString().contains("Apakah Anda ingin menghitung lagi? (y/n):"), "Prompt tidak dicetak dengan benar");

        Allure.step("5. Verifikasi hasil return adalah true");
        assertTrue(result, "Fungsi tidak mengembalikan 'true' untuk input 'y'");
    }

    @Test
    @DisplayName("Menguji input valid 'n' pada askRepeat")
    @Story("Fungsi pengulangan kalkulasi")
    @Description("Menguji bahwa fungsi askRepeat mengembalikan 'false' ketika input valid 'n' diberikan.")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Naia")
    @AllureId("TC2-askRepeat-n")
    public void testAskRepeat_InputN_ReturnsFalse() throws Exception {
        Allure.step("1. Simulasikan input pengguna dengan 'n'");
        String simulatedInput = "n\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Allure.step("2. Alihkan System.out untuk menangkap prompt yang dicetak");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Scanner scanner = new Scanner(System.in);

        Allure.step("3. Panggil askRepeat(scanner)");
        Method method = MainApp.class.getDeclaredMethod("askRepeat", Scanner.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(null, scanner);

        Allure.step("4. Verifikasi prompt dicetak ke layar");
        assertTrue(outContent.toString().contains("Apakah Anda ingin menghitung lagi? (y/n):"), "Prompt tidak dicetak dengan benar");

        Allure.step("5. Verifikasi hasil return adalah false");
        assertFalse(result, "Fungsi tidak mengembalikan 'false' untuk input 'n'");
    }

    @Test
    @DisplayName("Input tidak valid meminta input ulang")
    @Story("askRepeat")
    @Description("Menguji fungsi askRepeat() saat input pertama tidak valid, kemudian valid.")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Naia")
    @AllureId("TC3-askRepeat")
    public void testAskRepeat_InvalidThenValidInput() throws Exception {
        Allure.step("1. Simulasikan input: 'a' lalu 'y'");
        String simulatedInput = "a\ny\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Allure.step("2. Tangkap output terminal");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Allure.step("3. Panggil fungsi askRepeat()");
        Scanner scanner = new Scanner(System.in);
        Method method = MainApp.class.getDeclaredMethod("askRepeat", Scanner.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(null, scanner);

        Allure.step("4. Verifikasi: return true dan output mengandung pesan error");
        String output = outputStream.toString();
        assertTrue(result, "Return tidak sesuai, seharusnya 'true' setelah input valid.");
        assertTrue(output.contains("Error: Pilihan tidak valid. Silakan masukkan 'y' atau 'n'."), "Pesan error tidak muncul untuk input tidak valid.");

        Allure.step("5. Verifikasi prompt dicetak dengan benar");
        assertTrue(output.contains("Apakah Anda ingin menghitung lagi? (y/n):"), "Prompt tidak dicetak dengan benar setelah input tidak valid.");
    }

    @Test
    @DisplayName("Menguji pengambilan input operator dari pengguna")
    @Story("Fungsi input operator")
    @Description("Menguji bahwa getOperatorInput() mencetak prompt dan membaca input operator dengan benar.")
    @Severity(SeverityLevel.MINOR)
    @Owner("Naia")
    @AllureId("TC1-getOperatorInput")
    public void testGetOperatorInput_ReturnsUserInput() throws Exception {
        Allure.step("1. Simulasikan input pengguna dengan operator '+'");
        String simulatedInput = "+\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Allure.step("2. Alihkan System.out untuk menangkap prompt yang dicetak");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Scanner scanner = new Scanner(System.in);

        Allure.step("3. Panggil getOperatorInput(scanner) untuk membaca operator");
        Method method = MainApp.class.getDeclaredMethod("getOperatorInput", Scanner.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, scanner);

        Allure.step("4. Verifikasi prompt dicetak ke layar");
        assertTrue(outContent.toString().contains("Masukkan operator (+, -, *, /):"), "Prompt tidak dicetak dengan benar");

        Allure.step("5. Verifikasi nilai yang dikembalikan adalah '+'");
        assertEquals("+", result, "Input operator yang dibaca tidak sesuai");
    }

    @Test 
    @DisplayName("Menguji input operator valid: prompt ditampilkan dan input dikembalikan")
    @Story("inputOperator")
    @Description("Menguji inputOperator() saat pengguna langsung menginput operator valid (+, -, *, /) dan prompt ditampilkan.")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Naia")
    @AllureId("TC1-inputOperator")
    public void testInputOperator_ValidInput_WithPromptCheck() throws Exception {
        Allure.step("1. Siapkan input simulasi: \"+\"");
        String simulatedInput = "+\n";  // input valid
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Allure.step("2. Redirect System.out untuk menangkap output prompt");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; // simpan referensi asli
        System.setOut(new PrintStream(outContent));

        Allure.step("3. Buat objek Scanner dan Validate");
        Scanner scanner = new Scanner(System.in);
        Validate validate = new Validate();

        Allure.step("4. Akses metode private inputOperator(scanner, validate, num2) menggunakan refleksi");
        Method method = MainApp.class.getDeclaredMethod("inputOperator", Scanner.class, Validate.class, int.class);
        method.setAccessible(true);

        Allure.step("5. Panggil fungsi inputOperator(scanner, validate, 10)");
        String result = (String) method.invoke(null, scanner, validate, 10);

        Allure.step("6. Kembalikan System.out ke semula");
        System.setOut(originalOut);

        Allure.step("7. Verifikasi: hasil akhir adalah operator \"+\"");
        assertEquals("+", result);

        Allure.step("8. Verifikasi: prompt \"Masukkan operator\" ditampilkan");
        assertTrue(outContent.toString().contains("Masukkan operator"));
    }

    @Test 
    @DisplayName("Menguji input operator tidak valid, lalu valid disertai output prompt dan error")
    @Story("inputOperator")
    @Description("Menguji inputOperator() saat input pertama tidak valid (misal: '%'), kemudian input valid (misal: '*'), serta output prompt dan error muncul.")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Naia")
    @AllureId("TC2-inputOperator")
    public void testInputOperator_InvalidThenValidInput_WithPromptAndErrorCheck() throws Exception {
        Allure.step("1. Siapkan input simulasi: \"%\" (tidak valid) dan \"*\" (valid)");
        String simulatedInput = "%\n*\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Allure.step("2. Redirect System.out untuk menangkap output prompt dan pesan error");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Allure.step("3. Buat objek Scanner dan Validate");
        Scanner scanner = new Scanner(System.in);
        Validate validate = new Validate();

        Allure.step("4. Akses metode private inputOperator(scanner, validate, num2) menggunakan refleksi");
        Method method = MainApp.class.getDeclaredMethod("inputOperator", Scanner.class, Validate.class, int.class);
        method.setAccessible(true);

        Allure.step("5. Panggil fungsi inputOperator(scanner, validate, 10)");
        String result = (String) method.invoke(null, scanner, validate, 10);

        Allure.step("6. Kembalikan System.out ke semula");
        System.setOut(originalOut);

        Allure.step("7. Verifikasi: hasil akhir adalah operator \"*\"");
        assertEquals("*", result);

        String output = outContent.toString();

        Allure.step("8. Verifikasi: prompt pertama ditampilkan");
        assertTrue(output.contains("Masukkan operator"), "Prompt tidak ditemukan");

        Allure.step("9. Verifikasi: error karena input '%' tidak valid ditampilkan");
        assertTrue(output.contains("Error: Operator yang diperbolehkan hanya +, -, *, /"), "Pesan error tidak ditemukan");

        Allure.step("10. Verifikasi: permintaan ulang input ditampilkan");
        assertTrue(output.contains("Silakan masukkan operator yang valid!"), "Permintaan input ulang tidak ditemukan");
    }

    @Test
    @DisplayName("Menguji operator valid dan bukan pembagian nol")
    @Story("isValidOperatorInput")
    @Description("Menguji isValidOperatorInput() saat operator valid dan bukan pembagian.")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Naia")
    @AllureId("TC1-isValidOperatorInput")
    public void testIsValidOperatorInput_ValidNonDivision() throws Exception {
        String operator = "+";
        int num2 = 5;

        Allure.step("1. Buat instance Validate");
        Validate validate = new Validate();

        Allure.step("2. Akses metode private static isValidOperatorInput() menggunakan refleksi");
        Method method = MainApp.class.getDeclaredMethod("isValidOperatorInput", Validate.class, String.class, int.class);
        method.setAccessible(true);

        Allure.step("3. Panggil fungsi dengan operator \"" + operator + "\" dan num2 = " + num2);
        boolean result = (boolean) method.invoke(null, validate, operator, num2);

        Allure.step("4. Verifikasi: fungsi mengembalikan true");
        assertTrue(result);
    }

    @Test
    @DisplayName("Memvalidasi operator tidak valid")
    @Story("isValidOperatorInput")
    @Description("Menguji isValidOperatorInput() saat operator tidak valid.")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Naia")
    @AllureId("TC2-isValidOperatorInput")
    public void testIsValidOperatorInput_InvalidOperator() throws Exception {
        String operator = "%";
        int num2 = 10;

        Allure.step("1. Redirect System.out untuk menangkap output");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Allure.step("2. Buat instance Validate");
        Validate validate = new Validate();

        Allure.step("3. Akses metode private static isValidOperatorInput() menggunakan refleksi");
        Method method = MainApp.class.getDeclaredMethod("isValidOperatorInput", Validate.class, String.class, int.class);
        method.setAccessible(true);

        Allure.step("4. Panggil fungsi dengan operator \"" + operator + "\"");
        boolean result = (boolean) method.invoke(null, validate, operator, num2);

        Allure.step("5. Kembalikan System.out");
        System.setOut(originalOut);

        Allure.step("6. Verifikasi: hasil = false dan output berisi pesan error");
        String output = outContent.toString();
        assertFalse(result);
        assertTrue(output.contains("Operator yang diperbolehkan hanya"));
        assertTrue(output.contains("masukkan operator yang valid"));
    }

    @Test
    @DisplayName("Menguji operator pembagian tapi num2 == 0")
    @Story("isValidOperatorInput")
    @Description("Menguji isValidOperatorInput() saat operator adalah '/' dan pembaginya nol.")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Naia")
    @AllureId("TC3-isValidOperatorInput")
    public void testIsValidOperatorInput_DivideByZero() throws Exception {
        String operator = "/";
        int num2 = 0;

        Allure.step("1. Redirect System.out untuk menangkap output");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Allure.step("2. Buat instance Validate");
        Validate validate = new Validate();

        Allure.step("3. Akses metode private static isValidOperatorInput() menggunakan refleksi");
        Method method = MainApp.class.getDeclaredMethod("isValidOperatorInput", Validate.class, String.class, int.class);
        method.setAccessible(true);

        Allure.step("4. Panggil fungsi dengan operator \"" + operator + "\" dan num2 = 0");
        boolean result = (boolean) method.invoke(null, validate, operator, num2);

        Allure.step("5. Kembalikan System.out");
        System.setOut(originalOut);

        Allure.step("6. Verifikasi: hasil = false dan pesan error muncul");
        String output = outContent.toString();
        assertFalse(result);
        assertTrue(output.contains("Pembagi tidak boleh bernilai nol"));
        assertTrue(output.contains("Pilih operator lain"));
    }
}
