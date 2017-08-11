package hu.helixlab.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Admin on 2017.08.02..
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Serializable> {

}
