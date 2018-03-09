package com.pep.android.spguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by pep on 03/01/18.
 */

public class AttractionsActivity extends AppCompatActivity {

    private String TAG = "AttractionsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_list);

        // Array of english items 1-10
        final ArrayList<ItemGuide> items = new ArrayList<ItemGuide>();

        items.add(new ItemGuide(getString(R.string.att1_name), getString(R.string.att1_loc),
                getString(R.string.att1_hour), getString(R.string.att1_hint),
                R.drawable.ibirapuera));
        items.add(new ItemGuide(getString(R.string.att2_name), getString(R.string.att2_loc),
                getString(R.string.att2_hour), getString(R.string.att2_hint),
                R.drawable.pinacoteca));
        items.add(new ItemGuide(getString(R.string.att3_name), getString(R.string.att3_loc),
                getString(R.string.att3_hour), getString(R.string.att3_hint),
                R.drawable.paulista));
        items.add(new ItemGuide(getString(R.string.att4_name), getString(R.string.att4_loc),
                getString(R.string.att4_hour), getString(R.string.att4_hint),
                R.drawable.catavento));
        items.add(new ItemGuide(getString(R.string.att5_name), getString(R.string.att5_loc),
                getString(R.string.att5_hour), getString(R.string.att5_hint),
                R.drawable.ccbb));
        items.add(new ItemGuide(getString(R.string.att6_name), getString(R.string.att6_loc),
                getString(R.string.att6_hour), getString(R.string.att6_hint),
                R.drawable.theatre));
        items.add(new ItemGuide(getString(R.string.att7_name), getString(R.string.att7_loc),
                getString(R.string.att7_hour), getString(R.string.att7_hint),
                R.drawable.football));
        items.add(new ItemGuide(getString(R.string.att8_name), getString(R.string.att8_loc),
                getString(R.string.att8_hour), getString(R.string.att8_hint),
                R.drawable.masp));
        items.add(new ItemGuide(getString(R.string.att9_name), getString(R.string.att9_loc),
                getString(R.string.att9_hour), getString(R.string.att9_hint),
                R.drawable.market));
        items.add(new ItemGuide(getString(R.string.att10_name), getString(R.string.att10_loc),
                getString(R.string.att10_hour), getString(R.string.att10_hint),
                R.drawable.garden));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        ItemGuideAdapter adapter = new ItemGuideAdapter(this, items, R.color.category_attractions);

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
