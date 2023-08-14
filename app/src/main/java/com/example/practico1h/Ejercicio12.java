package com.example.practico1h;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

public class Ejercicio12 extends AppCompatActivity {

    private TextView videoInfoTextView;
    private TextView playbackStatusTextView;

    private boolean isPlaying = false;
    private int currentTime = 0;

    private Handler handler;
    private Runnable updateUIRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej12);

        videoInfoTextView = findViewById(R.id.videoInfoTextView);
        playbackStatusTextView = findViewById(R.id.playbackStatusTextView);

        handler = new Handler(Looper.getMainLooper());

        updateUIRunnable = new Runnable() {
            @Override
            public void run() {
                updateUI();
                if (isPlaying) {
                    currentTime += 1;
                }
                handler.postDelayed(this, 1000); // Update UI every 1 second
            }
        };

        // Start updating UI
        handler.post(updateUIRunnable);

        // Simulate starting playback
        isPlaying = true;
    }

    private void updateUI() {
        videoInfoTextView.setText("Current Time: " + currentTime + " seconds");
        playbackStatusTextView.setText("Playback Status: " + (isPlaying ? "Playing" : "Paused"));
    }

    public void togglePlayback(View view) {
        isPlaying = !isPlaying;
        updateUI();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove callbacks to avoid memory leaks
        handler.removeCallbacks(updateUIRunnable);
    }
}
