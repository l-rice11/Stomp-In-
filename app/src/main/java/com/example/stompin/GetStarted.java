package com.example.stompin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class GetStarted extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner weightSpinner;
    private static final String[] paths = {"(Please select a weight)", "80lb or less / 36kg", "80-110lb / 36-50kg", "110-120lb / 50-54kg", "120-130lb / 54-59kg",
            "130-140lb / 59-63kg", "140-150lb / 63-68kg", "150-160lb / 68-73kg", "160-170lb / 73-77kg", "170-180lb / 77-82kg",
            "180-190lb / 82-86kg", "190-200lb / 86-91kg", "200-210lb / 91-95kg", "210lb and up / 95kg"};
    private TextView messageBoardSize;
    private String boardSize;
    SharedPreferences sendBoardSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        weightSpinner = (Spinner) findViewById(R.id.weightSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(GetStarted.this,
                android.R.layout.simple_spinner_item, paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weightSpinner.setAdapter(adapter);
        weightSpinner.setOnItemSelectedListener(this);

        messageBoardSize = (TextView) findViewById(R.id.messageBoardSize);
        sendBoardSize = getSharedPreferences("board_size", Context.MODE_PRIVATE);

        //Add a listener to the button to take you to the Board Info
        Button btnNextToStyle=(Button) findViewById(R.id.btnNextToStyle);
        btnNextToStyle.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                goBoardInfo();
                                            }
                                        }
        );
    }

    //select weight spinner options
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                boardSize = "Please Select a weight.";
                messageBoardSize.setText(boardSize);
                break;
            case 1:
                boardSize = "90-135cm";
                messageBoardSize.setText(boardSize);
                Toast.makeText(getApplicationContext(), "Perfect, Let's move on!", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                boardSize = "135-146cm";
                messageBoardSize.setText(boardSize);
                Toast.makeText(getApplicationContext(), "Perfect, Let's move on!", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                boardSize = "142-148cm";
                messageBoardSize.setText(boardSize);
                Toast.makeText(getApplicationContext(), "Perfect, Let's move on!", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                boardSize = "144-149cm";
                messageBoardSize.setText(boardSize);
                Toast.makeText(getApplicationContext(), "Perfect, Let's move on!", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                boardSize = "146-152cm";
                messageBoardSize.setText(boardSize);
                Toast.makeText(getApplicationContext(), "Perfect, Let's move on!", Toast.LENGTH_SHORT).show();
                break;
            case 6:
                boardSize = "148-154cm";
                messageBoardSize.setText(boardSize);
                Toast.makeText(getApplicationContext(), "Perfect, Let's move on!", Toast.LENGTH_SHORT).show();
                break;
            case 7:
                boardSize = "151-156cm";
                messageBoardSize.setText(boardSize);
                Toast.makeText(getApplicationContext(), "Perfect, Let's move on!", Toast.LENGTH_SHORT).show();
                break;
            case 8:
                boardSize = "152-158cm";
                messageBoardSize.setText(boardSize);
                Toast.makeText(getApplicationContext(), "Perfect, Let's move on!", Toast.LENGTH_SHORT).show();
                break;
            case 9:
                boardSize = "153-159cm";
                messageBoardSize.setText(boardSize);
                Toast.makeText(getApplicationContext(), "Perfect, Let's move on!", Toast.LENGTH_SHORT).show();
                break;
            case 10:
                boardSize = "155-161cm";
                messageBoardSize.setText(boardSize);
                Toast.makeText(getApplicationContext(), "Perfect, Let's move on!", Toast.LENGTH_SHORT).show();
                break;
            case 11:
                boardSize = "157-163cm";
                messageBoardSize.setText(boardSize);
                Toast.makeText(getApplicationContext(), "Perfect, Let's move on!", Toast.LENGTH_SHORT).show();
                break;
            case 12:
                boardSize = "158-165cm";
                messageBoardSize.setText(boardSize);
                Toast.makeText(getApplicationContext(), "Perfect, Let's move on!", Toast.LENGTH_SHORT).show();
                break;
            case 13:
                boardSize = "159-168cm";
                messageBoardSize.setText(boardSize);
                Toast.makeText(getApplicationContext(), "Perfect, Let's move on!", Toast.LENGTH_SHORT).show();
                break;
        }
        SharedPreferences.Editor editor = sendBoardSize.edit();
        editor.putString("boardSize", boardSize);
        editor.commit();
    }

    //if no weightspinner option selected
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        String noWeightSelected = "Please select a weight.";
    }

    private void goBoardInfo() {
        Intent intent = new Intent(GetStarted.this, BoardsAndStyles.class);
        this.startActivity(intent);
    }
}
