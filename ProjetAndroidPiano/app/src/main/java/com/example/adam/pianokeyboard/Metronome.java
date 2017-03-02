package com.example.adam.pianokeyboard;

import android.content.Context;
import android.media.MediaPlayer;


public class Metronome extends Thread {
    private MediaPlayer metro;
    private Context context;
    private boolean stop = false;
    public Metronome(Context context){
        this.context = context;
    }
    @Override
    public void run() {
        super.run();
        playSound();
    }

    @Override
    public void interrupt() {
        super.interrupt();
        if(stop)
            metro.stop();
            metro.release();
    }

    public void playSound(){
        if(metro != null){
            metro.stop();
            metro.release();
        }
        metro= MediaPlayer.create(context,R.raw.metron);
        metro.start();
    }

    public void setStop(boolean stop){
        this.stop = stop;
    }
}
