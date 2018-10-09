package edu.etc.by.kickstart.action;

import edu.etc.by.kickstart.entity.Cube;

public interface CubeActions {
    double calcSurfaceArea(Cube validCube);

    double calcVolume(Cube validCube);

    boolean isBasedOnCoordinatePlane(Cube cube);
}
