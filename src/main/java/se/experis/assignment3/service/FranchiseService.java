package se.experis.assignment3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.experis.assignment3.models.Character;
import se.experis.assignment3.models.Franchise;
import se.experis.assignment3.models.Movie;
import se.experis.assignment3.repositories.FranchiseRepository;
import se.experis.assignment3.repositories.MovieRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class FranchiseService {

    /**
     * Autowired repositories for Franchise Entity and Movie Entity in our database
     */
    @Autowired
    private FranchiseRepository franchiseRepository;

    @Autowired
    private MovieRepository movieRepository;

    /**
     *
     * @return Response Entity with a list of all the Franchise Entities in the database and
     * a corresponding HttpStatus if transaction was successful or not successful
     *
     */
    public ResponseEntity<List<Franchise>> getAllFranchises(){
        List<Franchise> franchises = franchiseRepository.findAll();
        if(!franchises.isEmpty()) {
            return new ResponseEntity<>(franchises, HttpStatus.OK);
        } else return new ResponseEntity<>(franchises, HttpStatus.NO_CONTENT);
    }

    /**
     *
     * @param id Long object representing Franchise Entity ID that we search for
     * @return  Response Entity with franchise Entity object with the desired ID and a
     * corresponding HttpStatus if transaction was successful or not successful
     */
    public ResponseEntity<Franchise> getFranchise(Long id){
        Franchise returnFranchise = new Franchise();
        if(franchiseRepository.existsById(id)){
            returnFranchise = franchiseRepository.findById(id).get();
            return new ResponseEntity<>(returnFranchise, HttpStatus.OK);
        } else return new ResponseEntity<>(returnFranchise, HttpStatus.NOT_FOUND);

    }

    /**
     *
     * @param franchise Franchise object to be added in franchise table in database
     * @return Response Entity with Franchise Entity object added and a
     *      corresponding HttpStatus if transaction was successful or not successful
     */
    public ResponseEntity<Franchise> addFranchise(Franchise franchise){
        Franchise returnFranchise = new Franchise();
        if(franchise != null) {
            returnFranchise = franchiseRepository.save(franchise);
            return new ResponseEntity<>(returnFranchise, HttpStatus.CREATED);
        } else return new ResponseEntity<>(returnFranchise, HttpStatus.NO_CONTENT);

    }

    /**
     *
     * @param franchise Franchise object to be updated in franchise table in database
     * @return Response Entity with Franchise Entity object updated and a
     *         corresponding HttpStatus if transaction was successful or not successful
     */
    public ResponseEntity<Franchise> updateFranchise(Franchise franchise){
        Franchise returnFranchise = new Franchise();
        if(!franchiseRepository.existsById(franchise.getId())){
            return new ResponseEntity<>(returnFranchise,HttpStatus.BAD_REQUEST);
        }
        returnFranchise = franchiseRepository.save(franchise);
        return new ResponseEntity<>(returnFranchise, HttpStatus.NO_CONTENT);
    }

    /**
     *
     * @param id Long object representing Franchise Entity ID that we search for
     * @param movId Long object representing Movie Entity ID that we want to add in Movies List of
     *               corresponding Franchise Entity
     * @return Response Entity with desired Franchise Entity object where Movie objects List is updated
     *         and a corresponding HttpStatus if transaction was successful or not successful
     */
    public ResponseEntity<Franchise> updateMovieInFranchise(Long id, Long movId){
        var chosenFranchise = franchiseRepository.findById(id).get();
        var movieToAdd = movieRepository.findById(movId).get();
        chosenFranchise.movies = new ArrayList<>();
        chosenFranchise.movies.add(movieToAdd);
        franchiseRepository.save(chosenFranchise);
        return new ResponseEntity<>(chosenFranchise, HttpStatus.OK);
    }

    /**
     *
     * @param id Long object representing Franchise Entity ID that we search for
     * @param movId Array of Long objects representing Movie Entity IDs that we want to add in Movies List
     *              corresponding Franchise Entity
     * @return Response Entity with desired Franchise Entity object where Movie objects are updated
     *         and a correspondingHttp Status if transaction was successful or not successful
     */
    public ResponseEntity<Franchise> updateMoviesInFranchise(Long id, Long [] movId){
        var chosenFranchise = franchiseRepository.findById(id).get();
        for (Long i : movId) {
            var movieToAdd = movieRepository.findById(i).get();
            chosenFranchise.movies.add(movieToAdd);
        }
        franchiseRepository.save(chosenFranchise);
        return new ResponseEntity<>(chosenFranchise, HttpStatus.OK);
    }

    /**
     *
     * @param id Long object representing Franchise Entity ID that we search for
     * @return  Response Entity with List of Movie objects corresponding to
     *          Franchise Entity and a corresponding HttpStatus if transaction was
     *          successful or not successful
     */
    public ResponseEntity<List<Movie>> getAllMoviesInFranchise(Long id){
        Franchise franchise = franchiseRepository.findById(id).get();
        List<Movie> allMovies = movieRepository.findAll();
        List<Movie> movies = new ArrayList<>();

        if (!allMovies.isEmpty()) {
            for (var item : allMovies) {
                if(item.franchise == franchise) {
                    movies.add(item);
                }
            }
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }
        else return new ResponseEntity<>(movies, HttpStatus.NO_CONTENT);
    }

    /**
     *
     * @param id Long object representing Franchise Entity ID that we search for
     * @return  Response Entity with List of Characters objects corresponding to
     *          every Movie Entity in Movie object List at corresponding Franchise Entity
     *          and a corresponding HttpStatus if transaction was successful or not successful
     */
    public ResponseEntity<List<Character>> getAllCharactersInFranchise(Long id){
        Franchise franchise = franchiseRepository.findById(id).get();
        List<Movie> allMovies = movieRepository.findAll();
        List<Movie> movies = new ArrayList<>();
        List<Character> characterList = new ArrayList<>();

        for (var item : allMovies) {
            if(item.franchise == franchise) {
                    movies.add(item);
            }
        }

        if(!movies.isEmpty()) {
            for (var item : movies) {
                characterList.addAll(item.characters);
            }
            return new ResponseEntity<>(characterList, HttpStatus.OK);
        } else return new ResponseEntity<>(characterList, HttpStatus.NO_CONTENT);
    }

    /**
     *
     * @param id  Long object representing Franchise Entity ID that we wish to remove from database
     * @return Response Entity with Long object representing the ID of the removed Franchise Entity
     *          and a corresponding HttpStatus if transaction was successful or not successful
     */
    public ResponseEntity<Long> deleteFranchise(Long id){
        if(franchiseRepository.existsById(id)){
            franchiseRepository.deleteById(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);

    }


}
