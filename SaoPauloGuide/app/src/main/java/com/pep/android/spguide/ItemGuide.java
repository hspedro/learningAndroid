package com.pep.android.spguide;

/**
 * Created by pep on 04/01/18.
 */


/**
 * {@link ItemGuide} represents a vocabulary word that the user wants to learn.
 * It contains a default translation, a Miwok translation, and an image for that word.
 */
public class ItemGuide {

    /**
     * Name for the item
     */
    private String mName;

    /**
     * Location for the item
     */
    private String mLocation;

    /**
     * Hours of operation of the item
     */
    private String mHours;

    /**
     * Hint from the guide for the item
     */
    private String mHint;

    /**
     * Image resource ID for the item
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;


    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new ItemGuide object.
     *
     * @param name             name of the Item
     * @param location         location of the Item
     * @param hours            hours of operation of the Item
     * @param hint             hint from the guide regarding the Item
     * @param imageResourceId    is the drawable resource ID for the image associated with the word
     */
    public ItemGuide(String name, String location, String hours, String hint,
                                                            int imageResourceId) {
        mName = name;
        mLocation = location;
        mHours = hours;
        mHint = hint;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the item.
     */
    public String getItemName() {
        return mName;
    }

    /**
     * Get the location of the item.
     */
    public String getItemLocation() {
        return mLocation;
    }

    /**
     * Get the hours of the item.
     */
    public String getItemHours() {
        return mHours;
    }

    /**
     * Get the hint of the item.
     */
    public String getItemHint() {
        return mHint;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}