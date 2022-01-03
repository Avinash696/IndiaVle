package com.example.panindia.ui.test.expandableListTest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.panindia.R;

import java.util.HashMap;
import java.util.List;

public class MainAdapter extends BaseExpandableListAdapter {
    Context context;
    List<String> listGroup;
    HashMap<String,List<String>> listItem;

    public MainAdapter(Context context, List<String> listGroup, HashMap<String, List<String>> listItem) {
        this.context = context;
        this.listGroup = listGroup;
        this.listItem = listItem;
    }

    @Override
    public int getGroupCount() {
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listItem.get(listGroup.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listItem.get(listGroup.get(groupPosition)).get(childPosition);
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
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {
        String group = context.getString(groupPosition);
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.adapter_main_row,null);
        }
        TextView textView =view.findViewById(R.id.list_parent);
        textView.setText(group);
        return view;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
        String child = context.getString(groupPosition,childPosition);
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.adapter_list_item_row,null);
        }
        TextView textView =view.findViewById(R.id.list_child);
        textView.setText(child);
        return view;

    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
