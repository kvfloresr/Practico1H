package com.example.practico1h;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ejercicio16 extends AppCompatActivity {
    private Button playButton, stopButton;
    private MediaPlayer mediaPlayer;
    private TextView timeTextView;
    private Handler handler;
    private Runnable updateSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej16);

        playButton = findViewById(R.id.playButton);
        stopButton = findViewById(R.id.stopButton);
        timeTextView = findViewById(R.id.timeTextView); // Initialize TextView

        mediaPlayer = MediaPlayer.create(this, R.raw.sample_music);
        handler = new Handler();
        updateSeekBar = new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    int progress = mediaPlayer.getCurrentPosition();
                    updateTimeTextView(progress); // Update time on TextView
                    handler.postDelayed(this, 1000);
                }
            }
        };

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                handler.postDelayed(updateSeekBar, 0);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                handler.removeCallbacks(updateSeekBar);
            }
        });
    }

    private void updateTimeTextView(int progress) {
        int seconds = progress / 1000;
        int minutes = seconds / 60;
        seconds %= 60;
        timeTextView.setText(String.format("%02d:%02d", minutes, seconds));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        handler.removeCallbacks(updateSeekBar);
    }
}