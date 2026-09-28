import edu.fcps.karel2.Display;

import javax.swing.*;

public class Olympics {
    public static final String[] choices = {"track1", "track2", "track3"};

    static void main(String[] args) {
        String mapChoice = (String) JOptionPane.showInputDialog(null,"Choose an map.", "Map Choices", JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);

        Display.openWorld("maps/"+ mapChoice +".map");
        Display.setSize(12,12);
        Display.setSpeed(10);

        TrackStar trackStar = new TrackStar("Bode");
        TrackStar trackStar1 = new TrackStar("Bob");
        TrackStar trackStar2 = new TrackStar("Bobby");
        TrackStar trackStar3 = new TrackStar("Robert");

        runAndReport(trackStar, 1);
        runAndReport(trackStar1, 2);
        runAndReport(trackStar2, 4);
        runAndReport(trackStar3, 6);


    }

    public static void report(TrackStar  trackStar) {
        System.out.println(trackStar.getName() + " took " + trackStar.getStepsTaken() + " steps and ran " + trackStar.getLapsRun() + " laps.");
        System.out.println("That is " + trackStar.getMiles() + " miles.");

    }

    public static void runAndReport(TrackStar trackStar, int laps) {
        trackStar.runLaps(laps);
        report(trackStar);
    }
}
