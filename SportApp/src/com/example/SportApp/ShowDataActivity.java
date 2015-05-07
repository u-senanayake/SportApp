package com.example.SportApp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import com.example.SportApp.MainActivity;

/**
 * Created by Udayanga Senanayake on 5/6/2015.
 */
public class ShowDataActivity extends Activity implements AsyncResponse {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        webService();
    }
    public  void webService() {
        //get value form  intent
        Bundle bundle=getIntent().getExtras();
        String value=bundle.getString("sportLink2");
        System.out.println(value);
        switch (value) {
            case "Football": {
                WebService webService = new WebService(ShowDataActivity.this, "get", "Loading");
                webService.asyncResponse = this;
                webService.execute("https://skysportsapi.herokuapp.com/sky/getnews/football/v1.0/");
                break;
            }
            case "Cricket":{
                WebService webService = new WebService(ShowDataActivity.this, "get", "Loading");
                webService.asyncResponse = this;
                webService.execute("https://skysportsapi.herokuapp.com/sky/getnews/cricket/v1.0/");
                break;
            }
            case "Tennis":{
                WebService webService = new WebService(ShowDataActivity.this, "get", "Loading");
                webService.asyncResponse = this;
                webService.execute("https://skysportsapi.herokuapp.com/sky/getnews/tennis/v1.0/");
                break;
            }
            case "Golf":{
                WebService webService = new WebService(ShowDataActivity.this, "get", "Loading");
                webService.asyncResponse = this;
                webService.execute("https://skysportsapi.herokuapp.com/sky/getnews/golf/v1.0/");
                break;
            }

            case "Rugby-League":{
                WebService webService = new WebService(ShowDataActivity.this, "get", "Loading");
                webService.asyncResponse = this;
                webService.execute("https://skysportsapi.herokuapp.com/sky/getnews/rugby-league/v1.0/");
                break;
            }
            case "Rugby-Union":{
                WebService webService = new WebService(ShowDataActivity.this, "get", "Loading");
                webService.asyncResponse = this;
                webService.execute("https://skysportsapi.herokuapp.com/sky/getnews/rugby-union/v1.0/");
                break;
            }
            case "Boxing":{
                WebService webService = new WebService(ShowDataActivity.this, "get", "Loading");
                webService.asyncResponse = this;
                webService.execute("https://skysportsapi.herokuapp.com/sky/getnews/boxing/v1.0/");
                break;
            }

        }
    }

    @Override
    public void processFinish(String output) {

        ArrayList<Venue> arrayList=new ArrayList<>();
        try {
            JSONArray jsonArray=new JSONArray(output);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jo=new JSONObject(jsonArray.getString(i));
                LoadImage loadImage = new LoadImage();
                Bitmap bitmap = loadImage.execute(jo.getString("imgsrc")).get();
                arrayList.add(new Venue(jo.getString("title"), jo.getString("shortdesc"), jo.getString("imgsrc"),jo.getString("link"),bitmap));
            }
            MyAdapter myAdapter=new MyAdapter(ShowDataActivity.this,arrayList);
            ListView listView=(ListView)findViewById(R.id.listView);
            listView.setAdapter(myAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    public class LoadImage extends AsyncTask<String,String,Bitmap> {
        Bitmap bitmap;
        @Override
        protected Bitmap doInBackground(String... params) {
            try{
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(params[0]).getContent());
            }catch (Exception e){
                e.printStackTrace();
            }
            return bitmap;
        }
    }
}