package buildPosition;


import buildWorkOut.PullUp;
import buildWorkOut.Squat;
import buildWorkOut.WorkOut;

/**
 * Created by vicomte on 31/10/2016.
 */

public class Leg implements Position {
    WorkOut work1;
    public Leg() {
        work1 = new Squat(0,0,0);
    }

    public void setPullUp(int weight, int group, int repeat) {
        work1 = new Squat(weight, group, repeat);
    }
}
