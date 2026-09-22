import edu.fcps.karel2.Display;

public class ShuttleRun {
    public static void main(String[] args) {
        Display.openWorld("maps/shuttlerun.map");
        Display.setSize(13, 10);
        Display.setSpeed(10);

        Racer shuttle1 = new Racer(7);
        Racer shuttle2 = new Racer(4);
        Racer shuttle3 = new Racer(1);

        runTheRace(shuttle3);
        runTheRace(shuttle2);
        runTheRace(shuttle1);
    }

    public static void runTheRace(Racer racer) {
        racer.shuttle(5,5);
        racer.shuttle(7,2);
        racer.shuttle(8,3);
        racer.shuttle(11,7);
        racer.move();
    }
}
