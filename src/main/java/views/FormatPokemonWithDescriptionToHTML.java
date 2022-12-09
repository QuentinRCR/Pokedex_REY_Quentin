package views;

import models.Pokemon;
import models.PokemonWithDescription;

public class FormatPokemonWithDescriptionToHTML extends FormatPokemonToHTML {

    public FormatPokemonWithDescriptionToHTML(Pokemon pokemon) {
        super(pokemon);
    }

    /**
     * add the description to the basic formatting of Pokemon
     * @param pokemon
     * @return
     */
    @Override
    public String formatInfo(Pokemon pokemon) {
        return super.formatInfo(pokemon)+"<li>Description : "+((PokemonWithDescription) pokemon).getDescription()+"</li>\n";
    }
}
