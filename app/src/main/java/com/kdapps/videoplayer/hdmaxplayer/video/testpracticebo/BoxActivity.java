package com.kdapps.videoplayer.hdmaxplayer.video.testpracticebo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class BoxActivity extends AppCompatActivity {
    RecyclerView recbox;
    BoxAdapter boxAdapter;
    int sss;
    List<Integer> integers = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box);

        sss = getIntent().getIntExtra("inputnum",0);


        for (int i = 0; i <= sss - 1; i++) {
            integers.add(i);
        }

        recbox = findViewById(R.id.recbox);
        boxAdapter= new BoxAdapter(integers,BoxActivity.this);
        recbox.setAdapter(boxAdapter);

    }
}