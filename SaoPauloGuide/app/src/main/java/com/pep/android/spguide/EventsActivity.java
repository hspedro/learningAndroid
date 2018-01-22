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

        items.add(new ItemGuide("Cannoli Competition", "Eataly",
                "20-21 Jan", "Lots of prizes",
                R.drawable.cannoli));
        items.add(new ItemGuide("Carnival Rehearse", "Baixo Augusta",
                "21 Jan", "Deep experience",
                R.drawable.carnival));
        items.add(new ItemGuide("Vegan Meeting", "Paulista Av.",
                "21 Jan", "Yoga and meditation",
                R.drawable.vegan));
        items.add(new ItemGuide("Depardon exhibition", "CCBB",
                "3-22 Jan", "Free retrospective",
                R.drawable.depardon));
        items.add(new ItemGuide("Boxing Cinema", "Sesc Carmo",
                "16-24 Jan", "Courses will be given",
                R.drawable.box));
        items.add(new ItemGuide("Renato Russo exhibition", "MIS",
                "Up to 28 Jan", "First time exhibition",
                R.drawable.russo));
        items.add(new ItemGuide("L the musical", "CCBB",
                "4-26 Feb", "Brazilian female MPB",
                R.drawable.lmusical));
        items.add(new ItemGuide("Di Cavalcanti exhibition", "Pinacoteca",
                "Up to 22 Jan", "Biggest brazilian painter",
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
