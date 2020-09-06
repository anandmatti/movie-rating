package org.polar.ninja.movie.rating.service.impl;

import org.polar.ninja.movie.rating.model.Rating;
import org.polar.ninja.movie.rating.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Override
    public List<Rating> getAllRatings() {
        return null;
    }

    @Override
    public List<Rating> getRatingsForUser(String userId) {
        return null;
    }

    @Override
    public List<Rating> getRatingsForMovie(String movieId) {
        return null;
    }

    @Override
    public Rating postRating(Rating rating) {
        return null;
    }

}
