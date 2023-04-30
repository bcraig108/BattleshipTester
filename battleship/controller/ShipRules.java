package battleship.controller;

import java.util.ArrayList;
import java.util.List;

import battleship.model.Result;
import battleship.model.Shot;
import battleship.model.Constants.Orientation;
import battleship.model.Constants.ShipType;
import battleship.model.Constants.ShotResult;

/**
 * This class contains the rules for each ship in the fleet
 */
public class ShipRules {

    /** The name of the ship */
    private ShipType type;

    /** This list of hits the can taken */
    private List<Shot> hits;

    /**
     * The constructor, creates an empty list of hits taken
     * @param view - the ship icon and location
     */
    public ShipRules(ShipType type, Shot start, Orientation orientation, int numCells) {
        this.type = type;
        this.hits = new ArrayList<>();
        for (int cell = 0; cell < numCells; cell++) {
            int rowOff = (orientation == Orientation.HORIZONTAL) ? 0 : cell;
            int colOff = (orientation == Orientation.VERTICAL) ? 0 : cell;
            hits.add(new Shot(start.getRow() + rowOff, start.getCol() + colOff));
        }
    }

    /**
     * @return the name of the ship
     */
    public String getName() {
        return type.name();
    }
    
    /**
     * Handle an opponent's shot
     * @param shot the oppenent's shot
     * @return whether the ship was hit, sunk or missed
     */
    public Result handleShot(Shot shot) {
        // if the ship was hit
        if (hits.contains(shot)) {
            hits.remove(shot);

            // check to see if the ship was sunk or just hit
            if (hits.isEmpty()) {
                return new Result(ShotResult.SUNK, type);
            }
            else {
                return new Result(ShotResult.HIT, type);
            }
        }
        else {  // the ship was missed
            return new Result(ShotResult.MISS, ShipType.NONE);
        }
    }
}
