package com.pep.android.spguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pep on 04/01/18.
 */

public class ItemGuideAdapter extends ArrayAdapter<ItemGuide> {

    private int mColorResourceId;

    public ItemGuideAdapter(Activity context, ArrayList<ItemGuide> itemGuidesList,
                                                                int colorResourceId) {
        super(context, 0, itemGuidesList);
        this.mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if being used
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        ItemGuide currentItemGuide = getItem(position);

        // Find the ImageView in the list_item.xml layout with the ID item img
        ImageView img = (ImageView) listItemView.findViewById(R.id.item_img);
        // Get the version name from the current AndroidFlavor object and
        // set this image on the ImageView
        if (currentItemGuide.hasImage()) {
            img.setImageResource(currentItemGuide.getImageResourceId());
        } else {
            img.setVisibility(View.GONE);
        }

        // Find the TextView in the list_item.xml layout with the ID item name
        TextView itemTextView = (TextView) listItemView.findViewById(R.id.item_name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        itemTextView.setText(currentItemGuide.getItemName());

        // Find the TextView in the list_item.xml layout with the ID item location
        itemTextView = (TextView) listItemView.findViewById(R.id.item_location);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        itemTextView.setText(currentItemGuide.getItemLocation());

        // Find the TextView in the list_item.xml layout with the ID item hours
        itemTextView = (TextView) listItemView.findViewById(R.id.item_hours);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        itemTextView.setText(currentItemGuide.getItemHours());

        // Find the TextView in the list_item.xml layout with the ID item hint
        itemTextView = (TextView) listItemView.findViewById(R.id.item_hint);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        itemTextView.setText(currentItemGuide.getItemHint());

        RelativeLayout relativeLayout = (RelativeLayout) listItemView.findViewById(R.id.text_container);
        relativeLayout.setBackgroundColor(ContextCompat.getColor(getContext(), mColorResourceId));

        return listItemView;
    }
}
