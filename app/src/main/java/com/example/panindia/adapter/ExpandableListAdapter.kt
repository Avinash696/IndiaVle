package com.example.panindia.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.panindia.R

class ExpandableListAdapter : BaseExpandableListAdapter {
     private lateinit var mContext: Context
    private var listTitle: List<String>
     var listItem: Map<String, List<String>>

    constructor(
        mContext: Context,
        listTitle: List<String>,
        listItem: Map<String, List<String>>
    ) : super() {
        this.listTitle = listTitle
        this.listItem = listItem
    }

    override fun getGroupCount(): Int {
       return listTitle.size
    }

    override fun getChildrenCount(p0: Int): Int {
       return listItem.size
    }

    override fun getGroup(p0: Int): Any {
        return listTitle[p0]
    }
// p0- groupPostion   p1- childPosition
    override fun getChild(p0: Int, p1: Int): Any {
//        return listItem[listTitle[p0]]?.get(p1)!!
    return listItem.get(listTitle.get(p0))!!.get(p1)
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }
//p2 - convert view
    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View? {
        var title :String = getGroup(p0) as String
    var convertView : View? = p2
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_group,p3,false)
        }
        val textView = p2?.findViewById<TextView>(R.id.list_item)
         textView?.text = title
        return convertView
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View? {
        var title :String = getChild(p0,p1) as String
        var convertView1 : View? = p3
        if(p2 == null){
            convertView1 = LayoutInflater.from(mContext).inflate(R.layout.list_item,null)
        }
        val textChild = convertView1?.findViewById<TextView>(R.id.tvExpandableList)
        textChild?.text = title
        return convertView1
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        TODO("Not yet implemented")
    }
    // child data in format of header title, child title
//    val  HashMap<String>
//    List<String>> mListDataChild;
//    ExpandableListView  expandList;
//
//    public ExpandableListAdapter(Context context, List<String> listDataHeader,HashMap<String, List<String>> listChildData,ExpandableListView mView)
//    {
//        this.mContext = context;
//        this.mListDataHeader = listDataHeader;
//        this.mListDataChild = listChildData;
//        this.expandList = mView;
//    }
//
//    @Override
//    public int getGroupCount()
//    {
//        int i = mListDataHeader . size ();
//        Log.d("GROUPCOUNT", String.valueOf(i));
//        return this.mListDataHeader.size();
//    }
//
//    @Override
//    public int getChildrenCount(int groupPosition)
//    {
//        int childCount =0;
//        if (groupPosition != 2) {
//            childCount = this.mListDataChild.get(this.mListDataHeader.get(groupPosition))
//                .size();
//        }
//        return childCount;
//    }
//
//    @Override
//    public Object getGroup(int groupPosition)
//    {
//
//        return this.mListDataHeader.get(groupPosition);
//    }
//
//    @Override
//    public Object getChild(int groupPosition, int childPosition)
//    {
//        Log.d(
//            "CHILD", mListDataChild.get(this.mListDataHeader.get(groupPosition))
//                .get(childPosition).toString()
//        );
//        return this.mListDataChild.get(this.mListDataHeader.get(groupPosition))
//            .get(childPosition);
//    }
//
//    @Override
//    public long getGroupId(int groupPosition)
//    {
//        return groupPosition;
//    }
//
//    @Override
//    public long getChildId(int groupPosition, int childPosition)
//    {
//        return childPosition;
//    }
//
//    @Override
//    public boolean hasStableIds()
//    {
//        return false;
//    }
//
//    @Override
//    public View getGroupView(int groupPosition, boolean isExpanded, View   convertView, ViewGroup parent)
//    {
//        ExpandedMenuModel headerTitle =(ExpandedMenuModel) getGroup (groupPosition);
//        if (convertView == null) {
//            LayoutInflater infalInflater =(LayoutInflater) this.mContext
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = infalInflater.inflate(R.layout.listheader, null);
//        }
//        TextView lblListHeader =(TextView) convertView
//                .findViewById(R.id.submenu);
//        ImageView headerIcon =(ImageView) convertView . findViewById (R.id.iconimage);
//        lblListHeader.setTypeface(null, Typeface.BOLD);
//        lblListHeader.setText(headerTitle.getIconName());
//        headerIcon.setImageDrawable(headerTitle.getIconImg());
//        return convertView;
//    }
//
//    @Override
//    public View getChildView(int groupPosition, int childPosition,  boolean isLastChild, View convertView, ViewGroup parent)
//    {
//        final String childText = (String) getChild (groupPosition, childPosition);
//
//        if (convertView == null) {
//            LayoutInflater infalInflater =(LayoutInflater) this.mContext
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = infalInflater.inflate(R.layout.list_submenu, null);
//        }
//
//        TextView txtListChild =(TextView) convertView
//                .findViewById(R.id.submenu);
//
//        txtListChild.setText(childText);
//
//        return convertView;
//    }
//
//    @Override
//    public boolean isChildSelectable(int groupPosition, int childPosition)
//    {
//        return true;
//    }
}