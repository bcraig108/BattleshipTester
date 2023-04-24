package plugins;

import org.robodad.battleship.model.Shot;
import org.robodad.battleship.model.Result;

/**
 * This class implements a completely random strategy of shots.  Duplicate shots are possible.
 */
public class Random implements Strategy {

    /**
     * @return the name of the strategy - "Random"
     */
    @Override
    public String getName() {
        return new String("Random");
    }

    /**
     * Shoot at a location on the opponent's board - completely random
     * @param lastResult the result of the last shot
     * @return the location to shoot at
     */
    @Override
    public Shot aim(Result lastResult) {
        int row = (int)(Math.random() * 10) + 1;
        int col = (int)(Math.random() * 10) + 1;

        return new Shot(row, col);
    }    
}
