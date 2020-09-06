package org.polar.ninja.movie.rating.model;

import java.util.List;


public class UserRating {
    private List<Rating> ratingList;

    public UserRating(){
    }

    public UserRating(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    @Override
    public String toString() {
        return "UserRating{" +
                "ratingList=" + ratingList +
                '}';
    }
}
