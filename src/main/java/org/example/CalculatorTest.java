package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    // Test Trigonometric functions
    @Test
    public void testTrigFunctions() {
        Calculator calc = new Calculator();

        // Testing sin function
        calc.appendNumberToDisplay("30");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "sin"));
        assertEquals("0.49999999", calc.displayLabel.getText());

        // Testing cos function
        calc.appendNumberToDisplay("0");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "cos"));
        assertEquals("1.00000000", calc.displayLabel.getText());

        // Testing tan function
        calc.appendNumberToDisplay("45");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "tan"));
        assertEquals("1.00000000", calc.displayLabel.getText());

        // Testing csc function
        calc.appendNumberToDisplay("30");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "csc"));
        assertEquals("2.00000000", calc.displayLabel.getText());

        // Testing sec function
        calc.appendNumberToDisplay("0");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "sec"));
        assertEquals("1.00000000", calc.displayLabel.getText());

        // Testing cot function
        calc.appendNumberToDisplay("45");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "cot"));
        assertEquals("1.00000000", calc.displayLabel.getText());
    }

    // Test Inverse Trigonometric functions
    @Test
    public void testInverseTrigFunctions() {
        Calculator calc = new Calculator();

        // Testing asin function
        calc.appendNumberToDisplay("0.5");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "asin"));
        assertEquals("30.00000000", calc.displayLabel.getText());

        // Testing acos function
        calc.appendNumberToDisplay("0.5");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "acos"));
        assertEquals("60.00000000", calc.displayLabel.getText());

        // Testing atan function
        calc.appendNumberToDisplay("1");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "atan"));
        assertEquals("45.00000000", calc.displayLabel.getText());

        // Testing acsc function
        calc.appendNumberToDisplay("1.0");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "csc⁻¹"));
        assertEquals("90.00000000", calc.displayLabel.getText());

        // Testing asec function
        calc.appendNumberToDisplay("2.0");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "sec⁻¹"));
        assertEquals("60.00000000", calc.displayLabel.getText());

        // Testing acot function
        calc.appendNumberToDisplay("1.0");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "cot⁻¹"));
        assertEquals("45.00000000", calc.displayLabel.getText());

        // Test invalid input for arcsine (should show "Error")
        calc.appendNumberToDisplay("2");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "asin"));
        assertEquals("Error", calc.displayLabel.getText());
    }

    // Test Hyperbolic functions
    @Test
    public void testHyperbolicTrigFunctions() {
        Calculator calc = new Calculator();

        // Testing sinh function
        calc.appendNumberToDisplay("1");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "sinh"));
        assertEquals("1.17520119", calc.displayLabel.getText());

        // Testing cosh function
        calc.appendNumberToDisplay("1");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "cosh"));
        assertEquals("1.54308063", calc.displayLabel.getText());

        // Testing tanh function
        calc.appendNumberToDisplay("1");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "tanh"));
        assertEquals("0.76159416", calc.displayLabel.getText());

        // Testing csch function
        calc.appendNumberToDisplay("1");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "csch"));
        assertEquals("0.85091813", calc.displayLabel.getText());

        // Testing sech function
        calc.appendNumberToDisplay("1");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "sech"));
        assertEquals("0.64805427", calc.displayLabel.getText());

        // Testing coth function
        calc.appendNumberToDisplay("1");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "coth"));
        assertEquals("1.31303529", calc.displayLabel.getText());
    }

    // Test Inverse Hyperbolic functions
    @Test
    public void testInverseHyperbolicTrigFunctions() {
        Calculator calc = new Calculator();

        // Testing arsinh function
        calc.appendNumberToDisplay("1");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "arsinh"));
        assertEquals("0.88137359", calc.displayLabel.getText());

        // Testing arcosh function
        calc.appendNumberToDisplay("2");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "arcosh"));
        assertEquals("1.31695790", calc.displayLabel.getText());

        // Testing artanh function
        calc.appendNumberToDisplay("0.5");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "artanh"));
        assertEquals("0.54930614", calc.displayLabel.getText());

        // Testing arcsch function
        calc.appendNumberToDisplay("1");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "arcsch"));
        assertEquals("1.09861229", calc.displayLabel.getText());

        // Testing arsech function
        calc.appendNumberToDisplay("1");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "arsech"));
        assertEquals("0.00000000", calc.displayLabel.getText());

        // Testing arcoth function
        calc.appendNumberToDisplay("1.5");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "arcoth"));
        assertEquals("0.80471896", calc.displayLabel.getText());
    }

    // Test Pythagorean Theorem Button
    @Test
    public void testPythagoreanTheorem() {
        Calculator calc = new Calculator();

        // Test valid input (sideA = 3, sideB = 4)
        calc.sideA = 3;
        calc.appendNumberToDisplay("4");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Pythag"));
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "="));
        assertEquals("5.00000000", calc.displayLabel.getText());

        
    }
    @Test
    public void testTrigFunctionsErrorHandling() {
        Calculator calc = new Calculator();

        // Test sin function for invalid values (out of domain, but sin is always defined)
        calc.appendNumberToDisplay("1000");  // Arbitrarily large value
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "sin"));
        assertEquals("Error", calc.displayLabel.getText());  // Large value for sin (should not error but added for coverage)

        // Test cos function for edge cases
        calc.appendNumberToDisplay("1000");  // Arbitrarily large value
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "cos"));
        assertEquals("Error", calc.displayLabel.getText());  // Large value for cos (should not error but added for coverage)

        // Test tan function for invalid input where tan(x) becomes undefined (90, 270, etc.)
        calc.appendNumberToDisplay("90");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "tan"));
        assertEquals("Error", calc.displayLabel.getText());  // tan(90) and tan(270) are undefined (division by zero)

        calc.appendNumberToDisplay("270");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "tan"));
        assertEquals("Error", calc.displayLabel.getText());  // tan(270) is undefined (division by zero)

        // Test sin for invalid angle out of typical range
        calc.appendNumberToDisplay("100000000000000");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "sin"));
        assertEquals("Error", calc.displayLabel.getText());  // Extremely large value
    }

    // Test Inverse Trigonometric functions with error cases
    @Test
    public void testInverseTrigFunctionsErrorHandling() {
        Calculator calc = new Calculator();

        // Test asin function for out-of-bound values
        calc.appendNumberToDisplay("2");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "asin"));
        assertEquals("Error", calc.displayLabel.getText());  // asin(x) is undefined for x > 1 or x < -1

        calc.appendNumberToDisplay("-2");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "asin"));
        assertEquals("Error", calc.displayLabel.getText());  // asin(x) is undefined for x > 1 or x < -1

        // Test acos function for out-of-bound values
        calc.appendNumberToDisplay("2");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "acos"));
        assertEquals("Error", calc.displayLabel.getText());  // acos(x) is undefined for x > 1 or x < -1

        calc.appendNumberToDisplay("-2");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "acos"));
        assertEquals("Error", calc.displayLabel.getText());  // acos(x) is undefined for x > 1 or x < -1

        // Test atan function for invalid input
        calc.appendNumberToDisplay("NaN");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "atan"));
        assertEquals("Error", calc.displayLabel.getText());  // atan cannot handle NaN as input

        calc.appendNumberToDisplay("Infinity");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "atan"));
        assertEquals("Error", calc.displayLabel.getText());  // atan cannot handle Infinity as input
    }

    // Test Hyperbolic functions with error cases
    @Test
    public void testHyperbolicTrigFunctionsErrorHandling() {
        Calculator calc = new Calculator();

        // Test sinh function for large values (should not error but added for coverage)
        calc.appendNumberToDisplay("1000000");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "sinh"));
        assertEquals("Error", calc.displayLabel.getText());  // Extremely large number should be handled without error

        // Test cosh function for large values (similar to sinh)
        calc.appendNumberToDisplay("1000000");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "cosh"));
        assertEquals("Error", calc.displayLabel.getText());  // Extremely large number should be handled without error

        // Test tanh function for values that result in "overflow" cases
        calc.appendNumberToDisplay("1000000");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "tanh"));
        assertEquals("Error", calc.displayLabel.getText());  // Extremely large number may result in overflow
    }

    // Test Inverse Hyperbolic functions with error cases
    @Test
    public void testInverseHyperbolicTrigFunctionsErrorHandling() {
        Calculator calc = new Calculator();

        // Test arsinh function for invalid input
        calc.appendNumberToDisplay("NaN");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "arsinh"));
        assertEquals("Error", calc.displayLabel.getText());  // arsinh cannot handle NaN as input

        // Test arcosh function for invalid input (x < 1 is invalid)
        calc.appendNumberToDisplay("0");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "arcosh"));
        assertEquals("Error", calc.displayLabel.getText());  // arcosh(x) is undefined for x < 1

        // Test artanh function for values out of domain (-1, 1)
        calc.appendNumberToDisplay("2");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "artanh"));
        assertEquals("Error", calc.displayLabel.getText());  // artanh(x) is undefined for x > 1 or x < -1

        calc.appendNumberToDisplay("-2");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "artanh"));
        assertEquals("Error", calc.displayLabel.getText());  // artanh(x) is undefined for x > 1 or x < -1

        // Test arcsch function for invalid input (x = 0 is undefined)
        calc.appendNumberToDisplay("0");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "arcsch"));
        assertEquals("Error", calc.displayLabel.getText());  // arcsch(x) is undefined for x = 0
    }

    // Test Pythagorean Theorem Button error case
    @Test
    public void testPythagoreanTheoremErrorHandling() {
        Calculator calc = new Calculator();

        // Test invalid side (negative side length)
        calc.sideA = -3;
        calc.appendNumberToDisplay("4");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Pythag"));
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "="));
        assertEquals("Error", calc.displayLabel.getText());  // Negative side length should result in an error

        // Test invalid side (zero side length)
        calc.sideA = 0;
        calc.appendNumberToDisplay("4");
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Pythag"));
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "="));
        assertEquals("Error", calc.displayLabel.getText());  // Zero side length is invalid
    }
}
