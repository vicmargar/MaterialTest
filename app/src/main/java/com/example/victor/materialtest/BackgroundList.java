package com.example.victor.materialtest;

import android.app.Activity;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class BackgroundList extends AsyncTask<Void, Void, ArrayList> {

    public DisplayableList activity;
    public BackgroundList(DisplayableList a) {
        activity = a;
    }

    private ArrayList<String> loadFromJSON() {
        String json = AssetUtil.loadJSON((Activity) activity, "items.json");
        ArrayList<String> list = new ArrayList<String>();
        try{
            JSONObject data = new JSONObject(json);
            JSONArray items = new JSONArray(data.getString("data"));

            int n = items.length();
            for (int i = 0; i < n; i++) {
                JSONObject jo = items.getJSONObject(i);
                String name = jo.getString("name");
                list.add(name);
            }
        }
        catch(JSONException je) {
            System.out.println( "Error: " + je.toString());
        }
        return list;
    }

    protected ArrayList<String> doInBackground(Void... params) {
        ArrayList <String> items = loadFromJSON();

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
