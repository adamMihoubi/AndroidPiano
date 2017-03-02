package com.example.adam.pianokeyboard;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class OpeningActivity extends AppCompatActivity {
    private OpeningActivity openingActivity = this;
    private ProgressBar progressBar;
    private TextView textView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.textView);
        progressBar.setMax(200);
        Progress p = new Progress(openingActivity);
        p.execute(200);
        button = (Button)findViewById(R.id.button);


        final Intent intent = new Intent(this,MenuActivity.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });



    }

    public ProgressBar getProgressBar(){
        return this.progressBar;
    }
    public Button getButton(){
        return this.button;
    }
    public TextView getTextView(){

        return this.textView;
    }
}
