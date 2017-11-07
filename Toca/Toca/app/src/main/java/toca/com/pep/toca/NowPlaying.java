package toca.com.pep.toca;


import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class NowPlaying extends Fragment {


    public static NowPlaying newInstance() {
        NowPlaying fragment = new NowPlaying();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_now_playing, container, false);
        createPlayer(v);

        return v;
    }

    private void createPlayer(View v) {

        Log.i("NowPlaying:", "createPlayer() called");

        try {
            // Set image
            String res = this.getArguments().getString("resource").replace("id", "drawable");
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

            // Set image resource
            ImageView iView = v.findViewById(R.id.lm_star);
            int id = v.getResources().getIdentifier(resDrawable, null, null);
            iView.setImageResource(id);

            // Set text resource
            TextView tView = v.findViewById(R.id.text_lm);
            id = v.getResources().getIdentifier(text, null, null);
            tView.setText(id);

            // Get permission for storage
             if(ContextCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                 // Request permission
                 ActivityCompat.requestPermissions(getActivity(),
                         new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                         1);
             }

            String filePath = Environment.getExternalStorageDirectory()+resMusic;

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
