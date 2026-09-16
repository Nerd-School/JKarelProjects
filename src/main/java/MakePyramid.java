import edu.fcps.karel2.Display;

public class MakePyramid {
    public static void main(String[] args) {
        // creates the new world and robot
        Display.openDefaultWorld();
        Display.setSize(10,10);

        Athlete billy = new Athlete();

        buildPyramid(3, billy);
    }

    // this method builds a variable sized pyramid
    public static void buildPyramid(int height, Athlete athlete) {
        // the first "i" for loop is for the upward part of the pyramid
        for (int i = 0; i < height; i++) {
            // places the beeper on the first row
            athlete.putBeeper();
            // turns upward for to build vertically
            athlete.turnLeft();
            // moves and places as many as required for the height of the current column
            for (int j = 0; j < i; j++) {
                athlete.move();
                athlete.putBeeper();
            }
            // turns around and goes back down to the ground
            athlete.turnAround();
            for (int j = 0; j < i; j++) {
                athlete.move();
            }
            // reset to east position and moves to the next column
            athlete.turnLeft();
            athlete.move();
        }
        // this second "i" loop runs the downward section of the pyramid
        // the guts are almost the same as the previous "i" loop just "i" will be a different value
        for (int i = height - 1; i > 0; i--) {
            athlete.putBeeper();
            athlete.turnLeft();
            for (int j = 1; j < i; j++) {
                athlete.move();
                athlete.putBeeper();
            }
            athlete.turnAround();
            for (int j = 1; j < i; j++) {
                athlete.move();
            }
            athlete.turnLeft();
            athlete.move();
        }
    }
}
