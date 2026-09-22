import edu.fcps.karel2.Display;

public class Racer extends Athlete {
    public Racer(int y) {
        super(1, y, Display.EAST, Display.INFINITY);
    }

    public void jumpRight() {
        turnLeft();
        move();
        turnRight();
        move();
        turnRight();
        move();
        turnLeft();
    }

    public void jumpLeft() {
        turnRight();
        move();
        turnLeft();
        move();
        turnLeft();
        move();
        turnRight();
    }

    public void sprint(int dist) {
        for (int i = 0; i < dist; i++) {
            move();
        }
    }

    public void pick(int x) {
        for (int i = 0; i < x; i++) {
            pickBeeper();
        }
    }

    public void put(int x) {
        for (int i = 0; i < x; i++) {
            putBeeper();
        }
    }

    public void shuttle(int dist, int amt) {
        move();
        jumpRight();
        sprint(dist-2);
        pick(amt);
        turnAround();
        sprint(dist-2);
        jumpLeft();
        move();
        put(amt);
        turnAround();
    }
}
