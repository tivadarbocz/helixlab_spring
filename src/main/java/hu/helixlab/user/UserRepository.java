package hu.helixlab.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Admin on 2017.08.09..
 */
@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {

    @Query( value =" SELECT u FROM User u WHERE u.enabled = :enabled")
    Iterable<User> getEnabledUser(@Param("enabled") boolean enabled);

}
