package org.robodad.battleship.model;

import java.util.Objects;

/**
 * This class allow a {@link org.robodad.battleship.model.Player} to take shots
 * at the opponent player
 */
public class Shot {
   
    /* The row number to shoot at (1-10) */
    private int row;

    /* The column number to shoot at (1-10) */
    private int col;

    /**
     * The constructor requires a row and column to shoot at
     * 
     * @param row the row number to shoot at (1-10)
     * @param col the column number to shoot at (1-10)
     */
    public Shot(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * @return the row number to shoot at (1-10)
     */
    public int getRow() {
        return row;
    }

    /**
     * @return the column number to shoot at (1-10)
     */
    public int getCol() {
        return col;
    }

    /**
     * The string describing the shot - in battleship terms (letter/number)
     */
    public String toString() {
        return String.valueOf((char)(row + 64)) + Integer.toString(col);
    }

    /**
     * The equals method compares the contents of the object
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Shot)) {
            return false;
        }
        Shot shot = (Shot) o;
        return row == shot.row && col == shot.col;
    }

    /**
     * The hashCode method can be used for comparisons
     */
    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
