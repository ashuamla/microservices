package com.ashu.movieratingservice.model;

import java.util.List;

public class Ratings {
    
   public Ratings() {
    }

private  List<MovieRating> userRating;

public List<MovieRating> getUserRating() {
    return userRating;
}

public void setUserRating(List<MovieRating> userRating) {
    this.userRating = userRating;
}
   
}
