package com.pep.android.spguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the attractions category
        TextView attractions = (TextView) findViewById(R.id.attractions);

        // Set a click listener on that View
        attractions.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link AttractionsActivity}
                Intent attractionIntent = new Intent(MainActivity.this, AttractionsActivity.class);

                // Start the new activity
                startActivity(attractionIntent);
            }
        });

        // Find the View that shows the events category
        TextView events = (TextView) findViewById(R.id.events);

        // Set a click listener on that View
        events.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link FamilyActivity}
                Intent eventsIntent = new Intent(MainActivity.this, EventsActivity.class);

                // Start the new activity
                startActivity(eventsIntent);
            }
        });

        // Find the View that shows the restaurants category
        TextView restaurants = (TextView) findViewById(R.id.restaurants);

        // Set a click listener on that View
        restaurants.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the colors category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ColorsActivity}
                Intent restaurantsIntent = new Intent(MainActivity.this, RestaurantsActivity.class);

                // Start the new activity
                startActivity(restaurantsIntent);
            }
        });

        // Find the View that shows the bars category
        TextView bars = (TextView) findViewById(R.id.bars);

        // Set a click listener on that View
        bars.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link PhrasesActivity}
                Intent barsIntent = new Intent(MainActivity.this, BarsActivity.class);

                // Start the new activity
                startActivity(barsIntent);
            }
        });
    }
}

