package se.experis.assignment3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.assignment3.models.Character;
import se.experis.assignment3.models.Franchise;
import se.experis.assignment3.models.Movie;
import se.experis.assignment3.service.FranchiseService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/franchises")
public class FranchiseController {

    @Autowired
    private FranchiseService franchiseService;

    /**
     *
     * @return Response Entity with a List of all the Franchise Entities in database and
     * a corresponding HttpStatus if transaction was successful or not successful
     *
     */
    @GetMapping
    public ResponseEntity<List<Franchise>> getAllFranchises(){
      return franchiseService.getAllFranchises();
    }

    /**
     *
     * @param id Long object sent as Path Variable representing Franchise Entity ID that we search for
     * @return  Response Entity with franchise Entity object with the desired ID and a
     * corresponding HttpStatus if transaction was successful or not successful
     */
    @GetMapping("/{id}")
    public ResponseEntity<Franchise> getFranchise(@PathVariable Long id){
     return franchiseService.getFranchise(id);
    }

    /**
     *
     * @param id Long object sent as Path Variable representing Franchise Entity ID that we search for
     * @return  Response Entity with List of Movie objects corresponding to
     *          Franchise Entity and a corresponding HttpStatus if transaction was
     *          successful or not successful
     */
    @GetMapping("/getAllMoviesInFranchise/{id}")
    public ResponseEntity<List<Movie>> getAllMoviesInFranchise(@PathVariable Long id){
        return franchiseService.getAllMoviesInFranchise(id);
    }

    /**
     *
     * @param id Long object sent as Path Variable representing Franchise Entity ID that we search for
     * @return  Response Entity with List of Characters objects corresponding to
     *          every Movie Entity in Movie object List at corresponding Franchise Entity
     *          and a corresponding HttpStatus if transaction was successful or not successful
     */
    @GetMapping("/getAllCharactersInFranchise/{id}")
    public ResponseEntity<List<Character>> getAllCharactersInFranchise(@PathVariable Long id){
        return franchiseService.getAllCharactersInFranchise(id);
    }

    /**
     *
     * @param franchise Franchise object sent trough Request Body to be added in franchise table in database
     * @return Response Entity with Franchise Entity object added and a
     *      corresponding HttpStatus if transaction was successful or not successful
     */
    @PostMapping
    public ResponseEntity<Franchise> addFranchise(@RequestBody Franchise franchise){
        return franchiseService.addFranchise(franchise);
    }

    /**
     *
     * @param franchise Franchise object sent trough Request Body to be updated in franchise table in database
     * @return Response Entity with Franchise Entity object updated and a
     *         corresponding HttpStatus if transaction was successful or not successful
     */
    @PutMapping
    public ResponseEntity<Franchise> updateFranchise(@RequestBody Franchise franchise){
        return franchiseService.updateFranchise(franchise);
    }

    /**
     *
     * @param id Long object sent as Path Variable representing Franchise Entity ID that we search for
     * @param movId Long object sent trough Request Body representing Movie Entity ID that we want to add in Movies List
     *               corresponding Franchise Entity
     * @return Response Entity with desired Franchise Entity object where Movie objects List is updated
     *         and a corresponding HttpStatus if transaction was successful or not successful
     */
    @PutMapping("/updateMovieInFranchise/{id}")
    public ResponseEntity<Franchise> updateMovieInFranchise(@PathVariable Long id, @RequestBody Long movId){
        return franchiseService.updateMovieInFranchise(id, movId);
    }

    /**
     *
     * @param id Long object sent as Path Variable representing Franchise Entity ID that we search for
     * @param movId Array of Long objects sent trough Request Body representing Movie Entity IDs that we want to add in Movies List
     *              corresponding Franchise Entity
     * @return Response Entity with desired Franchise Entity object where Movie objects are updated
     *         and a corresponding HttpStatus if transaction was successful or not successful
     */
    @PutMapping("/updateMoviesInFranchise/{id}")
    public ResponseEntity<Franchise> updateMoviesInFranchise(@PathVariable Long id, @RequestBody Long [] movId){
        return franchiseService.updateMoviesInFranchise(id, movId);
    }

    /**
     *
     * @param id  Long object sent as Path Variable representing Franchise Entity ID that we wish to remove from database
     * @return Response Entity with Long object representing the ID of the removed Franchise Entity
     *          and a corresponding HttpStatus if transaction was successful or not successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteFranchise(@PathVariable Long id){
        return franchiseService.deleteFranchise(id);
    }

}
