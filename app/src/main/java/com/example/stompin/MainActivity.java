package com.example.stompin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add a listener to the button to take you to the Get Started
        Button btnGetStarted=(Button) findViewById(R.id.btnGetStarted);
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 goGetStarted();
                                             }
                                         }

        );
        //Add a listener to the button to take you to the Board Info
        Button btnBoardInfo=(Button) findViewById(R.id.btnBoardInfo);
        btnBoardInfo.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 goBoardInfo();
                                             }
                                         }
        );

        //Add a listener to the button to exit the app
        Button btnExit=(Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 finish();
                                                 System.exit(0);
                                             }
                                         }
        );
    }


    private void goGetStarted() {
        Intent intent = new Intent(MainActivity.this, GetStarted.class);
        this.startActivity(intent);
    }

    private void goBoardInfo() {
        Intent intent = new Intent(MainActivity.this, BoardsAndStyles.class);
        this.startActivity(intent);
    }
}