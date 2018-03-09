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

        items.add(new ItemGuide(getString(R.string.bar1_name), getString(R.string.bar1_loc),
                getString(R.string.bar1_hour), getString(R.string.bar1_hint),
                R.drawable.villa567));
        items.add(new ItemGuide(getString(R.string.bar2_name), getString(R.string.bar2_loc),
                getString(R.string.bar2_hour), getString(R.string.bar2_hint),
                R.drawable.justino));
        items.add(new ItemGuide(getString(R.string.bar3_name), getString(R.string.bar3_loc),
                getString(R.string.bar3_hour), getString(R.string.bar3_hint),
                R.drawable.gracia));
        items.add(new ItemGuide(getString(R.string.bar4_name), getString(R.string.bar4_loc),
                getString(R.string.bar4_hour), getString(R.string.bar4_hint),
                R.drawable.numero));
        items.add(new ItemGuide(getString(R.string.bar5_name), getString(R.string.bar5_loc),
                getString(R.string.bar5_hour), getString(R.string.bar5_hint),
                R.drawable.squat));
        items.add(new ItemGuide(getString(R.string.bar6_name), getString(R.string.bar6_loc),
                getString(R.string.bar6_hour), getString(R.string.bar6_hint),
                R.drawable.bla));
        items.add(new ItemGuide(getString(R.string.bar7_name), getString(R.string.bar7_loc),
                getString(R.string.bar7_hour), getString(R.string.bar7_hint),
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
