package comstoresearchqmobotech.google.httpsplay.activeandroid.database;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Dell on 11/17/2015.
 */
@Table(name="Items")
public class DataItems extends Model {

    @Column(name="Title" , index = true)
    private String title;

    @Column(name="Description"  , index = true)
    private String description;

    @Column(name="ImageLink" , index = true)
    private String image;

    @Column(name="PageLink" , index = true)
    private String titleLink;

    public DataItems(){
        super();
    }

    public DataItems(String title, String description, String image , String titleLink) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.titleLink = titleLink;
    }

}
