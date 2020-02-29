package com.example.wbdvsp20jannunziserverjava.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LikesController {
    List<String> moviesLiked = new ArrayList<String>();

    @PostMapping("/api/likes/{imdbID}")
    public String likeMovie(
            @PathVariable("imdbID") String imdbID) {
        moviesLiked.add(imdbID);
        return imdbID;
    }

    @GetMapping("/api/likes")
    public List<String> getMoviesLiked() {
        return moviesLiked;
    }

    @GetMapping("/api/likes/:imdbID")
    public Boolean isMovieLiked(
            @PathVariable("imdbID") String imdbID) {
        for(String s: moviesLiked) {
            if(s.equals(imdbID))
                return true;
        }
        return false;
    }
}
