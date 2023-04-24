package org.robodad.battleship;

public class Constants {

    public static double SIZE = 50;
    public static int NUM_COLS = 10;
    public static int NUM_ROWS = 10;

    public enum ShipType {
        NONE,
        PATROL_BOAT,
        DESTROYER,
        SUBMARINE,
        BATTLESHIP,
        CARRIER
    }

    public enum ShotResult {
        MISS,
        HIT,
        SUNK
    }
}
