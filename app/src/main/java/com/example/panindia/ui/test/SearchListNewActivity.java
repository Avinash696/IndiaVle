package com.example.panindia.ui.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import com.example.panindia.R;

import java.util.ArrayList;
import java.util.List;

public class SearchListNewActivity extends AppCompatActivity {
    private SearchView searchView;
    private ExampleAdapter adapter;
    private List<ExampleItem> exampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list_new);

//        init();
        fillExampleList();
        setUpRecyclerView();

    }

    private void init() {
//        searchView = findViewById(R.id.searchTest);
    }

    private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.add, "One", "Ten"));
        exampleList.add(new ExampleItem(R.drawable.bg, "Two", "Eleven"));
        exampleList.add(new ExampleItem(R.drawable.arrow_down, "Three", "Twelve"));
        exampleList.add(new ExampleItem(R.drawable.arrow_down, "Four", "Thirteen"));
        exampleList.add(new ExampleItem(R.drawable.arrow_down, "Five", "Fourteen"));
        exampleList.add(new ExampleItem(R.drawable.arrow_down, "Six", "Fifteen"));
        exampleList.add(new ExampleItem(R.drawable.arrow_down, "Seven", "Sixteen"));
        exampleList.add(new ExampleItem(R.drawable.arrow_down, "Eight", "Seventeen"));
        exampleList.add(new ExampleItem(R.drawable.arrow_down, "Nine", "Eighteen"));
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.example_menu, menu);
                MenuItem searchItem = menu.findItem(R.id.actionSearch);
                SearchView searchView = (SearchView) searchItem.getActionView();
                searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return true;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        adapter.getFilter().filter(newText);
                        return true;
                    }
                });
            }
        });


        return super.onCreateOptionsMenu(menu);
//        return  true;
    }

}