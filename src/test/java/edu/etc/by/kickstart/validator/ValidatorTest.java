package edu.etc.by.kickstart.validator;

import edu.etc.by.kickstart.entity.Cube;
import edu.etc.by.kickstart.entity.Point;
import edu.etc.by.kickstart.entity.Square;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidatorTest {
    private static final ValidatorImpl validator = new ValidatorImpl();
    private static final Cube inputCubeSimpleData = new Cube(
            new Square(new Point(2, 4, 0), new Point(4, 4, 0),
                    new Point(4, 2, 0), new Point(2, 2, 0)),
            new Square(new Point(2, 4, 2), new Point(4, 4, 2),
                    new Point(4, 2, 2), new Point(2, 2, 2)));

    @Test(groups = {"Validator"}, description = "Validator work testing, valid data")
    public void isValidStringForCubeTest() {

        boolean actual = validator.isValidStringForCube("2 4 0 4 4 0 4 2 0 2 2 0    2 4 2 4 4 2 4 2 2 2 2 2");
        boolean expected = true;
        Assert.assertEquals(actual, expected);

    }

    @Test(groups = {"Validator"}, description = "Validator work testing, valid data")
    public void isValidCubeData() {
        List<String> input = new ArrayList<>();
        input.add("2 4 0 4 4 0 4 2 0 2 2 0    2 4 2 4 4 2 4 2 2 2 2 2");
        input.add("2 4 0 4 4 0 4 2 0 2 2 0    2 4 2 4 4 2 4 2 2 2 2 2");
        boolean actual = validator.isValidCubeData(input);
        boolean expected = true;
        Assert.assertEquals(actual, expected);

    }

    @Test(groups = {"Validator"}, description = "Validator work testing, valid data")
    public void isValidCube() {
        boolean actual = validator.isValidCube(inputCubeSimpleData);
        boolean expected = true;
        Assert.assertEquals(actual, expected);

    }

    @Test(groups = {"Validator"}, description = "Validator work testing, valid data")
    public void isValidSquare() {
        boolean actual = validator.isValidSquare(new Square(new Point(2, 4, 0), new Point(4, 4, 0),
                new Point(4, 2, 0), new Point(2, 2, 0)));
        boolean expected = true;
        Assert.assertEquals(actual, expected);

    }
}
