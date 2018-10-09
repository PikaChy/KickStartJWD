package edu.etc.by.kickstart.validator;

import edu.etc.by.kickstart.entity.Cube;
import edu.etc.by.kickstart.entity.Square;

import java.util.List;

public interface Validator {
    boolean isValidStringForCube(String data);

    boolean isValidCubeData(List<String> data);

    boolean isValidCube(Cube cube);

    boolean isValidSquare(Square square);
}
