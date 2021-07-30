package se.experis.assignment3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.experis.assignment3.models.Character;
import se.experis.assignment3.repositories.CharacterRepository;

import java.util.List;

@Service
public class CharacterService {
    /**
     * Autowired repositories for Character Entity in our database
     */
    @Autowired
    private CharacterRepository characterRepository;

    /**
     *
     * @return Response Entity with a list of all the Character Entities in the database and
     * a corresponding HttpStatus if transaction was successful or not successful
     *
     */
    public ResponseEntity<List<Character>> getAllCharacters(){
        List<Character> characters = characterRepository.findAll();
        if(!characters.isEmpty()) {
            return new ResponseEntity<>(characters, HttpStatus.OK);
        } else return new ResponseEntity<>(characters, HttpStatus.NO_CONTENT);
    }

    /**
     *
     * @param id Long object representing Character Entity ID that we search for
     * @return  Response Entity with Character Entity object with the desired ID and a
     * corresponding HttpStatus if transaction was successful or not successful
     */
    public ResponseEntity<Character> getCharacterById(Long id) {
        var returnCharacter = new Character();
        if(characterRepository.existsById(id)){
            returnCharacter = characterRepository.findById(id).get();
        return new ResponseEntity<>(returnCharacter,HttpStatus.OK);
        } else return new ResponseEntity<>(returnCharacter, HttpStatus.NO_CONTENT);
    }

    /**
     *
     * @param character Character object to be added in character table in database
     * @return Response Entity with Character Entity object added and a
     *      corresponding HttpStatus if transaction was successful or not successful
     */
    public ResponseEntity<Character> addCharacter(Character character){
        var returnCharacter = new Character();
        if(character != null) {
            returnCharacter = characterRepository.save(character);
            return new ResponseEntity<>(returnCharacter, HttpStatus.CREATED);
        } else return new ResponseEntity<>(returnCharacter, HttpStatus.NO_CONTENT);
    }

    /**
     *
     * @param character Character object to be updated in character table in database
     * @return Response Entity with Character Entity object updated and a
     *         corresponding HttpStatus if transaction was successful or not successful
     */
    public ResponseEntity<Character> updateCharacter(Character character) {
        var returnCharacter = new Character();
        if(!characterRepository.existsById(character.getId())){
            return new ResponseEntity<>(returnCharacter,HttpStatus.BAD_REQUEST);
        }
        returnCharacter = characterRepository.save(character);
        return new ResponseEntity<>(returnCharacter, HttpStatus.NO_CONTENT);
    }

    /**
     *
     * @param id  Long object representing Character Entity ID that we wish to remove from database
     * @return Response Entity with Long object representing the ID of the removed Character Entity
     *          and a corresponding HttpStatus if transaction was successful or not successful
     */
    public ResponseEntity<Long> deleteCharacter(Long id){
        if(characterRepository.existsById(id)) {
            characterRepository.deleteById(id);
            return new ResponseEntity<>(id,HttpStatus.OK);
        }else return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
    }
}
