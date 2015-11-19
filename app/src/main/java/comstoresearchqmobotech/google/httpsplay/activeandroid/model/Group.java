package comstoresearchqmobotech.google.httpsplay.activeandroid.model;

import java.util.ArrayList;

/**
 * Created by Dell on 11/19/2015.
 */
public class Group {

    private String name;
    private ArrayList<Child> item;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Child> getItem() {
        return item;
    }

    public void setItem(ArrayList<Child> item) {
        this.item = item;
    }
}
