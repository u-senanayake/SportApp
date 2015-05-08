package com.example.SportApp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Udayanga Senanayake on 5/6/2015.
 */
public class MyAdapter extends ArrayAdapter {
    Context context;
    public MyAdapter(Context context, ArrayList<Venue> arrayList) {
        super(context, 0, arrayList);
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Venue venue=(Venue)getItem(position);
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.show_data_activity,parent,false);
        }
        TextView description=(TextView)convertView.findViewById(R.id.descriptionTextView);
        TextView title=(TextView)convertView.findViewById(R.id.titleTextView);
        //TextView link=(TextView)convertView.findViewById(R.id.textView3);
        ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView);
        imageView.setImageBitmap(venue.bitmap);
        String link=venue.img;

        Button button = (Button)convertView.findViewById(R.id.showMoreBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("link", link);
                context.startActivity(intent);
            }
        });
        description.setText(venue.description);
        title.setText(venue.title);
        String showLink=venue.link;

        return convertView;
    }
}
