package se.experis.assignment3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.experis.assignment3.models.Character;
import se.experis.assignment3.models.Movie;
import se.experis.assignment3.repositories.CharacterRepository;
import se.experis.assignment3.repositories.FranchiseRepository;
import se.experis.assignment3.repositories.MovieRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    /**
     * Autowired repositories for each Entity in our database
     */

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private FranchiseRepository franchiseRepository;

    /**
     *
     * @return Response Entity with a List of all the Movie Entities in database and
     * a corresponding HttpStatus if transaction was successful or not successful
     *
     */
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieRepository.findAll();
        if(!movies.isEmpty()) {
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } else return new ResponseEntity<>(movies, HttpStatus.NO_CONTENT);

    }

    /**
     *
     * @param id Long object representing Movie Entity ID that we search for
     * @return  Response Entity with Movie Entity object with the desired ID and a
     * corresponding HttpStatus if transaction was successful or not successful
     */
    public ResponseEntity<Movie> getMovie(Long id){
        Movie returnMovie = new Movie();
        if(movieRepository.existsById(id)){
            returnMovie = movieRepository.findById(id).get();
            return new ResponseEntity<>(returnMovie, HttpStatus.OK);
        } else return new ResponseEntity<>(returnMovie, HttpStatus.NOT_FOUND);
    }

    /**
     *
     * @param movie Movie object to be added in movie table in database
     * @return Response Entity with Movie Entity object added and a
     *      corresponding HttpStatus if transaction was successful or not successful
     */
    public ResponseEntity<Movie> addMovie(Movie movie){
        Movie returnMovie = new Movie();
        if(movie != null) {
            returnMovie = movieRepository.save(movie);
            return new ResponseEntity<>(returnMovie, HttpStatus.CREATED);
        } else return new ResponseEntity<>(returnMovie, HttpStatus.NO_CONTENT);

    }

    /**
     *
     * @param movie Movie object to be updated in movie table in database
     * @return Response Entity with Movie Entity object updated and a
     *         corresponding HttpStatus if transaction was successful or not successful
     */
    public ResponseEntity<Movie> updateMovie(Movie movie){
        Movie returnMovie = new Movie();
        if(!movieRepository.existsById(movie.getId())){
            return new ResponseEntity<>(returnMovie, HttpStatus.NOT_FOUND);
        }
        returnMovie = movieRepository.save(movie);
        return new ResponseEntity<>(returnMovie, HttpStatus.OK);
    }

    /**
     *
     * @param id Long object representing Movie Entity ID that we search for
     * @param charId Long object representing Character Entity ID that we want to add in Character List
     *               corresponding Movie Entity
     * @return Response Entity with desired Movie Entity object where Character object is updated
     *         and a corresponding HttpStatus if transaction was successful or not successful
     */
    public ResponseEntity<Movie> updateCharacterInMovie(Long id, Long charId){
        var chosenMovie = movieRepository.findById(id).get();
        var characterToAdd = characterRepository.findById(charId).get();
        chosenMovie.characters = new ArrayList<>();
        chosenMovie.characters.add(characterToAdd);
        movieRepository.save(chosenMovie);
        return new ResponseEntity<>(chosenMovie, HttpStatus.OK);
    }

    /**
     *
     * @param id Long object representing Movie Entity ID that we search for
     * @param charId Array of Long objects representing Character Entity IDs that we want to add in Character List
     *              corresponding Movie Entity
     * @return Response Entity with desired Movie Entity object where Character objects are updated
     *         and corresponding Http Status if transaction was successful or not successful
     */
    public ResponseEntity<Movie> updateCharactersInMovie(Long id, Long [] charId){
        var chosenMovie = movieRepository.findById(id).get();
        for (Long i : charId) {
            var characterToAdd = characterRepository.findById(i).get();
            chosenMovie.characters.add(characterToAdd);
        }
        movieRepository.save(chosenMovie);
        return new ResponseEntity<>(chosenMovie, HttpStatus.OK);
    }

    /**
     *
     * @param id Long object representing Movie Entity ID that we search for
     * @param franId Long object representing Franchise Entity ID that we want to add in Franchise object
     *               corresponding Movie Entity
     * @return Response Entity with desired Movie Entity object where Franchise object is updated
     *          and a corresponding HttpStatus if transaction was successful or not successful
     */
    public ResponseEntity<Movie> updateFranchiseInMovie(Long id, Long franId){
        var chosenMovie = movieRepository.findById(id).get();
        var franchiseToAdd = franchiseRepository.findById(franId).get();
        chosenMovie.franchise = franchiseToAdd;
        movieRepository.save(chosenMovie);
        return new ResponseEntity<>(chosenMovie, HttpStatus.OK);
    }

    /**
     *
     * @param id Long object representing Movie Entity ID that we search for
     * @return  Response Entity with desired List of Character objects found in corresponding
     *          Movie Entity and a corresponding HttpStatus if transaction was successful or not successful
     */
    public ResponseEntity<List<Character>> getAllCharactersInMovie(Long id) {
        Movie movie = movieRepository.findById(id).get();
        List<Character> allCharacters = characterRepository.findAll();
        List<Character> characters = new ArrayList<>();

        if (!allCharacters.isEmpty()) {
            for (var item : allCharacters) {
                if (item.movies == movie) {
                    characters.add(item);
                }
            }
            return new ResponseEntity<>(characters, HttpStatus.OK);
        } else return new ResponseEntity<>(characters, HttpStatus.NO_CONTENT);
    }

    /**
     *
     * @param id  Long object representing Movie Entity ID that we wish to remove from database
     * @return Response Entity with Long object representing the ID of the removed Movie Entity
     *          and a corresponding HttpStatus if transaction was successful or not successful
     */
    public ResponseEntity<Long> deleteMovie(Long id){
        if(movieRepository.existsById(id)){
            movieRepository.deleteById(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);

    }

}
