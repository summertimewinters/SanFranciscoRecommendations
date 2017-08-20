package com.example.android.sanfranciscorecommendations;

/**
 * Recommender Class will be able to generate the name, description and image for a recommendation
 */

public class Recommender {

    //Create String variable for name of recommendation
    private String mRecommendationName;

    //Create String variable for neighborhood of recommendation
    private String mRecommendationNeighborhood;

    //Create String variable for short description of recommendation
    private String mRecommendationDescription;

    //Create int variable for image of recommendation
    private int mRecommendationImage;

    //Create String variable to hold the URL link
    private String mRecommendationUrlLink;

    //Create method that links together name, neighborhood, description, image and URL
    public Recommender(String recommendationName, String recommendationNeighborhood, String recommendationDescription, int recommendationImage, String recommendationUrlLink) {
        mRecommendationName = recommendationName;
        mRecommendationNeighborhood = recommendationNeighborhood;
        mRecommendationDescription = recommendationDescription;
        mRecommendationImage = recommendationImage;
        mRecommendationUrlLink = recommendationUrlLink;
    }

    //Create a get method to call the name variable
    public String getRecommendationName() {
        return mRecommendationName;
    }

    //Create a get method to call the neighborhood variable
    public String getRecommendationNeighborhood() {
        return mRecommendationNeighborhood;
    }

    //Create a get method to call the description variable
    public String getRecommendationDescription() {
        return mRecommendationDescription;
    }

    //Create a get method to call the image variable
    public int getRecommendationImage() {
        return mRecommendationImage;
    }

    //Create a get method to call the String URL variable
    public String getRecommendationUrl() {
        return mRecommendationUrlLink;
    }

}
