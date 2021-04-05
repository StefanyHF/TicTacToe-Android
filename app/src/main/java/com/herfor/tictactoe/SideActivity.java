package com.herfor.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.google.android.material.button.MaterialButton;

import java.util.Scanner;

public class SideActivity extends AppCompatActivity {
    private RadioButton x;
    private RadioButton o;
    private MaterialButton btnContinue;
    private String startIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side);
        radioButtonsSwitch();
        setUpContinueButton();
    }

    private void setUpContinueButton() {
        btnContinue = findViewById(R.id.continue_button);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SideActivity.this, BoardActivity.class);
                intent.putExtra("START_ICON", startIcon);
                intent.putExtra( "ISAI", true);
                startActivity(intent);
            }
        });
    }

    private void radioButtonsSwitch() {
        x = findViewById(R.id.radio_button_x);
        o = findViewById(R.id.radio_button_o);

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (x.isChecked()) {
                    o.setChecked(false);
                    startIcon = "X";
                }
            }
        });
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (o.isChecked()) {
                    x.setChecked(false);
                    startIcon = "O";
                }
            }
        });


    }

}
