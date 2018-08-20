package com.example.st_peter_hq.tourguide;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_home.xml layout file
        setContentView(R.layout.activity_home);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);

        // Create an adapter that knows which fragment should be shown on each page
        FragmentInflater adapter = new FragmentInflater(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Connect the tab layout with the view pager when the tab is clicked or when the screen is swiped.
        tabLayout.setupWithViewPager(viewPager);
    }
}
