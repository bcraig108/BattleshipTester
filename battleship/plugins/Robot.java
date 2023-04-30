package battleship.plugins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import battleship.model.Shot;
import battleship.model.Constants;
import battleship.model.Result;

/**
 * This class implements a strategy of unique random shots.  Duplicate shots
 * are not possible.
 */
public class Robot implements Strategy {

    /** List of available shots */
    List<Shot> available;

    Shot lastShot;

    Map<Constants.ShipType,List<Shot>> history;

    /**
     * The constructor, popuates the list of available shots to take
     */
    public Robot() {
        // create a list of available shots to take
        this.available = new LinkedList<Shot>();
   
        // add each position on the grid to the list
        for (int row = 1; row <= Constants.NUM_ROWS; row++) {
            for (int col = 1; col <= Constants.NUM_COLS; col++) {
                available.add(new Shot(row, col));
            }
        }

        this.history = new HashMap<>();

        this.history.put(Constants.ShipType.NONE, new ArrayList<>());
        this.history.put(Constants.ShipType.PATROL_BOAT, new ArrayList<>());
        this.history.put(Constants.ShipType.DESTROYER, new ArrayList<>());
        this.history.put(Constants.ShipType.SUBMARINE, new ArrayList<>());
        this.history.put(Constants.ShipType.BATTLESHIP, new ArrayList<>());
        this.history.put(Constants.ShipType.CARRIER, new ArrayList<>());
    }

    /**
     * @return the name of the strategy - "Unique Random"
     */
    @Override
    public String getName() {
        return new String("Robot");
    }

    /**
     * Shoot at a location on the opponent's board - random selection from the
     * available list, removes shot from available list
     * @param lastResult the result of the last shot
     * @return the location to shoot at
     */
    @Override
    public Shot aim(Result lastResult) {
        
        List<Shot> results = history.get(lastResult.getShip());
        results.add(lastShot);

        // select a shot to take from the available list
        int index = (int)(Math.random() * available.size());
        Shot shot = available.get(index);

        // remove the shot from the list
        available.remove(index);

        lastShot = shot;

        return shot;
    }
    
}
