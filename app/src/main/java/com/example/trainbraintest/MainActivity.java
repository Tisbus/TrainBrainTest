package com.example.trainbraintest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textViewScore;
    private TextView textViewTimer;
    private TextView textViewArg;
    private TextView textViewRes0;
    private TextView textViewRes1;
    private TextView textViewRes2;
    private TextView textViewRes3;
    private ArrayList<TextView> buttons;
    int randomNum1;
    int randomNum2;
    int randomRightButton;
    int rightResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewScore = (TextView)findViewById(R.id.textViewScore);
        textViewTimer = (TextView)findViewById(R.id.textViewTimer);
        textViewArg = (TextView)findViewById(R.id.textViewArg);
        textViewRes0 = (TextView)findViewById(R.id.textViewRes0);
        textViewRes1 = (TextView)findViewById(R.id.textViewRes1);
        textViewRes2 = (TextView)findViewById(R.id.textViewRes2);
        textViewRes3 = (TextView)findViewById(R.id.textViewRes3);
        buttons = new ArrayList<>();
        buttons.add(textViewRes0);
        buttons.add(textViewRes1);
        buttons.add(textViewRes2);
        buttons.add(textViewRes3);
        playGames();
    }

    @SuppressLint("SetTextI18n")
    private void playGames(){
        generationNumber();
        textViewArg.setText(randomNum1 + "+" + randomNum2);
        rightResult = randomNum1 + randomNum2;
        for(int i = 0; i < buttons.size(); i++){
            if(i == randomRightButton){
                buttons.get(i).setText(rightResult + "");
            }else{
                int wrong = generationWrong();
                buttons.get(i).setText(wrong + "");
            }
        }
    }

    private void generationNumber(){
        randomNum1 = (int)(Math.random() * 100);
        randomNum2 = (int)(Math.random() * 100);
        randomRightButton = (int)(Math.random() * 4);
    }
    private int generationWrong(){
        return (int)(Math.random() * 200);
    }

}