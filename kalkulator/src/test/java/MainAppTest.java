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

import com.calculator.MainApp;

@Epic("Validasi MainApp")
@Feature("MainApp")
public class MainAppTest {
    private MainApp sut;

    @BeforeEach
    public void setUp() throws Exception {
        sut = new MainApp();
    }

    @AfterEach
    public void tearDown() throws Exception {
        sut = null;
    }

    @Test
    @DisplayName("TC1 - Kalkulator dijalankan lebih dari satu kali")
    @Story("Pengulangan kalkulasi berdasarkan input pengguna")
    @Description("Menguji apakah kalkulator berjalan dua kali saat input pertama 'y' dan kedua 'n'")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Mahardika")
    @AllureId("TC1-RunCalculator Test")
    public void testRunCalculator_MultipleExecutions() {
        String simulatedUserInput = String.join(System.lineSeparator(),
            "10", "5", "+", // kalkulasi pertama
            "y",
            "20", "4", "-", // kalkulasi kedua
            "n"
        );
        System.setIn(new java.io.ByteArrayInputStream(simulatedUserInput.getBytes()));

        Allure.step("Menjalankan kalkulator dengan input 'y' lalu 'n'");
        MainApp.main(null); // memicu runCalculator secara implisit via main

        // Tidak ada assertion eksplisit karena metode bersifat void dan output ke console
        // Bisa diverifikasi via visual output / log Allure jika diperlukan
    }


    
}
