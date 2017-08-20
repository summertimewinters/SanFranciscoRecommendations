package com.example.android.sanfranciscorecommendations;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CoffeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommendation_list);

        //Create an ArrayList for coffee recommendations
        final ArrayList<Recommender> recommendation = new ArrayList<>();
        recommendation.add(new Recommender(getString(R.string.coffee_name_sight_glass), getString(R.string.neighborhood_soma), getString(R.string.coffee_des_sextant), R.drawable.sightglass, getString(R.string.coffee_url_sextant)));
        recommendation.add(new Recommender(getString(R.string.coffee_name_trieste), getString(R.string.neighborhood_north_beach), getString(R.string.coffee_des_trieste), R.drawable.trieste, getString(R.string.coffee_url_trieste)));
        recommendation.add(new Recommender(getString(R.string.coffee_name_sextant), getString(R.string.neighborhood_soma), getString(R.string.coffee_des_sextant), R.drawable.sextant, getString(R.string.coffee_url_sextant)));
        recommendation.add(new Recommender(getString(R.string.coffee_name_craftsman), getString(R.string.neighborhood_mission), getString(R.string.coffee_des_craftsman), R.drawable.craftsmanwolves, getString(R.string.coffee_url_craftsman)));
        recommendation.add(new Recommender(getString(R.string.coffee_name_vive), getString(R.string.neighborhood_soma), getString(R.string.coffee_des_vive), R.drawable.vive, getString(R.string.coffee_url_vive)));
        recommendation.add(new Recommender(getString(R.string.coffee_name_ferry), getString(R.string.neighborhood_downtown), getString(R.string.coffee_des_ferry), R.drawable.ferrybuilding, getString(R.string.coffee_url_ferry)));

        RecommenderAdapter recommendationAdapter = new RecommenderAdapter(this, recommendation);
        ListView listView = (ListView) findViewById(R.id.recommendation_list);
        listView.setAdapter(recommendationAdapter);

        //Create an OnClick Listener for the ListView and send an intent to the URL
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Recommender recommender = recommendation.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(recommender.getRecommendationUrl()));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}