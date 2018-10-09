package edu.etc.by.kickstart.action;

import edu.etc.by.kickstart.entity.Point;
import edu.etc.by.kickstart.entity.Square;

public interface Executor {
    double calcDistance(Point begin, Point end);

    boolean haveEqualSize(Square firstValidSquare, Square secondValidSquare);

    boolean haveEqualSize(Square firstValidSquare, Square secondValidSquare, Square thirdValidSquare);
}
