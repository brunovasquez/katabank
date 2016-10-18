package org.fundacionjala.katabank;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link DigitRepresentation}
 */
public class DigitRepresentationTest {

    private DigitRepresentation digitRepresentation;

    @Before
    public void setup() {
        digitRepresentation = new DigitRepresentation();
    }

    @Test
    public void testIsValid_false() {
        String invalid =
                " _ " +
                        "|  " +
                        "|_|";

        assertFalse(digitRepresentation.isValid(invalid));
    }

    @Test
    public void testIsValid_true() {
        String valid =
                " _ " +
                        "  |" +
                        "  |";

        assertTrue(digitRepresentation.isValid(valid));
    }

    @Test
    public void testToChar_0() {
        String ZERO =
                " _ " +
                        "| |" +
                        "|_|";
        assertEquals('0', digitRepresentation.toChar(ZERO));
    }

    @Test
    public void testToChar_1() {
        String ONE =
                "   " +
                        "  |" +
                        "  |";
        assertEquals('1', digitRepresentation.toChar(ONE));
    }

    @Test
    public void testToChar_2() {
        String TWO =
                " _ " +
                        " _|" +
                        "|_ ";
        assertEquals('2', digitRepresentation.toChar(TWO));
    }

    @Test
    public void testToChar_3() {
        String THREE =
                " _ " +
                        " _|" +
                        " _|";
        assertEquals('3', digitRepresentation.toChar(THREE));
    }

    @Test
    public void testToChar_4() {
        String FOUR =
                "   " +
                        "|_|" +
                        "  |";
        assertEquals('4', digitRepresentation.toChar(FOUR));
    }

    @Test
    public void testToChar_5() {
        String FIVE =
                " _ " +
                        "|_ " +
                        " _|";
        assertEquals('5', digitRepresentation.toChar(FIVE));
    }

    @Test
    public void testToChar_6() {
        String SIX =
                " _ " +
                        "|_ " +
                        "|_|";
        assertEquals('6', digitRepresentation.toChar(SIX));
    }

    @Test
    public void testToChar_7() {
        String SEVEN =
                " _ " +
                        "  |" +
                        "  |";
        assertEquals('7', digitRepresentation.toChar(SEVEN));
    }

    @Test
    public void testToChar_8() {
        String EIGHT =
                " _ " +
                        "|_|" +
                        "|_|";
        assertEquals('8', digitRepresentation.toChar(EIGHT));
    }

    @Test
    public void testToChar_9() {
        String NINE =
                " _ " +
                        "|_|" +
                        " _|";
        assertEquals('9', digitRepresentation.toChar(NINE));
    }

    @Test
    public void testToChar_Illegible() {
        String illegible =
                " _ " +
                        "|  " +
                        "|_|";
        assertEquals('?', digitRepresentation.toChar(illegible));
    }

}