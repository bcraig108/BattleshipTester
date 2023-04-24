package org.robodad.battleship.model;

import org.robodad.battleship.Constants.*;

public class Result {
    
    final ShotResult result;
    final ShipType ship;

    public Result(ShotResult result, ShipType ship) {
        this.result = result;
        this.ship = ship;
    }

    public ShotResult getResult() {
        return this.result;
    }

    public ShipType getShip() {
        return this.ship;
    }
}
