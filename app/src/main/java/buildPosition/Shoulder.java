package buildPosition;

import buildWorkOut.PullUp;
import buildWorkOut.WorkOut;

/**
 * Created by vicomte on 31/10/2016.
 */

public class Shoulder implements Position {
    WorkOut work1;
    public Shoulder() {
        work1 = new PullUp(0,0,0);
    }

    public void setPullUp(int weight, int group, int repeat) {
        work1 = new PullUp(weight, group, repeat);
    }
}
