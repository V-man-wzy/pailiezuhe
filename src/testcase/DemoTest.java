package testcase;

import junit.framework.Assert;
import junit.framework.TestCase;
import main.CombineDemo;
import main.PermutateDemo;

public class DemoTest extends TestCase {

    public void testArrange() {
        PermutateDemo tj = new PermutateDemo();
        int[] array = {1,2,3};
        Assert.assertEquals(6,tj.permutate(array,2));
//        Assert.assertEquals(6,tj.allPermutate(array));
//        Assert.assertEquals(6,tj.allPermutateRecur(array));
//        Assert.assertEquals(3,tj.permutate(array,1));

    }

    public void testCombine() {
        CombineDemo tj = new CombineDemo();
        int[] array = {1,2,3};
        Assert.assertEquals(3,tj.combineBinaryInc(array, 2));
        Assert.assertEquals(3,tj.combine(array,2));
//        Assert.assertEquals(8,tj.allCombine(array));
//        Assert.assertEquals(8,tj.allCombineRecur(array));
//        Assert.assertEquals(8,tj.allCombineBinary(array));

//        Assert.assertEquals(3,tj.combineBinaryQuery(array, 2));
//        Assert.assertEquals(3,tj.combine(array,2));
    }
}