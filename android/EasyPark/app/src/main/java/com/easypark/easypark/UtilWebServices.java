package com.easypark.easypark;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.*;

import org.apache.http.Header;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import parking.Parking;

/**
 * Created by chach on 16/07/2015.
 */
public  class UtilWebServices {
    private static String URL_WS="http://1-dot-robocorp-1008.appspot.com/api/structure/parking/";
    private static String TAG="ws";
    private Context context;
    Parking park = null;
    final Gson gson;
   public UtilWebServices(Context context){

       this.context=context;
        gson = new GsonBuilder().setPrettyPrinting().create();
   }
    public  Parking getParking(){
        String result;


        ////ObjectMapp
        //new CallWs().execute();
        /*try {
           URL url= new URL(URL_WS);
           HttpURLConnection urlConnection =(HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            //urlConnection.
            urlConnection.connect();
             result =urlConnection.getResponseMessage();
            Log.d(TAG,result);
            //parse parking avec jackson ou gson
            park=gson.fromJson(result,Parking.class);

             //park = new Parking(result);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        RequestParams params = new RequestParams();
        invokeWS(params);
    return park;
    }

         public void invokeWS(RequestParams params){
             // Show Progress Dialog

             // Make RESTful webservice call using AsyncHttpClient object
             AsyncHttpClient client = new AsyncHttpClient();
             client.get(URL_WS,params ,new AsyncHttpResponseHandler() {
                 // When the response returned by REST has Http response code '200'

                 @Override
                 public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                     String reponse="";
                     if (responseBody!=null){
                         try {
                             reponse = new String(responseBody, "UTF-8");
                         } catch (UnsupportedEncodingException e) {
                             e.printStackTrace();
                         }
                     }
                     //Log.d(TAG, "result"+responseBody.toString());
                     //Log.d(TAG, "result"+statusCode);
                     Toast.makeText(context, "OK", Toast.LENGTH_LONG).show();
                     park=gson.fromJson(reponse,Parking.class);
                     Toast.makeText(context,park.toString() , Toast.LENGTH_LONG).show();

                 }


                 @Override
                 public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                     // When Http response code is '404'
                     if(statusCode == 404){
                         Toast.makeText(context, "Requested resource not found", Toast.LENGTH_LONG).show();
                     }
                     // When Http response code is '500'
                     else if(statusCode == 500){
                         Toast.makeText(context, "Something went wrong at server end", Toast.LENGTH_LONG).show();
                     }
                     // When Http response code other than 404, 500
                     else{
                         Toast.makeText(context, "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]", Toast.LENGTH_LONG).show();
                     }
                 }
             });
         }


}
