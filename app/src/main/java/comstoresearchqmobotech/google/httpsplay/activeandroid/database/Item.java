package comstoresearchqmobotech.google.httpsplay.activeandroid.database;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Dell on 11/17/2015.
 */
@Table(name="Items")
public class Item extends Model {

    @Column(name="Name")
    public String name;

    @Column(name="Category")
    public Catagory catagory;

    public Item(){
        super();
    }

    // If we define our custom constructor , we have to define the default constructor as well
    public Item(String name , Catagory catagory){
        this.name = name;
        this.catagory = catagory;
    }

}
