package comstoresearchqmobotech.google.httpsplay.activeandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

import comstoresearchqmobotech.google.httpsplay.activeandroid.adapter.ExpandableListAdapter;
import comstoresearchqmobotech.google.httpsplay.activeandroid.database.DataItems;
import comstoresearchqmobotech.google.httpsplay.activeandroid.model.Child;
import comstoresearchqmobotech.google.httpsplay.activeandroid.model.Group;
import comstoresearchqmobotech.google.httpsplay.activeandroid.parsing.Apis;
import comstoresearchqmobotech.google.httpsplay.activeandroid.parsing.MyParser;
import comstoresearchqmobotech.google.httpsplay.activeandroid.toast.MyToast;
import comstoresearchqmobotech.google.httpsplay.activeandroid.utils.MyUtils;

public class MainActivity extends AppCompatActivity implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;
    private ArrayList<Group> dataList;

    private List<String> titleList ;
    private List<String> descList ;
    private List<String> titleLink ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListView.setGroupIndicator(null);
        dataForExpandableList();
        dataList = getGroupList();
        expandableListView.setAdapter(new ExpandableListAdapter(this, dataList));
        expandableListView.setOnChildClickListener(this);
        expandableListView.setOnGroupClickListener(this);

    }

    private void dataForExpandableList(){

        if(MyUtils.isTableDataExists()) {
            List<DataItems> queryResults = new Select().from(DataItems.class).orderBy("Id ASC").execute();

            titleList = new ArrayList<>();
            descList = new ArrayList<>();
            titleLink = new ArrayList<>();

            for (int i = 10; i < 20; i++) {
                titleList.add(queryResults.get(i).getTitle());
                descList.add(queryResults.get(i).getDescription());
                titleLink.add(queryResults.get(i).getTitleLink());
            }
        }
    }


    private ArrayList<Group> getGroupList() {


        int[] imageViewRing = {R.drawable.ring , R.mipmap.ic_launcher , R.drawable.ring , R.drawable.ring ,
                R.mipmap.ic_launcher , R.drawable.ring , R.mipmap.ic_launcher , R.drawable.ring , R.drawable.ring
                , R.mipmap.ic_launcher};
        String[] textViewNum = {"1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "10"};
        int[] imageViewShare = { R.mipmap.ic_launcher};

        ArrayList<Group> list = new ArrayList<>();
        ArrayList<Child> childArrayList = null;

        if(MyUtils.isTableDataExists()) {
            for (int i = 0; i < textViewNum.length; i++) {
                Group group = new Group();
                group.setGroupImage(imageViewRing[i]);
                group.setGroupNum(textViewNum[i]);
                group.setGroupTitle(titleList.get(i));
                group.setGroupTitleDescription(descList.get(i));

                for (int j = 0; j < 1; j++) {

                    Child child = new Child();
                    childArrayList = new ArrayList<>();
                    child.setChildImage(imageViewShare[j]);
                    childArrayList.add(child);
                }
                group.setChildItems(childArrayList);
                list.add(group);
            }
        }
        return list;
    }

    @Override
    public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {

        switch (groupPosition){
            case 0:
                MyToast.showToast(getApplicationContext() , "Child Item: "+ titleLink.get(0));
                break;
            case 1:
                MyToast.showToast(getApplicationContext() , "Child Item: "+ titleLink.get(1));
                break;
            case 2:
                MyToast.showToast(getApplicationContext() , "Child Item: "+ titleLink.get(2));
                break;
        }
        return false;
    }

    @Override
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
        switch (i){
            case 0:
                MyToast.showToast(getApplicationContext() , "Group Item 1 is clicked");
                break;
            case 1:
                MyToast.showToast(getApplicationContext() , "Group Item 2 is clicked");
                break;
            case 2:
                MyToast.showToast(getApplicationContext() , "Group Item 3 is clicked");
                break;
        }
        return false;
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
