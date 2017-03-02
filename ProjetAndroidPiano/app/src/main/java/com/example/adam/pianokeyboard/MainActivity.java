package com.example.adam.pianokeyboard;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    private HashMap<Key,Integer> keyboard = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setKeyboard();
        Intent intent = getIntent();
        int frequency = intent.getIntExtra("freq", 1000);
        int duree = intent.getIntExtra("duree",5000);


        for(final Key k : keyboard.keySet()){
            k.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    k.playSound(keyboard.get(k));

                }


            });
        }
        playMetronome(duree,frequency);



    }
    private void playMetronome(int timeToRepeat,int frequency){
        final Metronome metronome = new Metronome(this);
        new CountDownTimer(timeToRepeat,frequency) {
            @Override
            public void onTick(long millisUntilFinished) {
                metronome.run();
            }

            @Override
            public void onFinish() {
            }
        }.start();


    }
    private void setKeyboard(){
        keyboard.put((WhiteKey) findViewById(R.id.white),R.raw.c4);
        keyboard.put((WhiteKey) findViewById(R.id.white1),R.raw.d4);
        keyboard.put((WhiteKey) findViewById(R.id.white2),R.raw.e4);
        keyboard.put((WhiteKey) findViewById(R.id.white3),R.raw.f4);
        keyboard.put((WhiteKey) findViewById(R.id.white4),R.raw.g4);
        keyboard.put((WhiteKey) findViewById(R.id.white5),R.raw.a4);
        keyboard.put((WhiteKey) findViewById(R.id.white6),R.raw.b4);
        keyboard.put((WhiteKey) findViewById(R.id.white7),R.raw.c5);
        keyboard.put((WhiteKey) findViewById(R.id.white8),R.raw.d5);
        keyboard.put((WhiteKey) findViewById(R.id.white9),R.raw.e5);
        keyboard.put((WhiteKey) findViewById(R.id.white10),R.raw.f5);
        keyboard.put((WhiteKey) findViewById(R.id.white11),R.raw.a5);
        keyboard.put((WhiteKey) findViewById(R.id.white12),R.raw.b5);
        keyboard.put((WhiteKey) findViewById(R.id.white13),R.raw.c6);
        keyboard.put((WhiteKey) findViewById(R.id.white14),R.raw.d6);
        keyboard.put((WhiteKey) findViewById(R.id.white15),R.raw.e6);
        keyboard.put((WhiteKey) findViewById(R.id.white16),R.raw.f6);
        keyboard.put((WhiteKey) findViewById(R.id.white17),R.raw.g6);
        keyboard.put((WhiteKey) findViewById(R.id.white18),R.raw.a6);
        keyboard.put((WhiteKey) findViewById(R.id.white19),R.raw.b6);
        keyboard.put((WhiteKey) findViewById(R.id.white20),R.raw.c7);
        keyboard.put((WhiteKey) findViewById(R.id.white21),R.raw.d7);
        keyboard.put((WhiteKey) findViewById(R.id.white22),R.raw.f7);
        keyboard.put((WhiteKey) findViewById(R.id.white23),R.raw.g7);
        keyboard.put((WhiteKey) findViewById(R.id.white24),R.raw.a7);
        keyboard.put((BlackKey) findViewById(R.id.black),R.raw.cdiez4);
        keyboard.put((BlackKey) findViewById(R.id.black2),R.raw.ddiez4);
        keyboard.put((BlackKey) findViewById(R.id.black3),R.raw.fdiez4);
        keyboard.put((BlackKey) findViewById(R.id.black4),R.raw.gdiez4);
        keyboard.put((BlackKey) findViewById(R.id.black5),R.raw.adiez4);
        keyboard.put((BlackKey) findViewById(R.id.black6),R.raw.cdiez5);
        keyboard.put((BlackKey) findViewById(R.id.black7),R.raw.ddiez5);
        keyboard.put((BlackKey) findViewById(R.id.black8),R.raw.gdiez5);
        keyboard.put((BlackKey) findViewById(R.id.black9),R.raw.adiez5);
        keyboard.put((BlackKey) findViewById(R.id.black10),R.raw.cdiez6);
        keyboard.put((BlackKey) findViewById(R.id.black11),R.raw.ddiez6);
        keyboard.put((BlackKey) findViewById(R.id.black12),R.raw.fdiez6);
        keyboard.put((BlackKey) findViewById(R.id.black13),R.raw.gdiez6);
        keyboard.put((BlackKey) findViewById(R.id.black14),R.raw.adiez6);
        keyboard.put((BlackKey) findViewById(R.id.black15),R.raw.cdiez7);
        keyboard.put((BlackKey) findViewById(R.id.black16),R.raw.ddiez7);
        keyboard.put((BlackKey) findViewById(R.id.black17),R.raw.fdiez7);
        keyboard.put((BlackKey) findViewById(R.id.black18),R.raw.gdiez7);
    }
}