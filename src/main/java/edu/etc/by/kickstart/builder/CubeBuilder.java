package edu.etc.by.kickstart.builder;

import edu.etc.by.kickstart.entity.Cube;
import edu.etc.by.kickstart.exception.BuilderException;

public interface CubeBuilder {
    Cube createFromValidData(Double[] allCornersCoordinates) throws BuilderException;
}
