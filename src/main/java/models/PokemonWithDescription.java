package models;

/**
 * Model to that add a description to the basic Pokemon class
 */
public class PokemonWithDescription extends Pokemon{

    String description;

    public PokemonWithDescription(Long id, String name, Integer size, Integer weight, String description) {
        super(id, name, size, weight);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
