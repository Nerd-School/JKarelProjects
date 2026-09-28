import edu.fcps.karel2.Display;

public class TrackStar extends Athlete{
    private String name;
    private int lapsRun;
    private int stepsTaken;

    public TrackStar(String name) {
        this.name = name;
        this.lapsRun = 0;
        this.stepsTaken = 0;
        super(1,1, Display.EAST, 0);
    }

    public String getName() {
        return name;
    }

    public int getLapsRun() {
        return lapsRun;
    }

    public int getStepsTaken() {
        return stepsTaken;
    }

    public double getMiles() {
        return((double) stepsTaken /20);
    }

    public void resetCount(){
        this.stepsTaken = 0;
        this.lapsRun = 0;
    }

    public void setName(String name){
        this.name = name;
    }

    public void runLaps(int laps){
        for(int j = 0; j < laps; j++){
            for (int k = 0; k < 4; k++){
                while(frontIsClear()) {
                    move();
                    stepsTaken++;
                }
                turnLeft();
            }
            lapsRun++;
        }
    }
}

