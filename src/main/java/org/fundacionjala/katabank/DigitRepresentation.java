package org.fundacionjala.katabank;

import java.util.HashMap;
import java.util.Map;

/**
 * Representation of a graph to digit.
 *
 * @autor Bruno Vasquez.
 */
public class DigitRepresentation {
    private static final String ZERO = " _ " +
            "| |" +
            "|_|";
    private static final String ONE = "   " +
            "  |" +
            "  |";
    private static final String TWO = " _ " +
            " _|" +
            "|_ ";
    private static final String THREE = " _ " +
            " _|" +
            " _|";
    private static final String FOR = "   " +
            "|_|" +
            "  |";
    private static final String FIVE = " _ " +
            "|_ " +
            " _|";
    private static final String SIX = " _ " +
            "|_ " +
            "|_|";
    private static final String SEVEN = " _ " +
            "  |" +
            "  |";
    private static final String EIGHT = " _ " +
            "|_|" +
            "|_|";
    private static final String NINE = " _ " +
            "|_|" +
            " _|";
    private static final char ILLEGIBLE = '?';


    private Map<String, Character> digitHash = new HashMap<>();

    /**
     * It is the constructor of digit representation.
     */
    public DigitRepresentation() {

        digitHash.put(ZERO, '0');
        digitHash.put(ONE, '1');
        digitHash.put(TWO, '2');
        digitHash.put(THREE, '3');
        digitHash.put(FOR, '4');
        digitHash.put(FIVE, '5');
        digitHash.put(SIX, '6');
        digitHash.put(SEVEN, '7');
        digitHash.put(EIGHT, '8');
        digitHash.put(NINE, '9');
    }

    /**
     * It is the method bring back to digit according a graph.
     *
     * @return a char that represent a digit.
     */
    public char toChar(String graph) {
        return isValid(graph) ? digitHash.get(graph) : ILLEGIBLE;
    }


    /**
     * It is the method bring back a boolean according the graph.
     *
     * @return a boolean that if the graph is in the hash.
     */
    public boolean isValid(String graph) {
        return digitHash.containsKey(graph);
    }


    /**
     * It is the method that gets a map with digit representation.
     *
     * @return a map.
     */
    public Map<String, Character> getDigitHash() {
        return digitHash;
    }
}
