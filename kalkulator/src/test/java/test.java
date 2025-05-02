import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import com.calculator.Calculate;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Calculator Operations")
@Feature("Basic Arithmetic")
class CalculateTest {

    private Calculate calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculate();
    }

    @Test
    @Story("Addition")
    @Description("Verify that addition of two integers is correct")
    void testAdd() {
        int result = calculator.add(3, 5);
        assertEquals(8, result);
    }

    @Test
    @Story("Subtraction")
    @Description("Verify that subtraction of two integers is correct")
    void testSubtract() {
        int result = calculator.subtract(10, 4);
        assertEquals(6, result);
    }

    @Test
    @Story("Multiplication")
    @Description("Verify that multiplication of two integers is correct")
    void testMultiply() {
        int result = calculator.multiply(6, 7);
        assertEquals(42, result);
    }

    @Test
    @Story("Division")
    @Description("Verify that division of two integers returns correct float value")
    void testDivide() {
        float result = calculator.divide(10, 2);
        assertEquals(5.0f, result);
    }

    @Test
    @Story("Division by Zero")
    @Description("Verify that dividing by zero throws ArithmeticException")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }
}
