package com.example.android.sanfranciscorecommendations;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BarsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommendation_list);

        //Create an ArrayList for bars recommendations
        final ArrayList<Recommender> recommendation = new ArrayList<>();
        recommendation.add(new Recommender(getString(R.string.bars_name_buena), getString(R.string.neighborhood_fishermans), getString(R.string.bars_des_buena), R.drawable.buenavista, getString(R.string.bars_url_buena)));
        recommendation.add(new Recommender(getString(R.string.bars_name_odd), getString(R.string.neighborhood_soma), getString(R.string.bars_des_odd), R.drawable.oddjob, getString(R.string.bars_url_odd)));
        recommendation.add(new Recommender(getString(R.string.bars_name_harper), getString(R.string.neighborhood_russian_hill), getString(R.string.bars_des_harper), R.drawable.harperrye ,getString(R.string.bars_url_harper)));
        recommendation.add(new Recommender(getString(R.string.bars_name_comstock), getString(R.string.neighborhood_north_beach), getString(R.string.bars_des_comstock), R.drawable.comstock, getString(R.string.bars_url_comstock)));
        recommendation.add(new Recommender(getString(R.string.bars_name_trademark), getString(R.string.neighborhood_soma), getString(R.string.bars_des_trademark), R.drawable.trademark, getString(R.string.bars_url_trademark)));
        recommendation.add(new Recommender(getString(R.string.bars_name_romolo), getString(R.string.neighborhood_north_beach), getString(R.string.bars_des_romolo), R.drawable.romolo, getString(R.string.bars_url_romolo)));

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