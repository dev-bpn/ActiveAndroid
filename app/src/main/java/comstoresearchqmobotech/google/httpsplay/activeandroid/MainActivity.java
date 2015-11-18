package comstoresearchqmobotech.google.httpsplay.activeandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import comstoresearchqmobotech.google.httpsplay.activeandroid.adapter.ExpandableListAdapter;
import comstoresearchqmobotech.google.httpsplay.activeandroid.parsing.Apis;
import comstoresearchqmobotech.google.httpsplay.activeandroid.parsing.MyParser;
import comstoresearchqmobotech.google.httpsplay.activeandroid.toast.MyToast;
import comstoresearchqmobotech.google.httpsplay.activeandroid.utils.MyUtils;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> listDataHeader;
    private HashMap<String , List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        prepareDataList();
        expandableListView.setAdapter(new ExpandableListAdapter(this , listDataHeader , listDataChild));


    }

    private void prepareDataList() {

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String , List<String>>();

        listDataHeader.add("Now Showing");
        listDataHeader.add("Tomorrow Show");
        listDataHeader.add("Weekly Show");

        List<String> nowShow = new ArrayList<>();
        nowShow.add("The Shawshank Redemption");
        nowShow.add("The Godfather");
        nowShow.add("The Godfather: Part II");

        List<String> tomorrowShow = new ArrayList<>();
        tomorrowShow.add("The Conjuring");
        tomorrowShow.add("Despicable Me 2");
        tomorrowShow.add("Turbo");

        List<String> weeklyShow = new ArrayList<>();
        weeklyShow.add("2 Guns");
        weeklyShow.add("The Smurfs 2");
        weeklyShow.add("The Spectacular Now");

        listDataChild.put(listDataHeader.get(0) , nowShow);
        listDataChild.put(listDataHeader.get(1) , tomorrowShow);
        listDataChild.put(listDataHeader.get(2) , weeklyShow);

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
