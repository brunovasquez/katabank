package org.fundacionjala.katabank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.fundacionjala.katabank.DigitRepresentation.ILLEGIBLE;

/**
 * Representation of a account number of digits.
 *
 * @autor Bruno Vasquez.
 */
public class AccountNumber {
    private static final String ILL = " ILL";
    private static final String ERR = " ERR";
    private static final String VOID = "";
    private String line0;
    private String line1;
    private String line2;

    private boolean illegible;
    private boolean failedCheckSum;
    private static final int DIGIT_WIDTH = 3;
    private static final int ACCOUNT_WIDTH = 9;
    private DigitRepresentation digitRepresentation;

    private final String ILLEGIBLE = "?";

    /**
     * It is the constructor that will get and will validate a account number .
     *
     * @param line0 The top line of the account number.
     * @param line1 The middle line of the account number.
     * @param line2 The bottom line of the account number.
     */
    public AccountNumber(String line0, String line1, String line2) {
        this.line0 = line0;
        this.line1 = line1;
        this.line2 = line2;
        digitRepresentation = new DigitRepresentation();
        validate();
    }

    /**
     * This method checks each digit in the Account Number is a valid digit.
     * and checks the full Account Number against the CheckSumValidator.
     */
    private void validate() {
        validateLegibility();
        if (!illegible) {
            performCheckSum();
        }
    }

    /**
     * This method will append ILL if any digit is illegible.
     */
    private void validateLegibility() {
        Map<String, Character> mapDigit = digitRepresentation.getDigitHash();

        IntStream.range(0, ACCOUNT_WIDTH)
                .forEach(index -> illegible = !mapDigit.containsKey(getDigitAtIndex(index)) && !illegible);
    }

    /**
     * This method performs the CheckSumValidator on the account number.
     */
    private void performCheckSum() {
        failedCheckSum = !new CheckSumValidator().isValid(toDigitString());
    }

    /**
     * It is the method will get the digit string according the lines.
     *
     * @param index a integer with the position of the digit in the account.
     * @return a object that contain the account number as a String.
     */
    public String getDigitAtIndex(int index) {
        String line00 = this.line0.substring(index * DIGIT_WIDTH, index * DIGIT_WIDTH + DIGIT_WIDTH);
        String line01 = this.line1.substring(index * DIGIT_WIDTH, index * DIGIT_WIDTH + DIGIT_WIDTH);
        String line02 = this.line2.substring(index * DIGIT_WIDTH, index * DIGIT_WIDTH + DIGIT_WIDTH);
        return line00.concat(line01).concat(line02);
    }

    /**
     * It is the method will get the digit string.
     *
     * @return a string that contain the account number as a String.
     */
    public String toDigitString() {
        Map<String, Character> mapDigit = digitRepresentation.getDigitHash();
        final StringBuilder builder = new StringBuilder();

        IntStream.range(0, ACCOUNT_WIDTH)
                .forEach(index -> builder.append(mapDigit.containsKey(getDigitAtIndex(index)) ?
                        mapDigit.get(getDigitAtIndex(index)) : ILLEGIBLE));

        return builder.toString();
    }

    /**
     * It is the method will build the account number.
     *
     * @return a string that contain the account number as a String with ILL/ERR.
     */
    @Override
    public String toString() {
        String string = toDigitString();
        string += illegible ? ILL : failedCheckSum ? ERR : VOID;
        return string;
    }

}
