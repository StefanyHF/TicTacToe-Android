package com.herfor.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

   // public static final boolean IS_AI = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpButtonFriend();
        setUpButtonAi();
    }

    private void setUpButtonFriend() {

        MaterialButton buttonFriend = findViewById(R.id.button_friend);

        buttonFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayersActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setUpButtonAi() {

       MaterialButton buttonAi = findViewById(R.id.button_ai);

        buttonAi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SideActivity.class);
                startActivity(intent);
            }
        });
    }
}