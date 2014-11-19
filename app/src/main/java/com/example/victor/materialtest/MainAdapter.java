package com.example.victor.materialtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


class MainAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> items;

    public MainAdapter(Context context, ArrayList<String> items) {
        super(context, R.layout.row, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // 3. Get the text view from the rowView
        TextView textView = (TextView) rowView.findViewById(R.id.rowview);

        // 4. Set the text for textView
        textView.setText(items.get(position));

        // 5. return rowView
        return rowView;
    }
}