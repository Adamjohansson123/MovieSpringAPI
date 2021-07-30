package se.experis.assignment3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.experis.assignment3.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {


}

