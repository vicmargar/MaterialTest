package com.example.victor.materialtest;

import android.app.Activity;

import java.io.IOException;
import java.io.InputStream;

public class AssetUtil {
    public static String loadJSON(Activity context, String name) {
        String json = null;
        try {
            InputStream is = ((Activity)context).getAssets().open(name);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
