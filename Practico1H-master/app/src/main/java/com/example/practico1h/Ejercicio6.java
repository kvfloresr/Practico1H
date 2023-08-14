package com.example.practico1h;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio6 extends AppCompatActivity {

    private EditText editTextSongs;
    private TextView textViewStatus;

    private Handler handler = new Handler();

    private List<String> songList = new ArrayList<>();
    private int currentSongIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej6);

        editTextSongs = findViewById(R.id.editTextSongs);
        textViewStatus = findViewById(R.id.textViewStatus);
    }

    public void playSongs(View view) {
        String songsInput = editTextSongs.getText().toString();
        songList = Arrays.asList(songsInput.split(","));

        playNextSong();
    }

    private void playNextSong() {
        if (currentSongIndex < songList.size()) {
            final String songName = songList.get(currentSongIndex);

            textViewStatus.setText("Reproduciendo: " + songName);

            // Simulate song playback
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    currentSongIndex++;
                    playNextSong();
                }
            }, 2000); // Simulate song duration (2 seconds)

        } else {
            textViewStatus.setText("Reproducción finalizada");
        }
    }
}
