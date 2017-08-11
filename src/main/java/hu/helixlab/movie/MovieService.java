package hu.helixlab.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Admin on 2017.08.02..
 */

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;


    Iterable<Movie> findAll(){
        return movieRepository.findAll();
    }

    Movie findOneById(int id){
        return movieRepository.findOne(id);
    }

    Movie createMovie(Movie movie){
        return movieRepository.saveAndFlush(movie);
    }

    Movie update(int id, Movie movie){
        if(movieRepository.findOne(id).getId() == id){
            return movieRepository.saveAndFlush(movie);
        }
        throw new NullPointerException();
    }

    void deleteById(int id){
        Movie movie = movieRepository.findOne(id);
        if(movie != null){
            movieRepository.delete(movie);
        }
    }
}
