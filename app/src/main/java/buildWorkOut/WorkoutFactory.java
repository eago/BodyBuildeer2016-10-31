package buildWorkOut;

/**
 * Created by vicomte on 05/11/2016.
 */

public class WorkoutFactory {
    public WorkOut getWorkout(String position, String workout, int weight, int group, int repeat) {
        switch (workout) {
            case "PullUp" :
                return new PullUp(weight, group, repeat);
            case "Squat" :
                return new Squat(weight, group, repeat);
            default:
                return null;
        }
    }
}
