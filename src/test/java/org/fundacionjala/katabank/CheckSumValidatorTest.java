package org.fundacionjala.katabank;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link CheckSumValidatorTest}
 */
public class CheckSumValidatorTest {

    @Test
    public void testCheckSumIsValid() {
        final String account = "345882865";
        assertTrue(CheckSumValidator.isValid(account));
    }

    @Test
    public void testCheckSumIsNotValid() {
        final String account = "123456389";
        assertFalse(CheckSumValidator.isValid(account));
    }


}
