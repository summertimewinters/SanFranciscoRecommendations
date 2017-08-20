package com.example.android.sanfranciscorecommendations;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivitiesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommendation_list);

        //Create an ArrayList for activities recommendations
        final ArrayList<Recommender> recommendation = new ArrayList<>();
        recommendation.add(new Recommender(getString(R.string.act_name_clarion), getString(R.string.neighborhood_mission), getString(R.string.act_des_clarion), R.drawable.clarion, getString(R.string.act_url_clarion)));
        recommendation.add(new Recommender(getString(R.string.act_name_bike), getString(R.string.neighborhood_marina), getString(R.string.act_des_bike), R.drawable.bikebridge, getString(R.string.act_url_bike)));
        recommendation.add(new Recommender(getString(R.string.act_name_ocean_beach), getString(R.string.neighborhood_outer_sunset), getString(R.string.act_des_ocean_beach), R.drawable.oceanbeach, getString(R.string.act_url_ocean_beach)));
        recommendation.add(new Recommender(getString(R.string.act_name_deyoung), getString(R.string.neighborhood_golden_gate_park), getString(R.string.act_des_deyoung), R.drawable.deyound, getString(R.string.act_url_deyoung)));
        recommendation.add(new Recommender(getString(R.string.act_name_lombard), getString(R.string.neighborhood_russian_hill), getString(R.string.act_des_lombard), R.drawable.lombardstreet, getString(R.string.act_url_lombard)));
        recommendation.add(new Recommender(getString(R.string.act_name_dolores), getString(R.string.neighborhood_mission), getString(R.string.act_des_dolores), R.drawable.dolorespark, getString(R.string.act_url_dolores)));
        recommendation.add(new Recommender(getString(R.string.act_name_alcatraz), getString(R.string.neighborhood_sf_bay), getString(R.string.act_des_alcatraz), R.drawable.alcatraznight, getString(R.string.act_url_alcatraz)));

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