package comstoresearchqmobotech.google.httpsplay.activeandroid.database;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Dell on 11/17/2015.
 */
@Table(name="Items")
public class Item extends Model {

    @Column(name="Name" , index = true)
    public String name;

    @Column(name="Category")
    public Category category;

    public Item(){
        super();
    }

    // If we define our custom constructor , we have to define the default constructor as well
    public Item(String name , Category category){
        this.name = name;
        this.category = category;
    }

}
