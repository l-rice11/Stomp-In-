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

public class Freestyle extends AppCompatActivity {

    SharedPreferences spFreestyle;
    Button btnSelectFreestyle;
    String strFreestyle;
    private VideoView vidView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freestyle);

        spFreestyle = getSharedPreferences("Freestyle", Context.MODE_PRIVATE);

        //Add a listener to the button to take you to the board size final
        Button btnSelectFreestyle=(Button) findViewById(R.id.btnSelectFreestyle);
        btnSelectFreestyle.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        strFreestyle = "Freestyle - The Crowd Pleaser\nTrue Twin Camber, Hybrid, or Flat";
                                                        SharedPreferences.Editor editor = spFreestyle.edit();
                                                        editor.putString("strFreestyle", strFreestyle);
                                                        editor.commit();
                                                        goSelectFreestyle();
                                                    }
                                                }
        );

        vidView = (VideoView) findViewById(R.id.videoView);
        vidView.setMediaController(new MediaController(this));
        Uri video = Uri.parse("android.resource://" +getPackageName()+"/"+R.raw.freestyle);
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

    private void goSelectFreestyle() {
        Intent intent = new Intent(Freestyle.this, BoardSizeFinal.class);
        intent.putExtra("FROM_ACTIVITY", "Freestyle");
        this.startActivity(intent);
    }
}