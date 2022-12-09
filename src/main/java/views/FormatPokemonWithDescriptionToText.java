package views;

import models.Pokemon;
import models.PokemonWithDescription;

public class FormatPokemonWithDescriptionToText extends FormatPokemonToText {

    public FormatPokemonWithDescriptionToText(Pokemon pokemon) {
        super(pokemon);
    }

    /**
     * add the description to the basic formatting of Pokemon
     * @param pokemon
     * @return
     */
    @Override
    public String formatInfo(Pokemon pokemon) {
        return super.formatInfo(pokemon)+"Description : "+((PokemonWithDescription) pokemon).getDescription()+"\n";
    }
}
