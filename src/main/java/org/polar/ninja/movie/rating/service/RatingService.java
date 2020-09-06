package org.polar.ninja.movie.rating.service;


import org.polar.ninja.movie.rating.model.Rating;

import java.util.List;

/**
 * Service for carrying out operations on Ratings data
 */
public interface RatingService {

    List<Rating> getRatingsForUser(String userId);

    List<Rating> getRatingsForMovie(String movieId);

    Rating postRating(Rating rating);

    List<Rating> getAllRatings();
}
