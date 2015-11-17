package comstoresearchqmobotech.google.httpsplay.activeandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

import comstoresearchqmobotech.google.httpsplay.activeandroid.database.Category;
import comstoresearchqmobotech.google.httpsplay.activeandroid.database.Item;
import comstoresearchqmobotech.google.httpsplay.activeandroid.log.MyLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Category restaurant = new Category();
        restaurant.name = "CategoryName1";
        restaurant.save();
        MyLog.showLog("category name saved");

        Item item = new Item();
        item.category = restaurant;
        item.name = "restaurantName 1";
        item.save();

        item = new Item();
        item.category = restaurant;
        item.name = "Olive Garden";
        item.save();
        MyLog.showLog("Restaurants name saved");


        // Bulk Insertion
        try {
            ActiveAndroid.beginTransaction();

            for (int i = 0 ; i < 100 ; i++){
                Item item1 = new Item();
                item1.name = "Example: "+ i;
                item1.save();
            }
            MyLog.showLog("Bulk insertion Succeed");
        } finally{
            ActiveAndroid.endTransaction();
        }


//          // Deleting Records
//        Item item1 = Item.load(Item.class , 1);
//        item1.delete();
//        MyLog.showLog("Item at 1 deleted");

        // Deleting Statically
        Item.delete(Item.class , 1);
        MyLog.showLog("Item at 1 deleted statically");

        // Deleting by Query Database
        new Delete().from(Item.class).where("Id = ?" , 1).execute();
        MyLog.showLog("Item at 1 deleted By using Query");

        getRandom();
        String strr = getRandom().name;
        MyLog.showLog("getRandom() Name: "+strr);

        String name1 = getRandom(restaurant).name;
        MyLog.showLog("getRandom(category) Name: " + name1);

    }

    public static Item getRandom(){
        return new Select().from(Item.class).orderBy("RANDOM()").executeSingle();
    }

    public static Item getRandom(Category category){
        return new Select().from(Item.class)
                .where("Category = ?" , category.getId())
                .orderBy("RANDOM()")
                .executeSingle();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
