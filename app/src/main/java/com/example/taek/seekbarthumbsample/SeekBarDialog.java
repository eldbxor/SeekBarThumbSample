package com.example.taek.seekbarthumbsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

/**
 * Created by Taek on 2017-12-28.
 */

/***************************************************************************************************
 *                                         사용하지 않음                                           *
 ***************************************************************************************************/
public class SeekBarDialog extends Activity implements View.OnClickListener {
    private final int SEEKBAR_REQUEST_CODE = 1;
    private SeekBar seekBar;
    private int lastProgress = 7;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar_dialog);

        seekBar = (SeekBar) findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lastProgress = progress + 1;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("progress", lastProgress);
        setResult(SEEKBAR_REQUEST_CODE, resultIntent);
        finish();
    }
}
