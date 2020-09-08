package org.polar.ninja.movie.rating.controller;

import org.polar.ninja.movie.rating.model.Rating;
import org.polar.ninja.movie.rating.model.UserRating;
import org.polar.ninja.movie.rating.service.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("ratings")
public class MovieRatingController {

    private static Logger LOGGER = LoggerFactory.getLogger(MovieRatingController.class);

    @Autowired
    private RatingService ratingService;

    @RequestMapping()
    public UserRating getAllRatings() {
        List<Rating> ratings = ratingService.getAllRatings();
        LOGGER.debug("Found Rating :" + ratings);
        return new UserRating(ratings);
    }

    @RequestMapping("/movies/{movieId}")
    public UserRating getRatingsForMovie(@PathVariable("movieId") String movieId) {
        return new UserRating(Arrays.asList(new Rating("1", "user_1", movieId, 5), new Rating("2", "user_2", movieId, 4)));
    }

    @RequestMapping("/users/{userId}")
    public UserRating getRatingsForUser(@PathVariable("userId") String userId) {
        return new UserRating(Arrays.asList(new Rating("1", userId, "movie_1", 5), new Rating("2", userId, "movie_2", 4)));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postRating(@RequestBody Rating rating) throws URISyntaxException {
        return ResponseEntity.created(new URI("/users/" + rating.getUserId() + "/movies/" + rating.getMovieId())).build();
    }

    @DeleteMapping(value = "/users/{userId}/movies/{movieId}")
    public ResponseEntity deleteRating(@PathVariable("userId") String userId, @PathVariable("movieId") String movieId) {
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateRating(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
