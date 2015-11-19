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
    private ArrayList<Group> group;

    public ExpandableListAdapter(Context context, ArrayList<Group> group) {
        this.context = context;
        this.group = group;
    }

    @Override
    public int getGroupCount() {
        return group.size();
    }

    @Override
    public int getChildrenCount(int position) {
        return group.get(position).getItem().size();
    }

    @Override
    public Object getGroup(int position) {
        return group.get(position);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return group.get(groupPosition).getItem().get(childPosition);
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
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {

        // always expand
        ExpandableListView mExpandableListView = (ExpandableListView) viewGroup;
        mExpandableListView.expandGroup(groupPosition);

        Group group = (Group) getGroup(groupPosition);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_group , null);
        }
        TextView textViewNum = (TextView) view.findViewById(R.id.textViewNum);
        TextView textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
        TextView textViewDescription = (TextView) view.findViewById(R.id.textViewTitleDescription);
        ImageView imageViewRing = (ImageView) view.findViewById(R.id.imageViewRing);

        textViewNum.setText(group.getGroupNum());
        textViewTitle.setText(group.getGroupTitle());
        textViewDescription.setText(group.getGroupDescription());
        imageViewRing.setImageResource(group.getGroupImageRing());

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
        Child child = (Child) getChild(groupPosition , childPosition);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_child , null);
        }
        ImageView imageViewShare = (ImageView) view.findViewById(R.id.imageViewShare);
        imageViewShare.setImageResource(child.getChildImage());
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
