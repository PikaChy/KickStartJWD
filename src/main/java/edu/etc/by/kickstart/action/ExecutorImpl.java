package edu.etc.by.kickstart.action;

import edu.etc.by.kickstart.entity.Point;
import edu.etc.by.kickstart.entity.Square;

public class ExecutorImpl implements Executor {
    @Override
    public double calcDistance(Point validBeginPoint, Point validEndPoint) {
        double squareDifferenceXCoordinates = Math.pow((validBeginPoint.getX() - validEndPoint.getX()), 2);
        double squareDifferenceYCoordinates = Math.pow((validBeginPoint.getY() - validEndPoint.getY()), 2);
        double squareDifferenceZCoordinates = Math.pow((validBeginPoint.getZ() - validEndPoint.getZ()), 2);

        return Math.sqrt(squareDifferenceXCoordinates + squareDifferenceYCoordinates
                + squareDifferenceZCoordinates);
    }

    public boolean haveEqualSize(Square firstValidSquare, Square secondValidSquare) {
        boolean isValid = calcDistance(firstValidSquare.getRightBotCorner(), firstValidSquare.getRightTopCorner()) ==
                calcDistance(secondValidSquare.getRightBotCorner(), secondValidSquare.getRightTopCorner());
        return isValid;
    }

    @Override
    public boolean haveEqualSize(Square firstValidSquare, Square secondValidSquare, Square thirdValidSquare) {
        boolean isValid = haveEqualSize(firstValidSquare, secondValidSquare) &&
                haveEqualSize(secondValidSquare, thirdValidSquare);
        return isValid;
    }
}
