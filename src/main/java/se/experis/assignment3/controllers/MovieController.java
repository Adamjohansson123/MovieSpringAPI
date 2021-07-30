package se.experis.assignment3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.assignment3.models.Character;
import se.experis.assignment3.models.Movie;
import se.experis.assignment3.service.MovieService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     *
     * @return Response Entity with a List of all the Movie Entities in database and
     * a corresponding HttpStatus if transaction was successful or not successful
     *
     */
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return movieService.getAllMovies();
    }

    /**
     *
     * @param id Long object as Path Variable representing Movie Entity ID that we search for
     * @return  Response Entity with Movie Entity object with the desired ID and a
     * corresponding HttpStatus if transaction was successful or not successful
     */
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id){
       return movieService.getMovie(id);
    }

    /**
     *
     * @param id Long object as Path Variable representing Movie Entity ID that we search for
     * @return  Response Entity with desired List of Character objects found in corresponding
     *          Movie Entity and a corresponding HttpStatus if transaction was successful or not successful
     */
    @GetMapping("/getAllCharactersInMovie/{id}")
    public ResponseEntity<List<Character>> getAllCharactersInMovie(@PathVariable Long id){
        return movieService.getAllCharactersInMovie(id);
    }

    /**
     *
     * @param movie Movie object sent trough Request Body to be added in movie table in database
     * @return Response Entity with Movie Entity object added and a
     *      corresponding HttpStatus if transaction was successful or not successful
     */
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    /**
     *
     * @param movie Movie object sent trough Request Body to be updated in movie table in database
     * @return Response Entity with Movie Entity object updated and a
     *         corresponding HttpStatus if transaction was successful or not successful
     */
    @PutMapping
    public ResponseEntity<Movie> updateMovie( @RequestBody Movie movie){
        return movieService.updateMovie(movie);
    }

    /**
     *
     * @param id Long object sent as Path Variable representing Movie Entity ID that we search for
     * @param charId Long object sent trough Request Body representing Character Entity ID that we want to add in Character List
     *               corresponding Movie Entity
     * @return Response Entity with desired Movie Entity object where Character object is updated
     *         and a corresponding HttpStatus if transaction was successful or not successful
     */
    @PutMapping("/updateCharacterInMovie/{id}")
    public ResponseEntity<Movie> updateCharacterInMovie(@PathVariable Long id, @RequestBody Long charId ){
        return movieService.updateCharacterInMovie(id,charId);
    }

    /**
     *
     * @param id Long object sent as Path Variable representing Movie Entity ID that we search for
     * @param charId Array of Long objects sent trough Request Body representing Character Entity IDs that we want to add in Character List
     *              corresponding Movie Entity
     * @return Response Entity with desired Movie Entity object where Character objects are updated
     *         and a corresponding HttpStatus if transaction was successful or not successful
     */
    @PutMapping("/updateCharactersInMovie/{id}")
    public ResponseEntity<Movie> updateCharactersInMovie(@PathVariable Long id, @RequestBody Long [] charId ){
        return movieService.updateCharactersInMovie(id,charId);
    }

    /**
     *
     * @param id Long object sent as Path Variable representing Movie Entity ID that we search for
     * @param franId Long object sent trough Request Body representing Franchise Entity ID that we want to add in Franchise object
     *               corresponding Movie Entity
     * @return Response Entity with desired Movie Entity object where Franchise object is updated
     *          and a corresponding HttpStatus if transaction was successful or not successful
     */
    @PutMapping("/updateFranchiseInMovie/{id}")
    public ResponseEntity<Movie> updateFranchiseInMovie(@PathVariable Long id, @RequestBody Long franId ){
      return movieService.updateFranchiseInMovie(id, franId);
    }

    /**
     *
     * @param id  Long object sent as Path Variable representing Movie Entity ID that we wish to remove from database
     * @return Response Entity with Long object representing the ID of the removed Movie Entity
     *          and a corresponding HttpStatus if transaction was successful or not successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteMovie(@PathVariable Long id){
     return movieService.deleteMovie(id);
    }

}
