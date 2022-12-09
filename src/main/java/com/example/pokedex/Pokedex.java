package com.example.pokedex;


import controllers.PokemonController;
import models.Pokemon;
import services.HttpRequest;
import services.SQLiteResquest;
import utilities.ConsoleLogUtility;
import utilities.FileLogUtility;
import views.OutputGeneratorToHTMLInterface;
import views.OutputGeneratorToTextInterface;
import views.*;

import java.io.IOException;

public class Pokedex {

    public static void main(String[] args) throws IOException {

        //Only the pokemon id is provided
        if (args.length == 1) {
            //Define the method to get the data
            PokemonController pokemonController =new PokemonController(new HttpRequest());
            Pokemon pokemon = pokemonController.getPokemonById(Long.parseLong(args[0]));

            //Format to text and print to the console
            OutputGeneratorToTextInterface formattedPokemon = new FormatPokemonToText(pokemon); //Instantiate the logger with the logger for the console
            ConsoleLogUtility.logTextToConsole(formattedPokemon);

            //format to HTML and save to the file "pokemon.html"
            OutputGeneratorToHTMLInterface formatPokemon1 = new FormatPokemonToHTML(pokemon);
            FileLogUtility.logHtmlToFile(".//pokemon.html",formatPokemon1);

           //The Pokemeon id and the path to the SQLight DB is provided (ex of path: ../sujet_TP/ressources/pokemondatabase.sqlite)
        } else if (args.length == 2) {
            //Define the method to get the data
            PokemonController pokemonController =new PokemonController(new SQLiteResquest(args[1])); //Use General Pokemon access with HTTPRequest
            Pokemon pokemon = pokemonController.getPokemonById(Long.parseLong(args[0]));


            //Format to text and print to the console
            OutputGeneratorToTextInterface formatPokemon = new FormatPokemonWithDescriptionToText(pokemon); //Instantiate the logger with the logger for the console
            ConsoleLogUtility.logTextToConsole(formatPokemon);

            //format to HTML and save to the file "pokemon.html"
            OutputGeneratorToHTMLInterface formatPokemon1 = new FormatPokemonWithDescriptionToHTML(pokemon);
            FileLogUtility.logHtmlToFile(".//pokemon.html",formatPokemon1);
        } else{
            System.out.println("Not the number of arguments required");
        }

    }
}
