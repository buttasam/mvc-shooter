package cz.fit.dpo.mvcshooter.model.helper;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Samuel Butta
 */
public class ProbabilityTest {

    @Test
    public void plusMinusOneOrZero() throws Exception {
        int generatedSize = 100;
        int zeroCount = 0, oneCount = 0, minusOneCount = 0;
        for (int i = 0; i < generatedSize; i++) {
            int expected = Probability.plusMinusOneOrZero();
            switch (expected) {
                case 0:
                    zeroCount++;
                    break;
                case 1:
                    oneCount++;
                    break;
                case -1:
                    minusOneCount++;
                    break;
            }
        }

        Assert.assertFalse(zeroCount == 0);
        Assert.assertFalse(oneCount == 0);
        Assert.assertFalse(minusOneCount == 0);

        Assert.assertEquals(generatedSize, zeroCount + oneCount + minusOneCount);
    }

}