package com.easypark.easypark;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by chach on 16/07/2015.
 */
public class UtilWebServices {
    private static String URL_WS="http://";
    public Parking getParking(){
        String result;
        Parking park = null;
        //ObjectMapp
        try {
           URL url= new URL(URL_WS);
           HttpURLConnection urlConnection =(HttpURLConnection) url.openConnection();
             result =urlConnection.getResponseMessage();
            //parse parking avec jackson ou gson
             park = new Parking(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    return park;
    }
}
