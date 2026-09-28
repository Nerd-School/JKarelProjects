import edu.fcps.karel2.Display;

import java.util.concurrent.TimeUnit;

public class TeleportDriver {
    static void main(String[] args) throws InterruptedException {
        Display.openWorld("maps/mountain.map");
        Display.setSize(17,17);
        Display.setSpeed(10);

        Teleporter t = new Teleporter();

        TimeUnit.SECONDS.sleep(5);
        t.teleport(16,3);
        t.pickBeeper();
        t.teleport(1,1);
        t.turnLeft();
    }
}
