package hu.helixlab.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Admin on 2017.08.02..
 */
@RestController
@RequestMapping("/movie")
public class MovieRestController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<Movie> getMovie() {
        return movieService.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Movie getMovieById(@PathVariable int id) {
        return movieService.findOneById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    Movie updateMovieById(@PathVariable int id, @RequestBody Movie movie) {
        return movieService.update(id, movie);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    void deleteById(@PathVariable int id) {
        movieService.deleteById(id);
    }
}
