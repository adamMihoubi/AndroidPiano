package com.example.adam.pianokeyboard;

import android.os.AsyncTask;
import android.view.View;

/**
 * Created by adam on 01/03/2016.
 */
public class Progress extends AsyncTask<Integer, Integer, Void> {

    private OpeningActivity openingActivity;


    public Progress(OpeningActivity openingActivity){
        super();
        this.openingActivity = openingActivity;
    }




    @Override
    protected void onProgressUpdate(Integer... i){
        super.onProgressUpdate(i);
        openingActivity.getProgressBar().setProgress(i[0]);
    }


    @Override
    protected Void doInBackground(Integer... params) {

        for (int i=params[0];i>=0;i--) {
            publishProgress(i);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid){
        openingActivity.getTextView().setText("Done !");
        openingActivity.getButton().setVisibility(View.VISIBLE);
        openingActivity.getProgressBar().setVisibility(View.GONE);

    }
}
