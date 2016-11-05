package buildWorkOut;

import java.io.Serializable;

/**
 * Created by vicomte on 31/10/2016.
 */

public interface WorkOut extends Serializable{
    static String WO_DATA_KRY = "wo_data";
    public int addGroup();
    public int addRepeat();
    public void reset();
    public String getPosition();
    public String getName();
    public int getWeight();
    public int getGroup();
    public int getRepeat();


}
