package com.pep.android.spguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by pep on 03/01/18.
 */

public class RestaurantsActivity extends AppCompatActivity {

    private String TAG = "RestaurantActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_list);

        // Array of english items 1-10
        final ArrayList<ItemGuide> items = new ArrayList<ItemGuide>();

        items.add(new ItemGuide(getString(R.string.res1_name), getString(R.string.res1_loc),
                getString(R.string.res1_hour), getString(R.string.res1_hint),
                R.drawable.mani));
        items.add(new ItemGuide(getString(R.string.res2_name), getString(R.string.res2_loc),
                getString(R.string.res2_hour), getString(R.string.res2_hint),
                R.drawable.tordesilhas));
        items.add(new ItemGuide(getString(R.string.res3_name), getString(R.string.res3_loc),
                getString(R.string.res3_hour), getString(R.string.res3_hint),
                R.drawable.aizome));
        items.add(new ItemGuide(getString(R.string.res4_name), getString(R.string.res4_loc),
                getString(R.string.res4_hour), getString(R.string.res4_hint),
                R.drawable.rascal));
        items.add(new ItemGuide(getString(R.string.res5_name), getString(R.string.res5_loc),
                getString(R.string.res5_hour), getString(R.string.res5_hint),
                R.drawable.peti));
        items.add(new ItemGuide(getString(R.string.res6_name), getString(R.string.res6_loc),
                getString(R.string.res6_hour), getString(R.string.res6_hint),
                R.drawable.varanda));
        items.add(new ItemGuide(getString(R.string.res7_name), getString(R.string.res7_loc),
                getString(R.string.res7_hour), getString(R.string.res7_hint),
                R.drawable.ici));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        ItemGuideAdapter adapter = new ItemGuideAdapter(this, items, R.color.category_restaurants);

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
