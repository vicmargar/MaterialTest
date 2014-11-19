package com.example.victor.materialtest;

import android.app.Activity;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.Arrays;

public class BackgroundList extends AsyncTask<Void, Void, ArrayList> {
    public DisplayableList activity;

    public BackgroundList(DisplayableList a) {
        activity = a;
    }

    protected ArrayList<String> doInBackground(Void... params) {
        ArrayList<String> items = new ArrayList<String>(
            Arrays.asList("Android", "iPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu", "Windows7", "Mac OS X")
        );

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // don't know
        }

        return items;
    }

    protected void onProgressUpdate(Void... params) {}

    protected void onPostExecute(ArrayList result) {
        activity.displayList(result);
    }
}
