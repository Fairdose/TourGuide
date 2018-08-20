package com.example.st_peter_hq.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EventsFragment extends Fragment {

    //Define global variables for active item layout

    private boolean mActiveItem = false;
    private View mActiveView;
    private int mActivePosition;

    public EventsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View setLayout = inflater.inflate(R.layout.fragment_home, container, false);

        final ArrayList<Item> items = new ArrayList<Item>();

        //add the items to the item array

        items.add(new Item(R.string.event_1_name, R.string.event_1_desc, R.drawable.events_1, R.string.event_1_contact));
        items.add(new Item(R.string.event_2_name, R.string.event_2_desc, R.drawable.events_2, R.string.event_2_contact));


        ItemAdapter adapter = new ItemAdapter(getActivity(), items);

        ListView listView = setLayout.findViewById(R.id.item_listing);

        listView.setAdapter(adapter);

        //Let's add a small but powerful hide and show detail method.

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                View activeView = view.findViewById(R.id.item_content);

                if (mActiveItem && position == mActivePosition) {

                    mActiveView.setVisibility(View.GONE);
                    mActiveItem = false;

                } else if (mActiveItem) {

                    mActiveView.setVisibility(View.GONE);
                    activeView.setVisibility(View.VISIBLE);

                    mActiveView = activeView;

                } else {

                    if (mActiveView != null)
                        mActiveView.setVisibility(View.GONE);

                    activeView.setVisibility(View.VISIBLE);

                    mActiveView = activeView;
                    mActiveItem = true;
                }

                mActivePosition = position;
            }
        });

        return setLayout;
    }
}

