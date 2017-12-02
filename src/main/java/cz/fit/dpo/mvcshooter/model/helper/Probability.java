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

    public static boolean oneThird() {
        Random r = new Random();
        return ((r.nextInt(3) + 1) % 3) == 0;
    }

}
