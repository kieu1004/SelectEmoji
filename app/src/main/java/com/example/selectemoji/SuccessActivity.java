package com.example.selectemoji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SuccessActivity extends AppCompatActivity {


    private String getEmoji(int unicode) {
        return new String(Character.toChars(unicode));
    }
    String emojiWow = getEmoji(0x1F631);
    String emojiClap = getEmoji(0x1F44F);
    Button playAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        TextView v = findViewById(R.id.emoji);
        v.setText(emojiWow+emojiClap+emojiWow);

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