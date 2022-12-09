package services;

import java.util.HashMap;

/**
 * Interface instantiated by all the dataSource from with it is possible to get Pokemon infos
 */
public interface GeneralPokemonAccess {

    public HashMap getPokemonById(Long id);
}
