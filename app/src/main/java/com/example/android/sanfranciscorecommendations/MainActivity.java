package com.example.android.sanfranciscorecommendations;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static java.net.Proxy.Type.HTTP;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set layout
        setContentView(R.layout.activity_main);

        //Create click listener for the coffee activity
        TextView coffeeClickListener = (TextView) findViewById(R.id.text_coffee);
        coffeeClickListener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityCoffee = new Intent(MainActivity.this, CoffeeActivity.class);
                startActivity(activityCoffee);
            }
        });

        //Create click listener for the activities activity
        TextView activitiesClickListener = (TextView) findViewById(R.id.text_activities);
        activitiesClickListener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityActivities = new Intent(MainActivity.this, ActivitiesActivity.class);
                startActivity(activityActivities);
            }
        });

        //Create click listener for the restaurants activity
        TextView restaurantsClickListener = (TextView) findViewById(R.id.text_restaurants);
        restaurantsClickListener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityRestaurants = new Intent(MainActivity.this, RestaurantsActivity.class);
                startActivity(activityRestaurants);
            }
        });

        //Create click listener for the bars activity
        TextView barsClickListener = (TextView) findViewById(R.id.text_bars);
        barsClickListener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityBars = new Intent(MainActivity.this, BarsActivity.class);
                startActivity(activityBars);
            }
        });

        //Create an intent to share the app for the floating action button
        FloatingActionButton recommenderShare = (FloatingActionButton) findViewById(R.id.recommendationFAB);
        recommenderShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(shareIntent.EXTRA_TEXT, "San Francisco recommendations at https://sanfranciscorecommendations.android.example.com");
                if (shareIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(shareIntent);
                }
            }
        });
    }
}
