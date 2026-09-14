import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Tester {
    public static void main(String[] args) {
        Display.openWorld("");
        Display.setSize(10,10);

        tester2();
    }


    private static void tester1() {
        Athlete billy = new Athlete();
        billy.move();
        billy.move();
        billy.move();
        billy.turnRight();
    }

    private static void tester2() {
        Athlete billy = new Athlete(3,2,Display.NORTH, 0 );
        billy.move();
        billy.move();
        billy.turnAround();
    }
}
