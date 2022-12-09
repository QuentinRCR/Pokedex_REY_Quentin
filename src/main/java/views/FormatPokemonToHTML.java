package views;

import models.Pokemon;

public class FormatPokemonToHTML implements OutputGeneratorToHTMLInterface {

    Pokemon pokemon;

    public FormatPokemonToHTML(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    /**
     * Format the data to the desired forme
     * @param pokemon
     * @return
     */
    public String formatInfo(Pokemon pokemon){
        return  String.format("<h1>%s</h1>\n" +
                "<ul>\n" +
                "<li>Id : %s</li>\n" +
                "<li>Taille : %s</li>\n" +
                "<li>Poids : %s</li>\n",pokemon.getName(),pokemon.getId(),pokemon.getSize(),pokemon.getSize());
    }

    /**
     * Format the text to the desired html forme
     * @return
     */
    public String generateHtml() {
        return formatInfo(pokemon)+"</ul>";
    }
}
