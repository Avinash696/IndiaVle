//package com.example.panindia.ui.test.expandableListTest;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.widget.ExpandableListView;
//
//import com.example.panindia.R;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class expActivity extends AppCompatActivity {
//    ExpandableListView expandableListView;
//    List<String> listGroup;
//    HashMap<String, List<String>> listItem;
//    MainAdapter mainAdapter;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_exp);
//        init();
//        initData();
//        mainAdapter =new MainAdapter(this,listGroup,listItem);
//        expandableListView.setAdapter(mainAdapter);
//    }
//    void init(){
//        expandableListView = findViewById(R.id.expList);
//    }
//    void initData(){
//        String arr[] = {"Avi","sja"};
//        listGroup = new ArrayList<>();
//        listItem = new HashMap<>();
//        listGroup.add(getString(R.string.GroupAdmin));
//        String[] array;
//        List<String> list = new ArrayList<>();
//        array = getResources().getStringArray(R.array.GroupAdmin);
//        for(String item :array){
//            list.add(item);
//        }
////        listItem.put(listGroup.get(0),list);
////        mainAdapter.notifyDataSetChanged();
//    }
//}