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

    /**
     * This method will valid the checksum.
     *
     * @param account a string that contain the account number.
     * @return a boolean if the checksum is valid.
     */
    public boolean isValid(String account) {
        IntStream.rangeClosed(1, ACCOUNT_SIZE)
                .forEach(index -> totalSum += (account.charAt(ACCOUNT_SIZE - index) - '0') * index);

        return totalSum % MODULE_ELEVEN == ZERO;
    }
}
