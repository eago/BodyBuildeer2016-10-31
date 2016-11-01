package buildWorkOut;

/**
 * Created by vicomte on 31/10/2016.
 */

public class PullUp implements WorkOut {
    String name;
    int group;
    int repeat;
    int weight;
    String position;
    public PullUp(int weight, int group, int repeat) {
        this.group = group;
        this.repeat = repeat;
        this.weight = weight;
        this.name = "PullUp";
        this.position = "Shoulder";
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
