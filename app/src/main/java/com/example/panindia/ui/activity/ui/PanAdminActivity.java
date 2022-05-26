package com.example.panindia.ui.activity.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.panindia.R;
import com.example.panindia.adapter.MyExpandableListAdapter;
import com.example.panindia.ui.activity.JoiningListActivity;
import com.example.panindia.ui.activity.RegisterActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PanAdminActivity extends AppCompatActivity {
    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> mobileCollection;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pan_admin);
        getSupportActionBar().hide();
        createGroupList();
        createCollection();
        expandableListView = findViewById(R.id.elvMobiles);
        expandableListAdapter = new MyExpandableListAdapter(this, groupList, mobileCollection);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandedPosition = -1;
            @Override
            public void onGroupExpand(int i) {
                if(lastExpandedPosition != -1 && i != lastExpandedPosition){
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = i;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                String selected = expandableListAdapter.getChild(i,i1).toString();
                onClickExpandableListView(selected);
                Toast.makeText(getApplicationContext(), "Selected: " + selected, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
    private void onClickExpandableListView(String selected){
        if(selected.equals("Create Admin")){
            startActivity(new Intent(this, RegisterActivity.class));
        }
        else if(selected.equals("Create Super Distributer")) {
            startActivity(new Intent(this, RegisterActivity.class));
        }
        else if(selected.equals("Create Distributer")) {
            startActivity(new Intent(this, RegisterActivity.class));
        }
        else if(selected.equals("Create Retailer")) {
            startActivity(new Intent(this, RegisterActivity.class));
        }
        else if(selected.equals("Create Admin Join")){
            startActivity(new Intent(this, JoiningListActivity.class));
        }
        else if(selected.equals("Home")){
            startActivity(new Intent(this, HomeMainActivity.class));
        }

    }
    private void createCollection() {
        String[] homeModel = {"Home"};
        String[] samsungModels = {"Create Admin", "Create Super Distributer",
                "Create Distributer", "Create Retailer"};
        String[] googleModels = {"Create Admin Join", "Create Super Distributer",
                "Create Distributer", "Create Retailer"};
        String[] redmiModels = {"Distributer Valut", "Balance Upload", "WL Limit Distributer","Payout"};
        String[] vivoModels = {"Full Valut History", "WL Limit History", "IP Search", "Settlement History"};
        String[] nokiaModels = {"Create Notification Request", "Markup Setting", "Order ID Verify","Transition Id Verify",
                                    "Change Website","Change Own password","Activate/Deactivate","User Req"};
        String[] motorolaModels = { "Motorola One Fusion+", "Motorola E7 Plus", "Motorola G9"};
        mobileCollection = new HashMap<String, List<String>>();
        for(String group : groupList){
            if (group.equals("Create Partner")){
                loadChild(samsungModels);
            }
            else if(group.equals("Home")){
                loadChild(homeModel);
            }
            else if (group.equals("Joining List"))
                loadChild(googleModels);
            else if (group.equals("Accounts"))
                loadChild(redmiModels);
            else if (group.equals("History"))
                loadChild(vivoModels);
            else if (group.equals("Setting"))
                loadChild(nokiaModels);
            else
                loadChild(motorolaModels);
            mobileCollection.put(group, childList);
        }
    }

    private void loadChild(String[] mobileModels) {
        childList = new ArrayList<>();
        for(String model : mobileModels){
            childList.add(model);
        }
    }

    private void createGroupList() {
        groupList = new ArrayList<>();
        groupList.add("Home");
        groupList.add("Create Partner");
        groupList.add("Joining List");
        groupList.add("Accounts");
        groupList.add("History");
        groupList.add("Setting");
//        groupList.add("Motorola");

    }
}