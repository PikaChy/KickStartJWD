package edu.etc.by.kickstart.entity;

import java.io.Serializable;

public class Point implements Serializable {

    private static final long serialVersionUID = 4917288441933211518L;
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return getClass().getName() + "( X: " + this.x + ", Y: " + this.y + ", Z: " + this.z + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Point point = (Point) obj;
        return getX() == point.getX() &&
                getY() == point.getY() && getZ() == point.getZ();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result *= (int) Double.doubleToLongBits(37 * getX() + 31 * getY() + 29 * getZ());
        return result;
    }
}
