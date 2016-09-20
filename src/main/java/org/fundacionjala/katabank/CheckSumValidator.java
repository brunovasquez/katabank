package org.fundacionjala.katabank;

/**
 * Calculates the checksum and validates.
 *
 * @autor Bruno Vasquez.
 */
public class CheckSumValidator {

    private static final int ACCOUNT_SIZE = 9;
    private static final int ZERO = 0;
    private static final int MODULE_ELEVEN = 11;
    private static final int RADIX = 10;

    /**
     * This method will valid the checksum.
     *
     * @param account a string that contain the account number.
     * @return a boolean if the checksum is valid.
     */
    public static boolean isValid(String account) {
        return (checksum(account) % MODULE_ELEVEN) == ZERO;
    }

    /**
     * It is the method will get the sum of the digits.
     *
     * @param account a string that contain the account number.
     * @return a digit as integer.
     */
    private static int checksum(String account) {
        char[] accountChars = account.toCharArray();
        int sum = ZERO;
        for (int index = 1; index <= ACCOUNT_SIZE; index++) {
            sum += charToDigit(index, accountChars) * index;
        }
        return sum;
    }

    /**
     * this method will get the digit as integer.
     *
     * @param index        a integer that contain the position in the array.
     * @param accountChars a array that contain the account number.
     * @return a digit as integer.
     */
    private static int charToDigit(int index, char[] accountChars) {
        return Character.digit(accountChars[ACCOUNT_SIZE - index], RADIX);
    }
}
