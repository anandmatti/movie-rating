package org.polar.ninja.movie.rating.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieRatingControllerTest {

    private static Logger LOGGER = LoggerFactory.getLogger(MovieRatingControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetRatingsForUser() throws Exception {
        String userId = "1";
        String expectedResponse = "{\"ratingList\":[{\"id\":\"1\",\"userId\":\"1\",\"movieId\":\"movie_1\",\"rating\":5},{\"id\":\"2\",\"userId\":\"1\"," +
                "\"movieId\":\"movie_2\",\"rating\":4}]}";
        mockMvc.perform(MockMvcRequestBuilders.get("/ratings/users/" + userId).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo(expectedResponse)));

    }

    @Test
    public void testGetRatingsForMovie() throws Exception {
        String movieId = "movie_1";
        String expectedResponse = "{\"ratingList\":[{\"id\":\"1\",\"userId\":\"user_1\",\"movieId\":\"movie_1\",\"rating\":5},{\"id\":\"2\",\"userId\":\"user_2\"," +
                "\"movieId\":\"movie_1\",\"rating\":4}]}";
        mockMvc.perform(MockMvcRequestBuilders.get("/ratings/movies/" + movieId).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo(expectedResponse)));
    }

    @Test
    public void testPostMovieRating() throws Exception {
        String rating = "{\"userId\":\"1\",\"movie\":\"movie_1\",\"rating\":\"5\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/ratings")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(rating).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }


    @Test
    public void testDeleteMovieRating() throws Exception {
        String userId = "1";
        String movieId = "movie_1";
        mockMvc.perform(MockMvcRequestBuilders.delete("/ratings/users/{userId}/movies/{movieId}", userId, movieId)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
