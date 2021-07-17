package algorithm;

import java.math.BigInteger;

public class 大数相加 {

    public static String AddLongInteger(String addend, String augend) {
        BigInteger b1 = new BigInteger(addend);
        BigInteger b2 = new BigInteger(augend);
        return b1.add(b2).toString();
    }

}
