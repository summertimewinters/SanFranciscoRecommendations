package com.example.android.sanfranciscorecommendations;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommendation_list);

        //Create an ArrayList for restaurant recommendations
        final ArrayList<Recommender> recommendation = new ArrayList<>();
        recommendation.add(new Recommender(getString(R.string.rest_name_kokkari), getString(R.string.neighborhood_north_beach), getString(R.string.rest_des_kokkari), R.drawable.kokkari, getString(R.string.rest_url_kokkari)));
        recommendation.add(new Recommender(getString(R.string.rest_name_bellota), getString(R.string.neighborhood_soma), getString(R.string.rest_des_bellota), R.drawable.bellota, getString(R.string.rest_url_bellota)));
        recommendation.add(new Recommender(getString(R.string.rest_name_sodinis), getString(R.string.neighborhood_north_beach), getString(R.string.rest_des_sodinis), R.drawable.sodinis, getString(R.string.rest_url_sodinis)));
        recommendation.add(new Recommender(getString(R.string.rest_name_wayfare), getString(R.string.neighborhood_downtown), getString(R.string.rest_des_wayfare), R.drawable.wayfare, getString(R.string.rest_url_wayfare)));
        recommendation.add(new Recommender(getString(R.string.rest_name_elfarrolit), getString(R.string.neighborhood_mission), getString(R.string.rest_des_elfarrolit), R.drawable.elfarolito, getString(R.string.rest_url_elfarrolit)));
        recommendation.add(new Recommender(getString(R.string.rest_name_basil), getString(R.string.neighborhood_soma), getString(R.string.rest_des_basil), R.drawable.basil, getString(R.string.rest_url_basil)));
        recommendation.add(new Recommender(getString(R.string.rest_name_iza), getString(R.string.neighborhood_soma), getString(R.string.rest_des_iza), R.drawable.iza, getString(R.string.rest_url_iza)));
        recommendation.add(new Recommender(getString(R.string.rest_name_deli_board), getString(R.string.neighborhood_soma), getString(R.string.rest_des_deli_board), R.drawable.deliboard, getString(R.string.rest_url_deli_board)));

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
