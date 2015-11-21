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
    public int getChildrenCount(int i) {
        return groups.get(i).getChildItems().size();
    }

    @Override
    public Object getGroup(int i) {
        return groups.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return groups.get(i).getChildItems().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        // always expand
        ExpandableListView mExpandableListView = (ExpandableListView) viewGroup;
        mExpandableListView.expandGroup(i);

        Group group = (Group) getGroup(i);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_group , null);
        }
        ImageView imageViewRing = (ImageView) view.findViewById(R.id.imageViewRing);
        TextView textViewNum = (TextView) view.findViewById(R.id.textViewNum);
        TextView textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
        coloringTitle(i , textViewTitle);
        TextView textViewDescription = (TextView) view.findViewById(R.id.textViewTitleDescription);

        imageViewRing.setImageResource(group.getGroupImage());
        textViewNum.setText(group.getGroupNum());
        textViewTitle.setText(group.getGroupTitle());
        textViewDescription.setText(group.getGroupTitleDescription());

        return view;
    }


    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        Child child = (Child) getChild(i, i1);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_child , null);
        }
        ImageView imageViewShare = (ImageView) view.findViewById(R.id.imageViewShare);
        imageViewShare.setImageResource(child.getChildImage());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    private void coloringTitle(int position , TextView textView) {

        switch (position){
            case 0:
                textView.setTextColor(context.getResources().getColor(R.color.link_text_material_dark));
                break;
            case 1:
                textView.setTextColor(context.getResources().getColor(R.color.material_deep_teal_200));
                break;
            case 2:
                textView.setTextColor(context.getResources().getColor(R.color.link_text_material_light));
                break;
        }
    }
}
