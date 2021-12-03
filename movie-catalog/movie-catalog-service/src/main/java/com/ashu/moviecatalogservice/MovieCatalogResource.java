package com.ashu.moviecatalogservice;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ashu.moviecatalogservice.models.CatalogItem;
import com.ashu.moviecatalogservice.models.Movie;
import com.ashu.moviecatalogservice.models.MovieRating;
import com.ashu.moviecatalogservice.models.Ratings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    RestTemplate restTemplate ;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        Ratings ratings = restTemplate.getForObject("http://localhost:8083/rating/users/" + userId, Ratings.class);
         return ratings.getUserRating().stream().map(rating -> {
             Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
             return new CatalogItem(movie.getName(), "movie1 description", rating.getRating());
            })
         .collect(Collectors.toList());
    }

    
    
}


