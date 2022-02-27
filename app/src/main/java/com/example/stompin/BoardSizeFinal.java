package com.example.stompin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BoardSizeFinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_size_final);
        TextView getBoardSize;
        TextView getTerrainAndBoard;
        getBoardSize = findViewById(R.id.getBoardSize);
        getTerrainAndBoard = findViewById(R.id.getTerrainAndBoard);

        //Shared Preference for board size
        SharedPreferences sendBoardSize = getApplicationContext().getSharedPreferences("board_size", Context.MODE_PRIVATE);
        String boardSize = sendBoardSize.getString("boardSize", "");

        //Shared Preference for terrain and board type
        //All Mountain
        Intent intentAM = getIntent();
        String previousActivity = intentAM.getStringExtra("FROM_ACTIVITY");

        if(previousActivity.equals("AllMountain")) {
            SharedPreferences spAllTerrain = getApplicationContext().getSharedPreferences("All_Mountain", Context.MODE_PRIVATE);
            String strAllMountain = spAllTerrain.getString("strAllMountain", "");
            getTerrainAndBoard.setText(strAllMountain);
        }

        //Freestyle
        if(previousActivity.equals("Freestyle")) {
            SharedPreferences spFreestyle = getApplicationContext().getSharedPreferences("Freestyle", Context.MODE_PRIVATE);
            String strFreestyle = spFreestyle.getString("strFreestyle", "");
            getTerrainAndBoard.setText(strFreestyle);
        }

        //Backcountry
        if(previousActivity.equals("Backcountry")) {
            SharedPreferences spBackcountry = getApplicationContext().getSharedPreferences("Backcountry", Context.MODE_PRIVATE);
            String strBackcountry = spBackcountry.getString("strBackcountry", "");
            getTerrainAndBoard.setText(strBackcountry);
        }


        getBoardSize.setText(boardSize);

        //Add a listener to the button to take you to the main menu
        Button btnBackToStart=(Button) findViewById(R.id.btnBackToStart);
        btnBackToStart.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  goBackToStart();
                                              }
                                          }
        );

        //Add a listener to the button to take you to the weight selection
        Button btnBackToWeight=(Button) findViewById(R.id.btnBackToWeight);
        btnBackToWeight.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  goBackToWeight();
                                              }
                                          }
        );

        //Add a listener to the button to take you to the riding styles
        Button btnBackToRideStyle=(Button) findViewById(R.id.btnBackToRideStyle);
        btnBackToRideStyle.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  goBackToRideStyle();
                                              }
                                          }
        );

    }

    private void goBackToStart() {
        Intent intent = new Intent(BoardSizeFinal.this, MainActivity.class);
        this.startActivity(intent);
    }
    private void goBackToWeight() {
        Intent intent = new Intent(BoardSizeFinal.this, GetStarted.class);
        this.startActivity(intent);
    }
    private void goBackToRideStyle() {
        Intent intent = new Intent(BoardSizeFinal.this, BoardsAndStyles.class);
        this.startActivity(intent);
    }
}