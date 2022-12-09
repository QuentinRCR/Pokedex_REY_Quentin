package services;

import netscape.javascript.JSObject;
import org.apache.http.util.EntityUtils;

import java.sql.*;
import java.util.HashMap;

public class SQLiteResquest implements GeneralPokemonAccess{

    String path;

    public SQLiteResquest(String url) {
        this.path = url;
    }

    /**
     * Return a Map containing datas on Pokemons with description
     * @param id
     * @return
     */
    public HashMap getPokemonById(Long id){
        HashMap elements = new HashMap();

        Connection conn = null;
        try {
            //Get the data from the DB

            String url = "jdbc:sqlite:"+path; //set path to the DB. Ex: ../sujet_TP/ressources/pokemondatabase.sqlite";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            PreparedStatement stmt  = conn.prepareStatement("SELECT * FROM pokemons WHERE id = ?");
            stmt.setInt(1, Integer.parseInt(id.toString())); //the second one in the ID of the Pokemon
            ResultSet rs    = stmt.executeQuery();
            rs.next();


            //Transform the data to a Map
            elements.put("name",rs.getString("name"));
            elements.put("weight",rs.getString("weight"));
            elements.put("height",rs.getString("height"));
            elements.put("description",rs.getString("description"));
            System.out.println("Pokémon name : " + rs.getString("name"));
            System.out.println("Pokémon description : " + rs.getString("description"));


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return elements;
    }
}
