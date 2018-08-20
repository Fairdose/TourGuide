package com.example.st_peter_hq.tourguide;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

public class Item {

    private int mItemName;
    private int mItemDesc;
    private int mItemImage;
    private int mItemContact;

    public Item (int n, int d, int i, int c) {
        mItemName = n;
        mItemDesc = d;
        mItemImage = i;
        mItemContact = c;
    }

    public int getItemName() { return mItemName; }

    public int getItemDesc() { return mItemDesc; }

    public int getItemImage() { return mItemImage; }

    public int getItemContact() { return mItemContact; }

}
