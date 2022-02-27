package com.example.stompin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Backcountry extends AppCompatActivity {

    SharedPreferences spBackcountry;
    Button btnSelectFreestyle;
    String strBackcountry;
    private VideoView vidView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backcountry);

        spBackcountry = getSharedPreferences("Backcountry", Context.MODE_PRIVATE);

        //Add a listener to the button to take you to the board size final
        Button btnSelectBackcountry=(Button) findViewById(R.id.btnSelectBackcountry);
        btnSelectBackcountry.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        strBackcountry = "Backcountry - The Fearless Adventurer\nDirectional Rocker, Hybrid, and Flat";
                                                        SharedPreferences.Editor editor = spBackcountry.edit();
                                                        editor.putString("strBackcountry", strBackcountry);
                                                        editor.commit();
                                                        goSelectBackcountry();
                                                    }
                                                }
        );

        vidView = (VideoView) findViewById(R.id.videoView);
        vidView.setMediaController(new MediaController(this));
        Uri video = Uri.parse("android.resource://" +getPackageName()+"/"+R.raw.backcountry);
        vidView.setVideoURI(video);
        vidView.setZOrderOnTop(true);
    }

    protected void onResume() {
        super.onResume();
        vidView.start();
    }

    protected void onPause() {
        vidView.stopPlayback();
        super.onPause();
    }

    private void goSelectBackcountry() {
        Intent intent = new Intent(Backcountry.this, BoardSizeFinal.class);
        intent.putExtra("FROM_ACTIVITY", "Backcountry");
        this.startActivity(intent);
    }
}