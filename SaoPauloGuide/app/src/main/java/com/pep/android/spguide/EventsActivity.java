package com.pep.android.spguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by pep on 03/01/18.
 */

public class EventsActivity extends AppCompatActivity {

    private String TAG = "EventsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_list);

        // Array of english items 1-10
        final ArrayList<ItemGuide> items = new ArrayList<ItemGuide>();

        items.add(new ItemGuide(getString(R.string.eve1_name), getString(R.string.eve1_loc),
                getString(R.string.eve1_hour), getString(R.string.eve1_hint),
                R.drawable.cannoli));
        items.add(new ItemGuide(getString(R.string.eve2_name), getString(R.string.eve2_loc),
                getString(R.string.eve2_hour), getString(R.string.eve2_hint),
                R.drawable.carnival));
        items.add(new ItemGuide(getString(R.string.eve3_name), getString(R.string.eve3_loc),
                getString(R.string.eve3_hour), getString(R.string.eve3_hint),
                R.drawable.vegan));
        items.add(new ItemGuide(getString(R.string.eve4_name), getString(R.string.eve4_loc),
                getString(R.string.eve4_hour), getString(R.string.eve4_hint),
                R.drawable.depardon));
        items.add(new ItemGuide(getString(R.string.eve5_name), getString(R.string.eve5_loc),
                getString(R.string.eve5_hour), getString(R.string.eve5_hint),
                R.drawable.box));
        items.add(new ItemGuide(getString(R.string.eve6_name), getString(R.string.eve6_loc),
                getString(R.string.eve6_hour), getString(R.string.eve6_hint),
                R.drawable.russo));
        items.add(new ItemGuide(getString(R.string.eve7_name), getString(R.string.eve7_loc),
                getString(R.string.eve7_hour), getString(R.string.eve7_hint),
                R.drawable.lmusical));
        items.add(new ItemGuide(getString(R.string.eve8_name), getString(R.string.eve8_loc),
                getString(R.string.eve8_hour), getString(R.string.eve8_hint),
                R.drawable.cavalcanti));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        ItemGuideAdapter adapter = new ItemGuideAdapter(this, items, R.color.category_events);

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
