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

        items.add(new ItemGuide("Ibirapuera Park", "Pedro Alvares Cabral Avenue",
                "from 05:00 to 00:00", "Rent a bike there",
                R.drawable.ibirapuera));
        items.add(new ItemGuide("Pinacoteca", "Luz Square",
                "from 10:00 to 17:30", "Becherect sculptures",
                R.drawable.pinacoteca));
        items.add(new ItemGuide("Paulsita Avenue", "Paulista Avenue",
                "All day", "Closed for cars at Sundays",
                R.drawable.paulista));
        items.add(new ItemGuide("Catavento Space",
                "Square Civica Ulisses Guimaraes",
                "All day", "Family trip",
                R.drawable.catavento));
        items.add(new ItemGuide("Cultural Center BB", "Alvares Penteado Street 112",
                "from 09:00 to 21:00", "Events are free!",
                R.drawable.ccbb));
        items.add(new ItemGuide("Municipal Theatre", "Ramos de Azevedo Square",
                "from 10:00 to 17:00", "Take a cab or uber",
                R.drawable.theatre));
        items.add(new ItemGuide("Museum of Football", "Charles Miller Square",
                "from 09:00 to 16:00", "It is inside of a stadium",
                R.drawable.football));
        items.add(new ItemGuide("Museum of Art - MASP", "Paulista Avanue, 1578",
                "from 10:00 to 18:00", "Renowned expositions ",
                R.drawable.masp));
        items.add(new ItemGuide("Municipal Market", "Cantareira Stree, 306",
                "from 06:00 to 18:00", "Watch out for the fruit price!",
                R.drawable.market));
        items.add(new ItemGuide("Botanical Garden", "Miguel Estefno Avenue 3031",
                "from 09:00 to 17:00", "Cheap entrance fee",
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
