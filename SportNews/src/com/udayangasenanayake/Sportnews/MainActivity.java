package com.udayangasenanayake.Sportnews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Spinner sportList;
    private Button btnSubmit;
    String sportLink;
    String[] sport = {"Cricket", "Tennis", "Golf","Football","Rugby-League","Rugby-Union","Boxing"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        addItemlist();


        Button button=(Button)findViewById(R.id.buttonSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowDataActivity.class);

                sportList=(Spinner)findViewById(R.id.spinnerSport);
                sportLink=sportList.getSelectedItem().toString();
                intent.putExtra("sportLink2",sportLink);
                startActivity(intent);
            }
        });
    }
    public String getLink(){
        String x=this.sportLink;
        return  x;
    }
    public void addItemlist() {
        sportList = (Spinner) findViewById(R.id.spinnerSport);
        ArrayAdapter<String> dataAdapterSport = new ArrayAdapter<String>
                (MainActivity.this, android.R.layout.simple_spinner_dropdown_item, sport);
        dataAdapterSport.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        sportList.setAdapter(dataAdapterSport);


        addListenerOnButton();
    }
    public void addListenerOnButton() {

        sportList = (Spinner) findViewById(R.id.spinnerSport);
        btnSubmit = (Button) findViewById(R.id.buttonSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,
                        "On Button Click : " +
                                "\n" + String.valueOf(sportList.getSelectedItem()),
                        Toast.LENGTH_LONG).show();
            }
        });
    }}

