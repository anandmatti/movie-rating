package org.polar.ninja.movie.rating;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.polar.ninja.movie.rating.controller.MovieRatingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieRatingApplicationSmokeTest {
    @Autowired
    private MovieRatingController movieRatingController;

    @Test
    public void contextLoads(){
        Assertions.assertThat( movieRatingController).isNotNull();

    }


}
