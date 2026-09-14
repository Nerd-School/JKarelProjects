import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Athlete extends Robot {
    private int x;
    private int y;
    private int direction;
    private int beepers;

    public Athlete(){
        super(1,1,Display.EAST,Display.INFINITY);
    }

    public Athlete(int x, int y, int direction, int beepers){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.beepers = beepers;
        super(x,y,direction,beepers);
    }

    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    public void turnAround() {
        turnLeft();
        turnLeft();
    }
}
