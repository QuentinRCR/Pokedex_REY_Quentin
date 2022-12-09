package views;

import models.Pokemon;

public class FormatPokemonToText implements OutputGeneratorToTextInterface {
    Pokemon pokemon;

    public FormatPokemonToText(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    /**
     * Format the data to the desired forme
     * @param pokemon
     * @return
     */
    public String formatInfo(Pokemon pokemon){
        return  "Pokémon #"+pokemon.getId()+"\n" +
                "Nom : "+pokemon.getName()+"\n" +
                "Taille : "+pokemon.getSize()+"\n" +
                "Poids : "+pokemon.getWeight()+"\n";
    }

    /**
     * Format the text to the desired form
     * @return
     */
    public String generateText() {
        return "\n\n=============================\n" +
                formatInfo(pokemon)+
                "=============================\n\n";
    }


}
