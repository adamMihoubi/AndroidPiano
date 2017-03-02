package com.example.adam.pianokeyboard;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/**
 * Created by adam on 20/02/2016.
 */
public abstract class Key extends Button{
    protected MediaPlayer note;



    protected Key(Context context){
        super(context);
    }
    protected Key(Context context,AttributeSet attributeSet){
        super(context,attributeSet);
    }
    protected Key(Context context,AttributeSet attributeSet, int defStyle){
        super(context,attributeSet,defStyle);
    }

    public void playSound(int id){
        if(note != null){
            note.stop();
            note.release();
        }
        note= MediaPlayer.create(this.getContext(),id);
        note.start();
    }


}
