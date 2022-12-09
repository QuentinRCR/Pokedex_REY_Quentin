package models;

/**
 * Model to define a basic Pokemon
 */
public class Pokemon {

    private Long id;

    private String name;

    private Integer size;

    private Integer weight;

    public Pokemon(Long id, String name, Integer size, Integer weight) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getWeight() {
        return weight;
    }
}
