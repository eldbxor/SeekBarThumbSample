package com.example.taek.seekbarthumbsample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private final int SEEKBAR_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        Intent seekBarDialogIntent = new Intent(MainActivity.this, SeekBarDialog.class);
        startActivityForResult(seekBarDialogIntent, SEEKBAR_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case SEEKBAR_REQUEST_CODE:
                int progress = data.getIntExtra("progress", 7);
                Toast.makeText(MainActivity.this, "progress: " + progress, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
