package com.herfor.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class PlayersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        setUpContinueButton();
    }

    private void setUpContinueButton() {
        TextInputEditText player1 = findViewById(R.id.text_input_1);
        TextInputEditText player2 = findViewById(R.id.text_input_2);

        MaterialButton btnContinue = findViewById(R.id.continue_button2);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayersActivity.this, BoardActivity.class);
                intent.putExtra("ISAI", false);
                intent.putExtra("PLAYER1", player1.getText().toString());
                intent.putExtra("PLAYER2", player2.getText().toString());
                startActivity(intent);
            }
        });
    }
}