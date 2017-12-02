package cz.fit.dpo.mvcshooter.model.helper;

import java.util.Random;

/**
 * @author Samuel Butta
 */
public class Probability {

    public static boolean oneHalf() {
        Random r = new Random();
        return (r.nextInt(2) % 2) == 0;
    }

}
