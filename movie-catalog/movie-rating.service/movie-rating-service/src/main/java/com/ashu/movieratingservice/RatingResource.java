package com.ashu.movieratingservice;

import java.util.Arrays;
import java.util.List;

import com.ashu.movieratingservice.model.MovieRating;
import com.ashu.movieratingservice.model.Ratings;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public MovieRating getRating(@PathVariable("movieId") String movieId){
        return new MovieRating(movieId, 5);
    }  

    @RequestMapping("/users/{userId}")
    public Ratings getMovieInfo(@PathVariable("userId") String userId){
        List<MovieRating> ratings = Arrays.asList(
        new MovieRating("movie1", 4),
        new MovieRating("movie2", 5));
        Ratings rating = new Ratings();
        rating.setUserRating(ratings);
        return rating;
        
    }
}
