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
public class Store extends Fragment {

    public static Store newInstance() {
        Store fragment = new Store();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_store, container, false);

        try {
            // Set image
            String res = this.getArguments().getString("resource").replace("id", "drawable");
            String text = res.replace("drawable", "string");
            String idRes = res.split("/")[1];
            String resDrawable;
            switch(idRes) {
                case "st_1":
                    resDrawable = res.replace("st_1", "paramore");
                    text = text.replace("st_1", "text_paramore");
                    break;
                case "st_2":
                    resDrawable = res.replace("st_2", "jcole");
                    text = text.replace("st_2", "text_jcole");
                    break;
                case "st_3":
                    resDrawable = res.replace("st_3", "metallica");
                    text = text.replace("st_3", "text_metallica");
                    break;
                default:
                    resDrawable = res;
                    break;
            }

            // Set image resource
            ImageView iView = v.findViewById(R.id.st_star);
            int id = v.getResources().getIdentifier(resDrawable, null, null);
            iView.setImageResource(id);

            Log.i("Store", "text: " + text);
            // Set text resource
            TextView tView = v.findViewById(R.id.text_st);
            id = v.getResources().getIdentifier(text, null, null);
            tView.setText(id);


        } catch (Exception e) {
            if (this.getArguments() == null) {
                Log.i("Store:", "bundle is null again...");
            } else {
                Log.i("Store:", "we better run bro");
            }
        }

        return v;
    }
}
