package se.experis.assignment3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.assignment3.models.Character;
import se.experis.assignment3.service.CharacterService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/characters")
public class CharacterController {


    @Autowired
    private CharacterService characterService;

    /**
     *
     * @return Response Entity with a List of all the Character Entities in database and
     * a corresponding HttpStatus if transaction was successful or not successful
     *
     */
    @GetMapping
    public ResponseEntity<List<Character>> getAllCharacters(){
        return characterService.getAllCharacters();
    }

    /**
     *
     * @param id Long object sent as Path Variable representing Character Entity ID that we search for
     * @return  Response Entity with Character Entity object with the desired ID and a
     * corresponding HttpStatus if transaction was successful or not successful
     */
    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacter(@PathVariable Long id) {
        return characterService.getCharacterById(id);
    }

    /**
     *
     * @param character Character object sent trough Request Body to be added in character table at database
     * @return Response Entity with Character Entity object added and a
     *      corresponding HttpStatus if transaction was successful or not successful
     */
    @PostMapping
    public ResponseEntity<Character> addCharacter(@RequestBody Character character){
        return characterService.addCharacter(character);
    }

    /**
     *
     * @param character Character object sent trough Request Body to be updated in character table at database
     * @return Response Entity with Character Entity object updated and a
     *         corresponding HttpStatus if transaction was successful or not successful
     */
    @PutMapping
    public ResponseEntity<Character> updateCharacter(@RequestBody Character character){
        return characterService.updateCharacter(character);
    }

    /**
     *
     * @param id  Long object sent as Path Variable representing Character Entity ID that we wish to remove from database
     * @return Response Entity with Long object representing the ID of the removed Character Entity
     *          and a corresponding HttpStatus if transaction was successful or not successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteCharacter(@PathVariable Long id){
        return characterService.deleteCharacter(id);
    }

}
