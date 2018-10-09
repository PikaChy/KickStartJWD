package edu.etc.by.kickstart.parser;

import edu.etc.by.kickstart.exception.ParserException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserTest {
    private static final ParserImpl parser = new ParserImpl();

    @Test(groups = {"Parser"}, description = "Parsing process test, null pointer input data")
    public void parseNullDataTest() {
        boolean expected = false;
        boolean actual = true;
        try {
            parser.extractCubeBuildingData(null);
        } catch (ParserException e) {
            actual = false;
        }
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"Parser"}, description = "Parsing process test, empty list as input data")
    public void parseEmptyDataTest() {
        boolean expected = false;
        boolean actual = true;
        try {
            List<String> empyList = new ArrayList<>();
            parser.extractCubeBuildingData(empyList);
        } catch (ParserException e) {
            actual = false;
        }
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"Parser"}, description = "Parsing process test, valid data for input")
    public void parseValidDataTest() {
        boolean expected = true;
        boolean actual = false;
        try {
            List<String> data = new ArrayList<>();
            Double[] expectedCoordinates = {2.0, 4.0, 0.0, 4.0, 4.0, 0.0, 4.0, 2.0, 0.0, 2.0, 2.0, 0.0,
                    2.0, 4.0, 2.0, 4.0, 4.0, 2.0, 4.0, 2.0, 2.0, 2.0, 2.0, 2.0};
            Double[][] expectedData = new Double[1][1];
            expectedData[0] = expectedCoordinates;
            data.add("1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0 10.0 11.0 12.0 14.0 15.0 " +
                    "16.0 17.0 18.0 19.0 20.0 21.0 22.0 23.0 24.0 ");
            data.add("4234klfmgkdfkg;jfs aska; jfks;d j4923 b04923 4/23 42 /43/2 /423. 4.23 4.");
            data.add("2 4 0 4 4 0 4 2 0 2 2 0    2 4 2 4 4 2 4 2 2 2 2 2");
            Double[][] actualData = parser.extractCubeBuildingData(data);

            if (Arrays.equals(actualData[0], expectedData[0])) {
                actual = true;
            }
        } catch (ParserException e) {
            actual = false;
        }
        Assert.assertEquals(actual, expected);
    }
}
