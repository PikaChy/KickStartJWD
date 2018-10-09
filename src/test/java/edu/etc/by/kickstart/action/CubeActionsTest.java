package edu.etc.by.kickstart.action;

import edu.etc.by.kickstart.entity.Cube;
import edu.etc.by.kickstart.entity.Point;
import edu.etc.by.kickstart.entity.Square;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CubeActionsTest {
    private static final CubeActionsImpl actions = new CubeActionsImpl();
    private static final Cube inputCubeSimpleData = new Cube(
            new Square(new Point(2, 4, 0), new Point(4, 4, 0),
                    new Point(4, 2, 0), new Point(2, 2, 0)),
            new Square(new Point(2, 4, 2), new Point(4, 4, 2),
                    new Point(4, 2, 2), new Point(2, 2, 2)));
    private static final Cube inputCubeComplexData = new Cube(
            new Square(new Point(0, 50, 0), new Point(50, 50, 0),
                    new Point(50, 0, 0), new Point(0, 0, 0)),
            new Square(new Point(0, 50, 50), new Point(50, 50, 50),
                    new Point(50, 0, 50), new Point(0, 0, 50)));


    @Test(groups = {"Surface"}, description = "Calculating surface area for cube.")
    public void calcSurfaceAreaSimpleTest() {
        double actual = actions.calcSurfaceArea(inputCubeSimpleData);
        double expected = 24.0;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"Volume"}, description = "Calculating volume of a cube.")
    public void calcVolumeSimpleTest() {
        double actual = actions.calcVolume(inputCubeSimpleData);
        double expected = 8;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"Surface"}, description = "Calculating surface area for cube.")
    public void calcSurfaceAreaComplexTest() {
        double actual = actions.calcSurfaceArea(inputCubeComplexData);
        double expected = 15_000;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"Volume"}, description = "Calculating volume of a cube.")
    public void calcVolumeComplexTest() {
        double actual = actions.calcVolume(inputCubeComplexData);
        double expected = 125_000;
        Assert.assertEquals(actual, expected);
    }
}
