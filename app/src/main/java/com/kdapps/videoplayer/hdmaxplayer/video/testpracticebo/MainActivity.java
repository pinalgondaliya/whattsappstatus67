package com.kdapps.videoplayer.hdmaxplayer.video.testpracticebo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edittext;
    Button next;
    int editnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext = findViewById(R.id.edittext);
        next = findViewById(R.id.next);


        String ssss = edittext.getText().toString();

        if (!edittext.getText().toString().isEmpty()){
            editnum = Integer.parseInt(edittext.getText().toString());
            Log.e("editnum", "onCreate: 111"+editnum);
        }

        Log.e("editnum", "onCreate:2222 "+editnum);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edittext.getText().toString().isEmpty()){
                    if (!edittext.getText().toString().isEmpty()){
                        editnum = Integer.parseInt(edittext.getText().toString());
                        Log.e("editnum", "onCreate: 333"+editnum);
                    }
                    Intent intent = new Intent(MainActivity.this,BoxActivity.class);
                    intent.putExtra("inputnum",editnum);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "please enter number of box", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}