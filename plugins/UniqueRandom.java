package plugins;

import java.util.LinkedList;
import java.util.List;

import org.robodad.battleship.Constants;
import org.robodad.battleship.model.Shot;
import org.robodad.battleship.model.Result;

/**
 * This class implements a strategy of unique random shots.  Duplicate shots
 * are not possible.
 */
public class UniqueRandom implements Strategy {

    /** List of available shots */
    List<Shot> available;

    /**
     * The constructor, popuates the list of available shots to take
     */
    public UniqueRandom() {
        // create a list of available shots to take
        this.available = new LinkedList<Shot>();
   
        // add each position on the grid to the list
        for (int row = 1; row <= Constants.NUM_ROWS; row++) {
            for (int col = 1; col <= Constants.NUM_COLS; col++) {
                available.add(new Shot(row, col));
            }
        }
    }

    /**
     * @return the name of the strategy - "Unique Random"
     */
    @Override
    public String getName() {
        return new String("Unique Random");
    }

    /**
     * Shoot at a location on the opponent's board - random selection from the
     * available list, removes shot from available list
     * @param lastResult the result of the last shot
     * @return the location to shoot at
     */
    @Override
    public Shot aim(Result lastResult) {
        
        // select a shot to take from the available list
        int index = (int)(Math.random() * available.size());
        Shot shot = available.get(index);

        // remove the shot from the list
        available.remove(index);
        return shot;
    }
    
}
