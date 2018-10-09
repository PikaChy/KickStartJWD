package edu.etc.by.kickstart.entity;

import java.io.Serializable;

public class Square implements Serializable {
    private static final long serialVersionUID = -1882846820844881230L;
    private Point leftTopCorner;
    private Point rightTopCorner;
    private Point rightBotCorner;
    private Point leftBotCorner;

    public Square(Point leftTopCorner, Point rightTopCorner, Point rightBotCorner, Point leftBotCorner) {
        this.leftTopCorner = leftTopCorner;
        this.rightTopCorner = rightTopCorner;
        this.rightBotCorner = rightBotCorner;
        this.leftBotCorner = leftBotCorner;
    }


    public Point getLeftTopCorner() {
        return leftTopCorner;
    }

    public Point getRightTopCorner() {
        return rightTopCorner;
    }

    public Point getRightBotCorner() {
        return rightBotCorner;
    }

    public Point getLeftBotCorner() {
        return leftBotCorner;
    }

    @Override
    public String toString() {
        return getClass() + "{ " + getLeftTopCorner() + "," + getRightTopCorner() + "," +
                getRightBotCorner() + "," + getLeftBotCorner() + " }";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Square square = (Square) obj;
        return getLeftTopCorner().equals(square.getLeftTopCorner()) &&
                getRightTopCorner().equals(square.getRightTopCorner()) &&
                getRightBotCorner().equals(square.getRightBotCorner()) &&
                getLeftBotCorner().equals(square.getLeftBotCorner());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 13 * result + getLeftTopCorner().hashCode() + getRightTopCorner().hashCode() +
                getLeftBotCorner().hashCode() + getRightBotCorner().hashCode();
        return result;
    }
}
