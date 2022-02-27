package com.example.stompin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BoardsAndStyles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boards_and_styles);

        //Add a listener to the button to take you to the All Mountain
        Button btnAllMountain=(Button) findViewById(R.id.btnAllMountain);
        btnAllMountain.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  goAllMountain();
                                              }
                                          }
        );

        //Add a listener to the button to take you to the Freestyle
        Button btnFreestyle=(Button) findViewById(R.id.btnFreestyle);
        btnFreestyle.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  goFreestyle();
                                              }
                                          }
        );

        //Add a listener to the button to take you to the All Mountain
        Button btnBackcountry=(Button) findViewById(R.id.btnBackcountry);
        btnBackcountry.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  goBackcountry();
                                              }
                                          }
        );
    }

    private void goAllMountain() {
        Intent intent = new Intent(BoardsAndStyles.this, AllMountain.class);
        this.startActivity(intent);
    }

    private void goFreestyle() {
        Intent intent = new Intent(BoardsAndStyles.this, Freestyle.class);
        this.startActivity(intent);
    }

    private void goBackcountry() {
        Intent intent = new Intent(BoardsAndStyles.this, Backcountry.class);
        this.startActivity(intent);
    }
}
