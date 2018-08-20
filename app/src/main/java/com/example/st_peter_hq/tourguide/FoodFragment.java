package com.example.st_peter_hq.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodFragment extends Fragment {

    private boolean mActiveItem = false;

    private View mActiveView;

    private int mActivePosition;

    public FoodFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View setLayout = inflater.inflate(R.layout.fragment_home, container, false);

        final ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item(R.string.bar_1_name, R.string.bar_1_desc, R.drawable.bar_1, R.string.bar_1_contact));
        items.add(new Item(R.string.bar_2_name, R.string.bar_2_desc, R.drawable.bar_2, R.string.bar_2_contact));
        items.add(new Item(R.string.bar_3_name, R.string.bar_3_desc, R.drawable.bar_3, R.string.bar_3_contact));


        ItemAdapter adapter = new ItemAdapter(getActivity(), items);

        ListView listView = setLayout.findViewById(R.id.item_listing);

        listView.setAdapter(adapter);

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

