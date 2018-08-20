package com.example.st_peter_hq.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(@NonNull Context context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemListView = convertView;

        if (itemListView == null) {
            itemListView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout,parent,false);
        }

        Item item = getItem(position);

        TextView itemHeader = itemListView.findViewById(R.id.item_header);
        ImageView itemImage = itemListView.findViewById(R.id.item_image);
        TextView itemDesc = itemListView.findViewById(R.id.item_desc);
        TextView itemContact = itemListView.findViewById(R.id.item_contact);

        itemHeader.setText(item.getItemName());
        itemImage.setImageResource(item.getItemImage());
        itemDesc.setText(item.getItemDesc());
        itemContact.setText(item.getItemContact());

        return itemListView;
    }
}
