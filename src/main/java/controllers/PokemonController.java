package controllers;

import models.Pokemon;
import models.PokemonWithDescription;
import services.GeneralPokemonAccess;
import services.HttpRequest;
import services.SQLiteResquest;

import java.util.HashMap;

public class PokemonController {
    /**
     * Methode used to get the data
     */
    private GeneralPokemonAccess generalPokemonAccess;

    public PokemonController(GeneralPokemonAccess generalPokemonAccess) {
        this.generalPokemonAccess = generalPokemonAccess;
    }

    /**
     * Get a pokemon by its id
     * @param id Pokemon id
     * @return Pokemon
     */
    public Pokemon getPokemonById(Long id){

        HashMap pokemonHashMap=generalPokemonAccess.getPokemonById(id);

        //Insensate the Pokemon from the datas in the map
        Pokemon pokemon=null;
        if (generalPokemonAccess.getClass().equals(HttpRequest.class)) { //if it comes from the http request, there is no description
            pokemon = new Pokemon(id, pokemonHashMap.get("name").toString(), Integer.parseInt(pokemonHashMap.get("weight").toString()), Integer.parseInt(pokemonHashMap.get("height").toString()));
        } else if (generalPokemonAccess.getClass().equals(SQLiteResquest.class)) { //if it comes from the Db, there is a description
            pokemon = new PokemonWithDescription(id, pokemonHashMap.get("name").toString(), Integer.parseInt(pokemonHashMap.get("weight").toString()), Integer.parseInt(pokemonHashMap.get("height").toString()),pokemonHashMap.get("description").toString());
        }
        return pokemon;
    }
}
