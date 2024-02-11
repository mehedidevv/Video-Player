package com.mehedihasan.videoview;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    ListView listView;
    //ArrayList
    ArrayList<String>videolist;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Connection With ID
        connection();
        videolist=new ArrayList<>();
        videolist.add("video1");
        videolist.add("video2");
        videolist.add("video3");
        videolist.add("video4");
        videolist.add("video5");

        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,videolist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                      videoView.setVideoURI(Uri.parse("android.resource://" +getPackageName()+"/"+R.raw.video1));
                      break;

                    case 1:
                        videoView.setVideoURI(Uri.parse("android.resource://" +getPackageName()+"/"+R.raw.video2));
                        break;

                    case 2:
                        videoView.setVideoURI(Uri.parse("android.resource://" +getPackageName()+"/"+R.raw.video3));
                        break;

                    case 3:
                        videoView.setVideoURI(Uri.parse("android.resource://" +getPackageName()+"/"+R.raw.video4));
                        break;

                    case 4:
                        videoView.setVideoURI(Uri.parse("android.resource://" +getPackageName()+"/"+R.raw.video5));
                        break;
                }
                videoView.setMediaController(new MediaController(MainActivity.this));
                videoView.requestFocus();
                videoView.start();
            }
        });

    }

    private void connection() {
        videoView=findViewById(R.id.videoView);
        listView=findViewById(R.id.listView);
    }
}