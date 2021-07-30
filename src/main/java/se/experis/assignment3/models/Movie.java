package se.experis.assignment3.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private int year;
    private String director;
    private String picture;
    private String trailer;

    /**
     * Annotation that creates middle table between Character entity and Movie Entity
     */
    @JoinTable(
            name = "character_movie",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )

    /**
     * List of Characters in a Movie Entity
     */
    @Nullable
    @ManyToMany
    public List<Character> characters;

    /**
     * @return List of string url links per Character that belongs to each Movie entity
     */
    @Nullable
    @JsonGetter("characters")
    public List<String> characters() {
        return characters.stream()
                .map(character -> {
                    return "/api/characters/" + character.getId();
                }).collect(Collectors.toList());
    }

    /**
     * Franchise Entity that belongs to each Movie Entity
     */
    @Nullable
    @ManyToOne
    @JoinColumn(name = "franchise_id")
    public Franchise franchise;

    /**
     *  String of url link of Franchise entity that belong to each Movie entity
     * @return
     */
    @Nullable
    @JsonGetter("franchise")
    public String franchises() {
        if(!(franchise == null)){
        return "/api/franchises/" + franchise.getId();
        } else return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}
