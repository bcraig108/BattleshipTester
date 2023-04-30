import battleship.controller.FleetRules;
import battleship.controller.ShipRules;
import battleship.model.Result;
import battleship.model.Shot;
import battleship.model.Constants.Orientation;
import battleship.model.Constants.ShipType;
import battleship.model.Constants.ShotResult;
import battleship.plugins.MrCraig;
import battleship.plugins.Strategy;
import battleship.plugins.UniqueRandom;

// TODO 1) create a new class in the plugins package, similar to Random or
//         UniqueRandom, and give it a unique name
// TODO 2) import your new class here

public class Main {
    public static void main(String[] args) {
        
        // SETUP A FLEET TO AIM AT
        FleetRules fleet = new FleetRules();

        // Patrol boat: A1 A2
        fleet.add(new ShipRules(ShipType.PATROL_BOAT, new Shot(1,1), Orientation.HORIZONTAL, 2));

        // Destroyer: B2 C2 D2
        fleet.add(new ShipRules(ShipType.DESTROYER, new Shot(2,2), Orientation.VERTICAL, 3));

        // Submarine: B8 C8 D8
        fleet.add(new ShipRules(ShipType.SUBMARINE, new Shot(2,8), Orientation.VERTICAL, 3));

        // Battleship: F3 F4 F5 F6
        fleet.add(new ShipRules(ShipType.BATTLESHIP, new Shot(6,3), Orientation.HORIZONTAL, 4));

        // Battleship: H5 H6 H7 H8 H9
        fleet.add(new ShipRules(ShipType.CARRIER, new Shot(8,5), Orientation.HORIZONTAL, 5));

        Strategy strategy = new UniqueRandom();  // TODO 3) replace UniqueRandom with your own new class
        System.out.println(strategy.getName());

        Result result = new Result(ShotResult.MISS, ShipType.NONE); 
        int count = 0;
        while (!fleet.isLost()) {
            Shot shot = strategy.aim(result);
            result = fleet.handleShot(shot);
            count++;
        }
        System.out.println("Fleet sunk in " + count + " shots");
    }
}

// To compile this testing frame work:
// javac Main.java .\battleship\model\*.java .\battleship\plugins\*.java .\battleship\controller\*.java

// To run:
// java Main
