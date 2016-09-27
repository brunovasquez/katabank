package org.fundacionjala.katabank;

import java.util.stream.IntStream;

/**
 * Calculates the checksum and validates.
 *
 * @autor Bruno Vasquez.
 */
public class CheckSumValidator {

    private static final int ACCOUNT_SIZE = 9;
    private static final int ZERO = 0;
    private static final int MODULE_ELEVEN = 11;
    private int totalSum = 0;
    private String account;

    /**
     * This method will valid the checksum.
     *
     * @param account a string that contain the account number.
     * @return a boolean if the checksum is valid.
     */
    boolean isValid(String account) {
        this.account = account;
        IntStream.rangeClosed(1, ACCOUNT_SIZE).forEach(this::sum);
        return totalSum % MODULE_ELEVEN == ZERO;
    }

    /**
     * It is the method will get the sum of the digits.
     *
     * @param index a integer that contain the position in the array..
     */
    private void sum(int index) {
        totalSum += charToDigit(ACCOUNT_SIZE - index) * index;
    }

    /**
     * this method will get the digit as integer.
     *
     * @param index a integer that contain the position in the array.
     * @return a digit as integer.
     */
    private int charToDigit(int index) {
        return account.charAt(index) - '0';
    }
}
