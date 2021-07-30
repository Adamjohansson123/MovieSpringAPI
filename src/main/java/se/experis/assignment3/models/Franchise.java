package se.experis.assignment3.models;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    /**
     *  List of Movie entities in a Franchise Entity
     */
    @Nullable
    @OneToMany
    @JoinColumn(name = "franchise_id")
    public List<Movie> movies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
