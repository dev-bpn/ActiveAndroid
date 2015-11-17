package comstoresearchqmobotech.google.httpsplay.activeandroid.database;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

/**
 * Created by Dell on 11/17/2015.
 */
@Table(name="categories")
public class Category extends Model {

    @Column(name="Name")
    public String name;

    public List<Item> items(){
        return getMany(Item.class , "Category");
    }

}
