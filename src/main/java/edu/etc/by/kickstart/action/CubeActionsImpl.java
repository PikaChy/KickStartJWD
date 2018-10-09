package edu.etc.by.kickstart.action;

import edu.etc.by.kickstart.entity.Cube;
import edu.etc.by.kickstart.entity.Square;

public class CubeActionsImpl implements CubeActions {
    private static final int CHECKED_EDGES = 2;
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
        Square[] cubeEdges = new Square[CHECKED_EDGES];
        cubeEdges[0] = cube.getBotSquare();
        cubeEdges[1] = cube.getTopSquare();

        for (int i = 0; i < CHECKED_EDGES; i++) {
            Square checkingSquare = cubeEdges[i];
            if (isBasedOnCoordinatePlane(checkingSquare)) {
                isBased = true;
            }

        }
        return isBased;
    }

    private boolean isBasedOnCoordinatePlane(Square square) {
        boolean isBased = false;

        if ((((square.getLeftBotCorner().getX() == 0) && (square.getLeftTopCorner().getX() == 0)) &&
                (square.getRightBotCorner().getX() == 0)) && (square.getRightTopCorner().getX() == 0)) {
            isBased = true;
        } else if ((((square.getLeftBotCorner().getY() == 0) && (square.getLeftTopCorner().getY() == 0)) &&
                (square.getRightBotCorner().getY() == 0)) && (square.getRightTopCorner().getY() == 0)) {
            isBased = true;
        } else if ((((square.getLeftBotCorner().getZ() == 0) && (square.getLeftTopCorner().getZ() == 0)) &&
                (square.getRightBotCorner().getZ() == 0)) && (square.getRightTopCorner().getZ() == 0)) {
            isBased = true;
        }

        return isBased;
    }
}
