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
        expandableListView.setGroupIndicator(null);
        expListItems = setStandardGroup();
        expandableListView.setAdapter(new ExpandableListAdapter(this , expListItems));

    }

    private ArrayList<Group> setStandardGroup() {

        int group_image_ring[] = {R.drawable.ring , R.mipmap.ic_launcher , R.mipmap.ic_launcher};
        String group_num[] = {"1" , "2" , "3"};
        String group_title[] = {"title1" , "title2" , "title3"};
        String group_description[] = {"Here is mah desc1 honey" , "Here is mah desc2 honey" , "Here is mah desc3 honey"};
        int child_image_share[] = {R.drawable.ring , R.mipmap.ic_launcher , R.drawable.ring};

        ArrayList<Group> list = new ArrayList<>();
        ArrayList<Child> list_child;
        int size = 1 ;
        int j = 0;

        for(int i = 0 ; i < group_title.length ; i++){
            Group group = new Group();
            group.setGroupTitle(group_title[i]);
            group.setGroupNum(group_num[i]);
            group.setGroupDescription(group_description[i]);
            group.setGroupImageRing(group_image_ring[i]);

            list_child = new ArrayList<>();
            for(; j < size ; j++){

                Child child = new Child();
                child.setChildImage(child_image_share[j]);
                list_child.add(child);
            }
            group.setItem(list_child);
            list.add(group);
            size = size+1;
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
