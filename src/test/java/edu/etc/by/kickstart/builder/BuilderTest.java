package edu.etc.by.kickstart.builder;

import edu.etc.by.kickstart.entity.Cube;
import edu.etc.by.kickstart.entity.Point;
import edu.etc.by.kickstart.entity.Square;
import edu.etc.by.kickstart.exception.BuilderException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuilderTest {
    private final static CubeBuilderImpl builder = new CubeBuilderImpl();
    private static final Cube inputCubeSimpleData = new Cube(
            new Square(new Point(2, 4, 0), new Point(4, 4, 0),
                    new Point(4, 2, 0), new Point(2, 2, 0)),
            new Square(new Point(2, 4, 2), new Point(4, 4, 2),
                    new Point(4, 2, 2), new Point(2, 2, 2)));

    @Test(groups = {"Builder"}, description = "Builder work testing, exception case")
    public void createCubeFromNonValidDataTest() {
        Double[] inputCoordinates = {2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0,
                16.0, 17.0, 18.0, 19.0, 20.0, 21.0, 22.0, 23.0, 24.0};
        boolean actual = true;
        boolean expected = false;
        try {
            Cube cube = builder.createFromValidData(inputCoordinates);
        } catch (BuilderException e) {
            actual = false;
        } finally {
            Assert.assertEquals(actual, expected);
        }
    }

    @Test(groups = {"Builder"}, description = "Builder work testing, exception case")
    public void createCubeFromValidDataTest() {
        Double[] inputCoordinates = {2.0, 4.0, 0.0, 4.0, 4.0, 0.0, 4.0, 2.0, 0.0, 2.0, 2.0, 0.0,
                2.0, 4.0, 2.0, 4.0, 4.0, 2.0, 4.0, 2.0, 2.0, 2.0, 2.0, 2.0};
        boolean actual = false;
        boolean expected = true;
        try {
            Cube cube = builder.createFromValidData(inputCoordinates);
            if (cube.equals(inputCubeSimpleData)) {
                actual = true;
            }
        } catch (BuilderException e) {
            actual = false;
        } finally {
            Assert.assertEquals(actual, expected);
        }
    }
}
