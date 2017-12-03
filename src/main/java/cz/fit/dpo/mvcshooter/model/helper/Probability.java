package cz.fit.dpo.mvcshooter.model.helper;

import java.util.Random;

/**
 * @author Samuel Butta
 */
public class Probability {

    public static boolean oneHalf() {
        Random r = new Random();
        return ((r.nextInt(2) + 1) % 2) == 0;
    }

    public static boolean oneTwoHundred() {
        Random r = new Random();
        return ((r.nextInt(200) + 1) % 200) == 0;
    }

    public static int plusMinusOneOrZero() {
        Random r = new Random();
        return (r.nextInt(3) - 1);
    }

}
