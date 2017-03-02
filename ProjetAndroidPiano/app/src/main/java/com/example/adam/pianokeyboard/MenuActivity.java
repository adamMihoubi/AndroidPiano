package com.example.adam.pianokeyboard;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MenuActivity extends AppCompatActivity {
    private TextView textDuration, textFrequancy;
    private SeekBar seekDuration, seekFrequancy;
    private int frequency;
    private int duree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Button playpiano = (Button) findViewById(R.id.play);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        seekDuration = (SeekBar) findViewById(R.id.duration);
        seekFrequancy = (SeekBar) findViewById(R.id.frequency);
        textDuration = (TextView) findViewById(R.id.textduration);
        textFrequancy = (TextView) findViewById(R.id.textfrequency);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox.isChecked()) {
                    seekDuration.setVisibility(View.VISIBLE);
                    seekFrequancy.setVisibility(View.VISIBLE);
                    textDuration.setVisibility(View.VISIBLE);
                    textFrequancy.setVisibility(View.VISIBLE);
                }
                if (!isChecked) {
                    seekDuration.setVisibility(View.GONE);
                    seekFrequancy.setVisibility(View.GONE);
                    textDuration.setVisibility(View.GONE);
                    textFrequancy.setVisibility(View.GONE);
                }
            }
        });
        seekDuration.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textDuration.setText(progress / 1000 + " s");
                duree = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        seekFrequancy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textFrequancy.setText(progress / 1000 + " s");
                frequency = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        final Intent intent = new Intent(this,MainActivity.class);
        playpiano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("duree",duree);
                intent.putExtra("freq",frequency);
                startActivity(intent);
            }
        });




    }

    public TextView getTextDuration(){
        return this.textDuration;
    }
    public TextView getTextFrequancy(){
        return this.textFrequancy;
    }
    public SeekBar getSeekDuration(){
        return this.seekDuration;
    }
    public SeekBar getSeekFrequancy(){
        return this.seekFrequancy;
    }
}
