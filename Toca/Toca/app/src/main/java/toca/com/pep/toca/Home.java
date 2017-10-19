package toca.com.pep.toca;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    public static Home newInstance() {
        Home fragment = new Home();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);

        /*
        // Setting onClickListener for all images on LocalMusic Bar
        ImageView img = (ImageView) homeView.findViewById(R.id.lm_1);
        img.setOnClickListener(this);

        img = (ImageView) homeView.findViewById(R.id.lm_2);
        img.setOnClickListener(this);

        img = (ImageView) homeView.findViewById(R.id.lm_3);
        img.setOnClickListener(this);

        img = (ImageView) homeView.findViewById(R.id.st_1);
        img.setOnClickListener(this);

        img = (ImageView) homeView.findViewById(R.id.st_2);
        img.setOnClickListener(this);

        img = (ImageView) homeView.findViewById(R.id.st_3);
        img.setOnClickListener(this);
        */
    }
}
