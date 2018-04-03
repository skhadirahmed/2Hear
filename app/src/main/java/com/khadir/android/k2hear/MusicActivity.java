package com.khadir.android.k2hear;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MusicActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2;
    private Button play, replay, pause, stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        //todo i removed raw files

//        play = (Button) findViewById(R.id.play);
//        replay = (Button) findViewById(R.id.replay);
//        pause = (Button) findViewById(R.id.pause);
//        stop = (Button) findViewById(R.id.stop);
//
////        mediaPlayer = MediaPlayer.create(this, R.raw.sugar);
////        mediaPlayer2 = MediaPlayer.create(this, R.raw.ispy);
//        mediaPlayer = MediaPlayer.create(this, R.raw.vachinde);
//        mediaPlayer2 = MediaPlayer.create(this, R.raw.afghan);
//        mediaPlayer.setVolume(0, 1);
//        mediaPlayer2.setVolume(1, 0);
//
//        play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mediaPlayer.start();
//                mediaPlayer2.start();
//                Toast.makeText(getApplicationContext(), "playing audio", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        pause.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mediaPlayer.pause();
//                mediaPlayer2.pause();
//                Toast.makeText(getApplicationContext(), "pausing audio", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        replay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mediaPlayer.reset();
//                mediaPlayer2.reset();
//
//                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.vachinde);
//                mediaPlayer2 = MediaPlayer.create(getApplicationContext(), R.raw.afghan);
//                mediaPlayer.setVolume(0, 1);
//                mediaPlayer2.setVolume(1, 0);
//
//                mediaPlayer.start();
//                mediaPlayer2.start();
//
//                Toast.makeText(getApplicationContext(), "playing audio from start", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        stop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"Stoping audio",Toast.LENGTH_SHORT).show();
//                mediaPlayer.stop();
//                mediaPlayer2.stop();
//            }
//        });
//
//        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//                Toast.makeText(getApplicationContext(), "I'm done", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
