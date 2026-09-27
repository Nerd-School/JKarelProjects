public class BoxJumper extends Racer {
    BoxJumper(int y) {
        super(y);
    }

    @Override
    public void jumpRight() {
        boolean success = false;
        do {
            if (frontIsClear()) {
                move();
                turnRight();
                while (frontIsClear()) {
                    move();
                    success = true;
                }
                turnLeft();
            } else {
                turnLeft();
                move();
                turnRight();
            }
        } while(!success);
    }
}
