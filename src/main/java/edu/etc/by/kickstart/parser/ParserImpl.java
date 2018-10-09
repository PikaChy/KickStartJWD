package edu.etc.by.kickstart.parser;

import edu.etc.by.kickstart.exception.ParserException;
import edu.etc.by.kickstart.validator.ValidatorImpl;

import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final String REGEX_SPACE = "(\\s)+";
    private static final int DOUBLES_IN_CUBE_CORNERS = 24;
    private static final ValidatorImpl validator = new ValidatorImpl();

    @Override
    public Double[][] extractCubeBuildingData(List<String> data) throws ParserException {
        if ((data == null) || (data.isEmpty())) {
            throw new ParserException("Incorrect data input!");
        }
        List<Double[]> cornersCoordinates = new ArrayList<>();

        for (int j = 0; j < data.size(); j++) {
            if (validator.isValidStringForCube(data.get(j))) {
                String[] stringCoordinates = data.get(j).split(REGEX_SPACE);
                Double[] doubleCoordinates = new Double[DOUBLES_IN_CUBE_CORNERS];

                for (int i = 0; i < DOUBLES_IN_CUBE_CORNERS; i++) {
                    doubleCoordinates[i] = Double.valueOf(stringCoordinates[i]);
                }
                cornersCoordinates.add(doubleCoordinates);
            }
        }

        if (cornersCoordinates.isEmpty()) {
            throw new ParserException("No correct data!");
        }


        return convertListToDouble(cornersCoordinates);
    }

    private Double[][] convertListToDouble(List<Double[]> cornersCoordinates) {
        Double[][] resultCordinates = new Double[cornersCoordinates.size()][DOUBLES_IN_CUBE_CORNERS];
        for (int i = 0; i < cornersCoordinates.size(); i++) {
            for (int j = 0; j < DOUBLES_IN_CUBE_CORNERS; j++) {
                resultCordinates[i][j] = cornersCoordinates.get(i)[j];
            }
        }
        return resultCordinates;
    }
}