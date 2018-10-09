package edu.etc.by.kickstart.action;

import edu.etc.by.kickstart.entity.Point;
import edu.etc.by.kickstart.entity.Square;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExecutorTest {
    private static final ExecutorImpl executor = new ExecutorImpl();
    private static final Square inputSimpleSquare1 = new Square(new Point(2, 4, 0),
            new Point(4, 4, 0), new Point(4, 2, 0), new Point(2, 2, 0));
    private static final Square inputSimpleSquare2 = new Square(new Point(2, 4, 2), new Point(4, 4, 2),
            new Point(4, 2, 2), new Point(2, 2, 2));
    private static final Square inputSimpleSquare3 = new Square(new Point(0, 50, 0), new Point(50, 50, 0),
            new Point(50, 0, 0), new Point(0, 0, 0));

    @Test(groups = {"Distance"}, description = "Calculating distance between 2 points")
    public void calcDistanceSimpleTest() {
        double actual = executor.calcDistance(new Point(0, 0, 0), new Point(5, 0, 0));
        double expected = 5;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"Distance"}, description = "Calculating distance between 2 points")
    public void calcDistanceComplexTest() {
        double actual = executor.calcDistance(new Point(-1, -1, -1), new Point(5, 5, 5));
        double expected = Math.sqrt(108);
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"Square"}, description = "Checking if squares have equal sizes")
    public void haveSquaresEqualSizeTest() {
        boolean expected = true;
        boolean actual = executor.haveEqualSize(inputSimpleSquare1, inputSimpleSquare2);
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"Square"}, description = "Checking if squares don't have equal sizes")
    public void haveSquaresNotEqualSizeTest() {
        boolean expected = false;
        boolean actual = executor.haveEqualSize(inputSimpleSquare1, inputSimpleSquare3);
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"Square"}, description = "Checking if squares have equal sizes")
    public void haveAllSquaresNotEqualSizeTest() {
        boolean expected = false;
        boolean actual = executor.haveEqualSize(inputSimpleSquare1, inputSimpleSquare2, inputSimpleSquare3);
        Assert.assertEquals(actual, expected);
    }
}
