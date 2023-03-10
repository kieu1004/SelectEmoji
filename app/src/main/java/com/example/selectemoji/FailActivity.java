package com.example.selectemoji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FailActivity extends AppCompatActivity {

    int unicode = 0x1F62D;
    private String getEmoji(int unicode) {
        return new String(Character.toChars(unicode));
    }
    String emoji = getEmoji(unicode);
    Button playAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);
        TextView v = findViewById(R.id.emoji);
        v.setText(emoji+emoji+emoji);

        playAgain = findViewById(R.id.btn_playAgain);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
            }
        });
    }
}