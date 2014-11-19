package com.example.victor.materialtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import java.util.ArrayList;
import android.content.Intent;

public class MainActivity extends Activity implements DisplayableList {

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);

        new BackgroundList(this).execute();
    }

    public void displayList(ArrayList list) {
        final MyAdapter adapter = new MyAdapter(this, list);
        listview.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void switchActivity(View view) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }

    private class MyAdapter extends ArrayAdapter<String> {
        private final Context context;
        private final ArrayList<String> items;

        public MyAdapter(Context context, ArrayList<String> items) {
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
}
