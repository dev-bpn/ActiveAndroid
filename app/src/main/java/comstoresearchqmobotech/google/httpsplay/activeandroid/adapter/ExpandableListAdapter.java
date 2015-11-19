package comstoresearchqmobotech.google.httpsplay.activeandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import comstoresearchqmobotech.google.httpsplay.activeandroid.R;
import comstoresearchqmobotech.google.httpsplay.activeandroid.model.Child;
import comstoresearchqmobotech.google.httpsplay.activeandroid.model.Group;

/**
 * Created by Dell on 11/18/2015.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter{

    private Context context;
    private ArrayList<Group> groups;

    public ExpandableListAdapter(Context context, ArrayList<Group> groups) {
        this.context = context;
        this.groups = groups;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int position) {
        return groups.get(position).getItem().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groups.get(groupPosition).getItem().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View convertView, ViewGroup parent) {

        // always expand
        ExpandableListView mExpandableListView = (ExpandableListView) parent;
        mExpandableListView.expandGroup(groupPosition);

        Group group = (Group) getGroup(groupPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group , null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.group_name);
        textView.setText(group.getName());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View convertView, ViewGroup parent) {

        Child child = (Child) getChild(groupPosition , childPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_child , null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.country_name);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.flag);

        textView.setText(child.getName());
        imageView.setImageResource(child.getImage());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
