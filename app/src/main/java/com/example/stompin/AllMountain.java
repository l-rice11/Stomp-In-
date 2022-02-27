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

public class AllMountain extends AppCompatActivity {

    SharedPreferences spAllMountain;
    Button btnSelectAllMountain;
    String strAllMountain;
    private VideoView vidView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_mountain);

        spAllMountain = getSharedPreferences("All_Mountain", Context.MODE_PRIVATE);

        //Add a listener to the button to take you to the board size final
        Button btnSelectAllMountain=(Button) findViewById(R.id.btnSelectAllMountain);
        btnSelectAllMountain.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  strAllMountain = "All Mountain - The Terrain Conqueror\nTwin-Directional Camber/Hybrid (suggested, but many options available)";
                                                  SharedPreferences.Editor editor = spAllMountain.edit();
                                                  editor.putString("strAllMountain", strAllMountain);
                                                  editor.commit();
                                                  goSelectAllMountain();
                                              }
                                          }
        );

        vidView = (VideoView) findViewById(R.id.videoView);
        vidView.setMediaController(new MediaController(this));
        Uri video = Uri.parse("android.resource://" +getPackageName()+"/"+R.raw.allmountain);
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

    private void goSelectAllMountain() {
        Intent intent = new Intent(AllMountain.this, BoardSizeFinal.class);
        intent.putExtra("FROM_ACTIVITY", "AllMountain");
        this.startActivity(intent);
    }
}