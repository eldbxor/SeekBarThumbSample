package com.example.taek.seekbarthumbsample;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    // private final int SEEKBAR_REQUEST_CODE = 1;
    private int lastProgress = 7;
    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void makeToast(String str) {
        Toast.makeText(this, "" + str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewInDialog = inflater.inflate(R.layout.activity_seekbar_dialog, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.customTheme);
        builder.setView(viewInDialog);
        /*builder.setNegativeButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        makeToast("" + lastProgress);
                    }
                }, 100);
                dialogInterface.dismiss();
            }
        });*/

        final SeekBar mSeekBar = viewInDialog.findViewById(R.id.seekbar);
/*
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
*/

        final Button dialogConfirmButton = viewInDialog.findViewById(R.id.confirm_button);
        dialogConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lastProgress = mSeekBar.getProgress() + 1;
                makeToast("" + lastProgress);
                dialog.dismiss();
            }
        });

        final ImageView closeImgButton = viewInDialog.findViewById(R.id.action_bar_close_img);
        closeImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog = builder.show();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                mSeekBar.setProgress(lastProgress);
            }
        });
    }
    /*
    @Override
    public void onClick(View view) {
        Intent seekBarDialogIntent = new Intent(MainActivity.this, SeekBarDialog.class);
        startActivityForResult(seekBarDialogIntent, SEEKBAR_REQUEST_CODE);
    }
*/
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case SEEKBAR_REQUEST_CODE:
                int progress = data.getIntExtra("progress", 7);
                Toast.makeText(MainActivity.this, "progress: " + progress, Toast.LENGTH_SHORT).show();
                break;
        }
    }*/
}
