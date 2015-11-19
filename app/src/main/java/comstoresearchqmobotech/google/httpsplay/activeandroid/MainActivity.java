package comstoresearchqmobotech.google.httpsplay.activeandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import comstoresearchqmobotech.google.httpsplay.activeandroid.adapter.ExpandableListAdapter;
import comstoresearchqmobotech.google.httpsplay.activeandroid.model.Child;
import comstoresearchqmobotech.google.httpsplay.activeandroid.model.Group;
import comstoresearchqmobotech.google.httpsplay.activeandroid.parsing.Apis;
import comstoresearchqmobotech.google.httpsplay.activeandroid.parsing.MyParser;
import comstoresearchqmobotech.google.httpsplay.activeandroid.toast.MyToast;
import comstoresearchqmobotech.google.httpsplay.activeandroid.utils.MyUtils;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;
    private ArrayList<Group> expListItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expListItems = setStandardGroups();
        expandableListView.setAdapter(new ExpandableListAdapter(this , expListItems));


    }

    private ArrayList<Group> setStandardGroups() {

        String group_names[] = { "GROUP A", "GROUP B", "GROUP C", "GROUP D",
                "GROUP E", "GROUP F", "GROUP G", "GROUP H" };

        String country_names[] = { "Brazil", "Mexico", "Croatia", "Cameroon",
                "Netherlands", "chile", "Spain", "Australia", "Colombia",
                "Greece", "Ivory Coast", "Japan", "Costa Rica", "Uruguay",
                "Italy", "England", "France", "Switzerland", "Ecuador",
                "Honduras", "Agrentina", "Nigeria", "Bosnia and Herzegovina",
                "Iran", "Germany", "United States", "Portugal", "Ghana",
                "Belgium", "Algeria", "Russia", "Korea Republic" };

        int images[] = { R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                };

        ArrayList<Group> list = new ArrayList<>();
        ArrayList<Child> child_list;
        int size = 4;
        int j = 0;

        for(String group_name : group_names){

            Group group = new Group();
            group.setName(group_name);
            child_list = new ArrayList<>();
            for(; j < size ; j++){
                Child child = new Child();
                child.setName(country_names[j]);
                child.setImage(images[j]);
                child_list.add(child);
            }

            group.setItem(child_list);
            list.add(group);

            size = size + 4;
        }

        return list;
    }


    private void getData(){

        if(MyUtils.isTableDataExists())
        {
            MyToast.showToast(this, "Show data from Database");
        }
        else
        {
            if(MyUtils.isNetworkConnected(this))
            {
                MyParser.performVolleyRequest(this, Apis.POST_URL);
            }
            else
            {
                MyToast.showToast(this, "No Internet Connectivity");
            }
        }

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
