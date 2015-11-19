package comstoresearchqmobotech.google.httpsplay.activeandroid.model;

import java.util.ArrayList;

/**
 * Created by Dell on 11/19/2015.
 */
public class Group {

    private int groupImage;
    private String groupNum;
    private String groupTitle;
    private String groupTitleDescription;
    private ArrayList<Child> childItems;

    public ArrayList<Child> getChildItems() {
        return childItems;
    }

    public void setChildItems(ArrayList<Child> childItems) {
        this.childItems = childItems;
    }

    public int getGroupImage() {
        return groupImage;
    }

    public void setGroupImage(int groupImage) {
        this.groupImage = groupImage;
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

    public String getGroupTitleDescription() {
        return groupTitleDescription;
    }

    public void setGroupTitleDescription(String groupTitleDescription) {
        this.groupTitleDescription = groupTitleDescription;
    }
}
