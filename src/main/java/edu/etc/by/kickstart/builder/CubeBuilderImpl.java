package edu.etc.by.kickstart.builder;

import edu.etc.by.kickstart.entity.Cube;
import edu.etc.by.kickstart.entity.Point;
import edu.etc.by.kickstart.entity.Square;
import edu.etc.by.kickstart.exception.BuilderException;

public class CubeBuilderImpl implements CubeBuilder {
    private static final int DOUBLES_IN_CUBE_CORNERS = 24;
    private static final int DIMENSIONS = 3;
    private static final int SQUARE_AMOUNT = 2;

    @Override
    public Cube createFromValidData(Double[] allCornersCoordinates) throws BuilderException {
        if (allCornersCoordinates.length != DOUBLES_IN_CUBE_CORNERS) {
            throw new BuilderException("Unable to create cube due to incorrect data!");
        }

        Square[] squaresToBuild = createSquare(createPoints(allCornersCoordinates));
        return new Cube(squaresToBuild[0], squaresToBuild[1]);
    }

    private Point[] createPoints(Double[] coordinates) {
        int pointsAmount = DOUBLES_IN_CUBE_CORNERS / DIMENSIONS;
        Point[] cornersPoints = new Point[pointsAmount];

        for (int i = 0; i < pointsAmount; i++) {
            cornersPoints[i] = new Point(coordinates[i * 3], coordinates[i * 3 + 1], coordinates[i * 3 + 2]);
        }

        return cornersPoints;
    }

    private Square[] createSquare(Point[] cornersPoints) {
        Square[] finalSquares = new Square[SQUARE_AMOUNT];

        for (int i = 0; i < SQUARE_AMOUNT; i++) {
            finalSquares[i] = new Square(cornersPoints[i * 4], cornersPoints[i * 4 + 1],
                    cornersPoints[i * 4 + 2], cornersPoints[i * 4 + 3]);
        }

        return finalSquares;
    }
}
