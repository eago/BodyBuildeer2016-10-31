package buildWorkOut;

/**
 * Created by vicomte on 31/10/2016.
 */

public class Squat implements WorkOut {
    String name;
    String position;
    int group;
    int repeat;
    int weight;
    public Squat(int weight, int group, int repeat) {
        this.group = group;
        this.repeat = repeat;
        this.weight = weight;
        this.name = "Squat";
        this.position = "Leg";
    }
    @Override
    public int addGroup() {
        return 0;
    }

    @Override
    public int addRepeat() {
        return 0;
    }

    @Override
    public void reset() {

    }

    @Override
    public String getPosition() {
        return this.position;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public int getGroup() {
        return this.group;
    }

    @Override
    public int getRepeat() {
        return this.repeat;
    }
}
