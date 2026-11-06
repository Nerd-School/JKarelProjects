import edu.fcps.karel2.Display;

public class Lion extends Athlete {
    public static int numLions = 0;

    public Lion(int x, int y) {
        super(x,y, Display.EAST, 0);
        Lion.numLions += 1;
    }

    public static int getNumLions() {
        return numLions;
    }
}
