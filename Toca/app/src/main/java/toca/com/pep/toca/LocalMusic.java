package toca.com.pep.toca;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocalMusic extends Fragment {

    public static LocalMusic newInstance() {
        LocalMusic fragment = new LocalMusic();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_local_music, container, false);

        Log.i("LocalMusic:", "onCreateView() called");

        try {
            // Set image
            String res = this.getArguments().getString("resource").replace("id", "drawable");
            String text = res.replace("drawable", "string");
            String idRes = res.split("/")[1];
            String resDrawable;
            switch(idRes) {
                case "lm_1":
                    resDrawable = res.replace("lm_1","metallica");
                    text = text.replace("lm_1", "text_metallica");
                    break;
                case "lm_2":
                    resDrawable = res.replace("lm_2","paramore");
                    text = text.replace("lm_2", "text_paramore");
                    break;
                case "lm_3":
                    resDrawable = res.replace("lm_3","jcole");
                    text = text.replace("lm_3", "text_jcole");
                    break;
                default:
                    resDrawable = res;
                    break;
            }

            // Set image resource
            ImageView iView = v.findViewById(R.id.lm_star);
            Log.i("LocalMusic:", "resDrawable = " + resDrawable);
            int id = v.getResources().getIdentifier(resDrawable, null, null);
            iView.setImageResource(id);

            // Set text resource
            TextView tView = v.findViewById(R.id.text_lm);
            Log.i("LocalMusic:", "text = " + text);
            id = v.getResources().getIdentifier(text, null, null);
            tView.setText(id);


        } catch (Exception e) {
            if (this.getArguments() == null) {
                Log.i("LocalMusic:", "bundle is null again...");
            } else {
                Log.i("LocalMusic:", "we better run bro");
            }
        }

        return v;
    }
}
