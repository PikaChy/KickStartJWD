package edu.etc.by.kickstart.action;

import edu.etc.by.kickstart.entity.Cube;
import edu.etc.by.kickstart.entity.Point;
import edu.etc.by.kickstart.entity.Square;

public class CubeActionsImpl implements CubeActions {
    private static final ExecutorImpl executor = new ExecutorImpl();

    @Override
    public double calcSurfaceArea(Cube validCube) {
        Square validSquare = validCube.getBotSquare();
        double edgeLength = executor.calcDistance(validSquare.getRightBotCorner(), validSquare.getRightTopCorner());
        return 6 * Math.pow(edgeLength, 2);
    }

    @Override
    public double calcVolume(Cube validCube) {
        Square validSquare = validCube.getBotSquare();
        double edgeLength = executor.calcDistance(validSquare.getRightBotCorner(), validSquare.getRightTopCorner());
        return Math.pow(edgeLength, 3);
    }

    @Override
    public boolean isBasedOnCoordinatePlane(Cube cube) {
        boolean isBased = false;

        Square botSquare = cube.getBotSquare();
        Square topSquare = cube.getTopSquare();
        if ((isBasedOnCoordinatePlane(botSquare) ||
                (isBasedOnCoordinatePlane(topSquare)))) {
            isBased = true;
        }
        return isBased;
    }

    private boolean isBasedOnCoordinatePlane(Square square) {
        boolean isBased = false;
        Point leftBotCorner = square.getLeftBotCorner();
        Point leftTopCorner = square.getLeftTopCorner();

        if ((((leftBotCorner.getX() == 0) && (leftTopCorner.getX() == 0)) &&
                (leftBotCorner.getX() == 0)) && (leftTopCorner.getX() == 0)) {
            isBased = true;
        } else if ((((leftBotCorner.getY() == 0) && (leftTopCorner.getY() == 0)) &&
                (leftBotCorner.getY() == 0)) && (leftTopCorner.getY() == 0)) {
            isBased = true;
        } else if ((((leftBotCorner.getZ() == 0) && (leftTopCorner.getZ() == 0)) &&
                (leftBotCorner.getZ() == 0)) && (leftTopCorner.getZ() == 0)) {
            isBased = true;
        }

        return isBased;
    }
}
