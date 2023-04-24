package plugins;

import org.robodad.battleship.model.Shot;
import org.robodad.battleship.model.Result;

/**
 * This interface allows plugin Strategy classes to be created
 */
public interface Strategy {

    /**
     * @return the name of the strategy
     */
    public String getName();

    /**
     * Shoot at a location on the opponent's board
     * @param lastResult the result of the last shot
     * @return the location to shoot at
     */
    public Shot aim(Result lastResult);
}
