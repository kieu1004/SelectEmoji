package com.example.selectemoji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    GridView myGridView;
    final int total = 0x1F622;
    int unicode = 0x1F600;
    int wrongClick = 0;
    int point = 0;
    private String getEmoji(int unicode) {
        return new String(Character.toChars(unicode));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Hiển thị Emoji chính
        final TextView[] v = {findViewById(R.id.mainEmoji)};

        int mainEmoji = ThreadLocalRandom.current().nextInt(0x1F600, 0x1F620);
        final String[] res = {getEmoji(mainEmoji)}; //Biến xuất hiện Emoji cần chọn
        v[0].setText(res[0]);

        //Hiển thị 30 emoji
        myGridView = findViewById(R.id.myGridView);
        List data= new ArrayList(); //Mảng lưu Emoji để chọn
        for(int i = 0; i<=29; i++){
            String emoji = getEmoji(unicode);
            unicode ++;
            data.add(emoji);
            Collections.shuffle(data);
        }

        MyAdapter myAdapter = new MyAdapter(getApplicationContext(),R.layout.items, data);
        myGridView.setAdapter(myAdapter);
        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView vSelected = (TextView) view;
                String selected = vSelected.getText().toString();

                if(selected.equals(res[0])){
                    data.remove(res[0]);
                    data.add("");
                    vSelected.setText("");
                    Toast.makeText(getApplicationContext(), " Thật khó tin!!! ",
                            Toast.LENGTH_LONG).show();
                    while (data.contains(res[0]) == false) {
                        int randEmoji = ThreadLocalRandom.current().nextInt(0x1F600, 0x1F622);
                        res[0] = getEmoji(randEmoji);
                    }
                        v[0].setText(res[0]);
                    point++;
                    if (point == 29){
                        //success - startActivity
                        Intent intent = new Intent(getApplicationContext(), SuccessActivity.class);
                        startActivity(intent);
                    }
                }else {
                    wrongClick++;
                    TextView lives = findViewById(R.id.lives);
                    lives.setText("Bạn còn "+ (3-wrongClick) +" lần click sai");
                    if (wrongClick <=3) {
                        Toast.makeText(getApplicationContext(), "Sai rồi! Còn lại: " + (3 - wrongClick) + " lần =((",
                                Toast.LENGTH_LONG).show();
                    }
                    else {
                        //failed - startActivity
                        Intent intent = new Intent(getApplicationContext(), FailActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}