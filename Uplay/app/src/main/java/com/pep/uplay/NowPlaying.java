package com.pep.uplay;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class NowPlaying extends AppCompatActivity {

    // Default loaded
    private String loadedSong = "/Music/Paramore.mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);


        Log.i("NowPlaying:", "createPlayer() called");

        try {
            // Set image
            Intent intent = getIntent();
            String res = intent.getStringExtra(LocalMusic.EXTRA_MESSAGE)
                    .replace("id", "drawable");

            String text = res.replace("drawable", "string");
            String idRes = res.split("/")[1];
            String resMusic;
            String resDrawable;

            if(idRes.equals("lm_1")) {
                resMusic = "/Music/Metallica.mp3";
                resDrawable = res.replace("lm_1","metallica");
                text = text.replace("lm_1", "m_desc");
            } else if(idRes.equals("lm_2")) {
                resMusic = "/Music/Paramore.mp3";
                resDrawable = res.replace("lm_2","paramore");
                text = text.replace("lm_2", "p_desc");
            } else {
                resMusic = "/Music/JCole.mp3";
                resDrawable = res.replace("lm_3","jcole");
                text = text.replace("lm_3", "j_desc");
            }

            Log.i("NowPlaying:", "resMusic: " + resMusic);
            Log.i("NowPlaying:", "idRes: " + idRes);
            Log.i("NowPlaying:", "text: " + text);

            // Set loaded song
            loadedSong = resMusic;

            // Set image resource
            ImageView iView = findViewById(R.id.lm_star);
            int id = getResources().getIdentifier(resDrawable, null, null);
            iView.setImageResource(id);

            // Set text resource
            TextView tView = findViewById(R.id.text_lm);
            id = getResources().getIdentifier(text, null, null);
            tView.setText(id);

            // Get permission for storage
            if(ContextCompat.checkSelfPermission(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                // Request permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        1);
            }

        } catch (NullPointerException e) {
            Log.i("NowPlaying", "Null bundle");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_lm) {
            Intent intent = new Intent(this, LocalMusic.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_st) {
            Intent intent = new Intent(this, Store.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void createPlayer(View v) {

        Log.i("NowPlaying:", "createPlayer() called");

        try {
            String filePath = Environment.getExternalStorageDirectory()+loadedSong;

            MediaPlayer mediaPlayer = new  MediaPlayer();
            mediaPlayer.setDataSource(filePath);
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {
            Log.i("NowPlaying:", "IOException");
            //throw new RuntimeException(e);
        } catch (NullPointerException e) {
            Log.i("NowPlaying", "Null bundle");
            throw new RuntimeException(e);
        }
    }

}