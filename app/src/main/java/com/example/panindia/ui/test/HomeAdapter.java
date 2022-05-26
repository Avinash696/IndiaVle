package com.example.panindia.ui.test;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.example.panindia.R;
import com.example.panindia.model.adminModel;

import java.io.InputStream;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

class AdminHomeAdpter extends ArrayAdapter<adminModel> {

    // invoke the suitable constructor of the ArrayAdapter class
    public AdminHomeAdpter(@NonNull Context context, ArrayList<adminModel> arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.admin_home_adapter, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        adminModel currentNumberPosition = getItem(position);

        // then according to the position of the view assign the desired image for the same
        ImageView numbersImage = currentItemView.findViewById(R.id.ivAdmin);
        assert currentNumberPosition != null;
        numbersImage.setImageResource(currentNumberPosition.getAdminImage());

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textData = currentItemView.findViewById(R.id.tvAdmin);
        textData.setText(currentNumberPosition.getAdminText());


        // then return the recyclable view
        return currentItemView;
    }
}
