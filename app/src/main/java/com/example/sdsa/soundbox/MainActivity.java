package com.example.sdsa.soundbox;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    private Button playButton;
    private Button prevButton;
    private Button nextButton;
    private MediaPlayer mediaPlayer;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.my_lord);

        text = (TextView) findViewById(R.id.artistName);

        playButton = (Button) findViewById(R.id.playButton);
        prevButton = (Button) findViewById(R.id.prevButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        playButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.playButton:
                //play music
                if (mediaPlayer.isPlaying()) {
                    pauseMusic();
                } else {
                    playMusic();
                }
                break;

            case R.id.prevButton:
                //prev
                break;

            case R.id.nextButton:
                //next
                break;
        }
    }

    public void playMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            text.setText("Music Playing now...");
            playButton.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_pause));
        }
    }

    public void pauseMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            text.setText("Music Paused!");
            playButton.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_play));
        }
    }

    public void prevMusic() {
        if (mediaPlayer != null) {

        }
    }

    public void nextMusic() {
        if (mediaPlayer != null) {

        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
