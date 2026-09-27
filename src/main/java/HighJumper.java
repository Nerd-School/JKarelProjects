public class HighJumper extends Racer {
    HighJumper(int y) {
        super(y);
    }

    @Override
    public void jumpRight() {
        boolean jumped = false;
        do {
            if (frontIsClear()) {
                move();
                jumped = true;
            } else {
                turnLeft();
                move();
                turnRight();
            }
        } while (!jumped);
        jumped = false;
        turnRight();
        do {
            if (frontIsClear()) {
                move();
            } else {
                turnLeft();
                jumped = true;
            }
        } while (!jumped);
    }
}
