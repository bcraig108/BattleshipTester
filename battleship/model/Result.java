package battleship.model;

import battleship.model.Constants.ShipType;
import battleship.model.Constants.ShotResult;

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

    public String toString() {
        return new String(this.ship.name() + ": " + this.result.name());
    }
}
