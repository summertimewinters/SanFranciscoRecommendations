package com.example.android.sanfranciscorecommendations;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Customer adapter for the Recommender class
 */

public class RecommenderAdapter extends ArrayAdapter<Recommender> {

    //Initialize new adapter to bring in ArrayList Recommender
    public RecommenderAdapter(Activity context, ArrayList<Recommender> recommenderEngine) {
        super(context, 0, recommenderEngine);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.recommendation_activity, parent, false);
        }

        //Get the object located at the list
        final Recommender currentRecommendation = getItem(position);

        //Find ImageView in layout and display current recommendation image
        ImageView recommendationImageView = (ImageView) listItemView.findViewById(R.id.image_image);
        recommendationImageView.setImageResource(currentRecommendation.getRecommendationImage());

        //Find TextView name in layout and display current recommendation name
        TextView recommendationTextViewName = (TextView) listItemView.findViewById(R.id.text_name);
        recommendationTextViewName.setText(currentRecommendation.getRecommendationName());

        //Find TextView neighborhood in layout and display current recommendation name
        TextView recommendationTextViewNeighborhood = (TextView) listItemView.findViewById(R.id.text_neighborhood);
        recommendationTextViewNeighborhood.setText(currentRecommendation.getRecommendationNeighborhood());

        //Find TextView description in layout and display current recommendation description
        TextView recommendationTextViewDescription = (TextView) listItemView.findViewById(R.id.text_description);
        recommendationTextViewDescription.setText(currentRecommendation.getRecommendationDescription());

        return listItemView;
    }

}
