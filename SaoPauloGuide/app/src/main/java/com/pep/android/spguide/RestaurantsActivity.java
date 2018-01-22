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

        items.add(new ItemGuide("Mani", "Pinheiros",
                "12-15, 20-23", "Baked pork",
                R.drawable.mani));
        items.add(new ItemGuide("Tordesilhas", "Cerqueira Cesar",
                "18-01", "Zuchhini spaguetti",
                R.drawable.tordesilhas));
        items.add(new ItemGuide("Aizomê", "Paulista Garden",
                "12-14, 19-23", "Squid and mini octopus",
                R.drawable.aizome));
        items.add(new ItemGuide("Ráscal", "JK Iguatemi",
                "12-15, 19-22", "Codfish",
                R.drawable.rascal));
        items.add(new ItemGuide("Petí", "Pompeia Village",
                "12-15", "Baked hump steak",
                R.drawable.peti));
        items.add(new ItemGuide("Varanda", "Paulista Garden",
                "12-15, 19-23", "Potterhouse black angus",
                R.drawable.varanda));
        items.add(new ItemGuide("Ici Bistrô", "Consolação",
                "12-15, 19-00", "Duck magret",
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
