package com.pep.android.spguide;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by pep on 03/01/18.
 */

public class BarsActivity extends AppCompatActivity {

    private String TAG = "BarsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_list);

        // Array of english items 1-10
        final ArrayList<ItemGuide> items = new ArrayList<ItemGuide>();

        items.add(new ItemGuide("Villa 567", "Villa Madalena",
                "18-04", "Awesome rooftop",
                R.drawable.villa567));
        items.add(new ItemGuide("Villa Seu Justino", "Villa Madalena",
                "18-Last Client", "Samba place",
                R.drawable.justino));
        items.add(new ItemGuide("Grácia Bar", "Pinheiros",
                "22-03", "Great for flirting",
                R.drawable.gracia));
        items.add(new ItemGuide("Bar Número", "Consolação",
                "19-05", "Classy environment",
                R.drawable.numero));
        items.add(new ItemGuide("Squat Bar", "Jardins",
                "21-05", "Different spaces and musics",
                R.drawable.squat));
        items.add(new ItemGuide("Blá Bar & Grill", "Itaim Bibi",
                "18-03", "Intimate lightning",
                R.drawable.bla));
        items.add(new ItemGuide("Trabuca Bar", "Itaim Bibi",
                "18-03", "Pop art decoration",
                R.drawable.trabuca));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        ItemGuideAdapter adapter = new ItemGuideAdapter(this, items, R.color.category_bars);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_listyout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of items.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);
    }

}
