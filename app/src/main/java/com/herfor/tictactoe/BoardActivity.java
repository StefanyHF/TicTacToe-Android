package com.herfor.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.security.AllPermission;

public class BoardActivity extends AppCompatActivity implements View.OnClickListener {

    String currentMark = "X";
    private MaterialButton[] buttons = new MaterialButton[9];
    private boolean isAi;
    private TextView player1;
    private TextView player2;
    private MaterialButton reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        Bundle bundle = getIntent().getExtras();
        isAi = bundle.getBoolean("ISAI");

        if (isAi) {
            currentMark = bundle.getString("START_ICON");
            startAiGame();
        }
        player1 = findViewById(R.id.text_player_1);
        player1.setText(bundle.getString("PLAYER1"));
        player2 = findViewById(R.id.text_player_2);
        player2.setText(bundle.getString("PLAYER2"));
        startFriendsGame();
    }

    private void startFriendsGame() {

        resetButton();
        for(int i = 0; i < buttons.length; i++)
            if(isTie()){
                Toast.makeText(BoardActivity.this, "Tie! Try again.", Toast.LENGTH_LONG).show();
            }
        if(!checkWinner()){
            setUpButtons();
        }else{
            if (currentMark.equals("X")) {
                Toast.makeText(BoardActivity.this, player1 + " you won!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(BoardActivity.this, player2 + " you won!", Toast.LENGTH_LONG).show();
            }
        }

    }

    private void setUpButtons() {
        for (int i = 0; i < buttons.length; i++) {
            String buttonID = "btn_" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = findViewById(resourceID);
            buttons[i].setOnClickListener(this);

        }
    }

    public void onClick(View v) {
        if (((MaterialButton) v).getText().toString().equals("")) {
            ((MaterialButton) v).setText(currentMark);
            switchPlayers();
        }
    }

    private boolean checkWinner() {
        boolean winnerResult = false;
        if (buttons[0].getText().equals(buttons[1].getText()) && buttons[0].getText().equals(buttons[2].getText()) && !buttons[0].getText().equals("") ||
                buttons[3].getText().equals(buttons[4].getText()) && buttons[3].getText().equals(buttons[5].getText()) && !buttons[3].getText().equals("") ||
                buttons[6].getText().equals(buttons[7].getText()) && buttons[6].getText().equals(buttons[8].getText()) && !buttons[6].getText().equals("") ||
                buttons[0].getText().equals(buttons[3].getText()) && buttons[0].getText().equals(buttons[6].getText()) && !buttons[0].getText().equals("") ||
                buttons[1].getText().equals(buttons[4].getText()) && buttons[1].getText().equals(buttons[7].getText()) && !buttons[1].getText().equals("") ||
                buttons[2].getText().equals(buttons[5].getText()) && buttons[2].getText().equals(buttons[8].getText()) && !buttons[2].getText().equals("") ||
                buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && !buttons[0].getText().equals("") ||
                buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && !buttons[2].getText().equals("")) {
            winnerResult = true;
        }
        return winnerResult;
    }

    private void switchPlayers() {
        if (currentMark.equals("X")) {
            currentMark = "O";
        } else {
            currentMark = "X";
        }
    }


    private void resetButton() {
        reset = findViewById(R.id.btn_reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(BoardActivity.this)
                        .setTitle("Are you sure?")
                        .setMessage("Clicking on the Reset button will delete all the current game's plays and the players' scores")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                for (int i = 0; i < buttons.length; i++) {
                                    buttons[i].setText("");
                                }
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();

            }
        });
    }

    private boolean isTie(){
        int count = 0;
        for(int i = 0; i < buttons.length; i++){
            if(!buttons[i].equals("")){
                count++;
            }
        }
        if(count == buttons.length -1){
            return true;
        }
        return false;
    }


    private void startAiGame() {


    }
}

