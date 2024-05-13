package org.example.ticTacToe;

import java.math.BigInteger;

public class Bitset  {
    private static int ones;
    private static BigInteger b;

    public  Bitset() {
        b = BigInteger.ZERO;
        ones = 0;
    }

    public String toString() {
        return b.toString(2) + " with -> " + ones + "set";
    }


    public static Bitset setBit(int index) {
        b = b.or(BigInteger.ONE.shiftLeft(index));
        ones++;
        return null;
    }

    public static boolean matches(Bitset other) {
        if (ones < other.ones) {
            return false;
        }
        BigInteger and = b.and(other.b);
        return b.equals(and);
    }
}
