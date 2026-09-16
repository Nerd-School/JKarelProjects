import edu.fcps.karel2.Display;

public class ClimbEveryMountain {
    static void main(String[] args) {
        Display.openWorld("maps/mountain.map");
        Display.setSize(17,17);
        Display.setSpeed(10);


        for  (int i = 0; i < 3; i++) {
            Climber bob = new Climber(8);
            getTreasure(bob);
        }
    }

    public static void getTreasure(Climber bob) {
        // makes base camp
        bob.putBeeper();

        // turns toward the direction needed to climb
        bob.turnRight();
        bob.move();

        // goes up the right side of the mountain
        for (int i = 0; i < 4; i++) {
            bob.climbUpRight();
        }

        // goes down the right side to the loot
        for (int i = 0; i < 3; i++) {
            bob.climbDownRight();
        }

        // picks up the loot
        for (int i = 0; i < 5; i++) {
            bob.pickBeeper();
        }

        bob.turnAround();

        // climbs back up
        for  (int i = 0; i < 3; i++) {
            bob.climbUpLeft();
        }

        // climbs back down the other side
        for (int i = 0; i < 4; i++) {
            bob.climbDownLeft();
        }

        // returns to base camp
        bob.move();
        for (int i = 0; i < 5; i++) {
            bob.putBeeper();
        }
    }
}
