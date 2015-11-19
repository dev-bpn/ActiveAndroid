package comstoresearchqmobotech.google.httpsplay.activeandroid.model;

import java.util.ArrayList;

/**
 * Created by Dell on 11/19/2015.
 */
public class Group {

    private Integer groupImageRing;
    private String groupNum;
    private String groupTitle;
    private String groupDescription;

    private ArrayList<Child> item;

    public Integer getGroupImageRing() {
        return groupImageRing;
    }

    public void setGroupImageRing(Integer groupImageRing) {
        this.groupImageRing = groupImageRing;
    }

    public String getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(String groupNum) {
        this.groupNum = groupNum;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public ArrayList<Child> getItem() {
        return item;
    }

    public void setItem(ArrayList<Child> item) {
        this.item = item;
    }
}
