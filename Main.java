import org.robodad.battleship.Constants.ShipType;
import org.robodad.battleship.Constants.ShotResult;
import org.robodad.battleship.model.Result;
import org.robodad.battleship.model.Shot;

import plugins.Strategy;
import plugins.UniqueRandom;

// TODO 1) create a new class in the plugins package, similar to Random or UniqueRandom, and give it a unique name
// TODO 2) import your new class here

public class Main {
    public static void main(String[] args) {
        
        Strategy strategy = new UniqueRandom();  // TODO 3) replace UniqueRandom with your own new class

        System.out.println(strategy.getName());

        for (int index = 0; index < 10; index++) {  // TODO 4) adjust the index limit to test more or fewer cases

            // TODO 5) adjust the ShotResult and ShipType values to change the behavior of the aim function
            Result result = new Result(ShotResult.MISS, ShipType.NONE); 
            Shot shot =  strategy.aim(result);
            System.out.println(shot);
        }
    }
}

// To compile this testing frame work:
// javac Main.java .\org\robodad\battleship\model\*.java .\org\robodad\battleship\Constants.java .\plugins\*.java

// To run:
// java Main
