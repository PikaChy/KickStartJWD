package edu.etc.by.kickstart.entity;

import java.io.Serializable;

public class Cube implements Serializable {

    private static final long serialVersionUID = -6926975603483437931L;
    private Square topSquare;
    private Square botSquare;

    public Cube(Square topSquare, Square botSquare) {
        //TODO:Should we catch NPE?
        this.topSquare = topSquare;
        this.botSquare = botSquare;
    }

    public Square getTopSquare() {
        return topSquare;
    }

    public Square getBotSquare() {
        return botSquare;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Cube cube = (Cube) obj;
        return this.topSquare.equals(cube.topSquare) && this.botSquare.equals(cube.botSquare);
    }

    @Override
    public int hashCode() {
        int result = 11;
        result = 53 * result + this.topSquare.hashCode() + this.botSquare.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                this.topSquare + "," + this.botSquare +
                '}';
    }
}
