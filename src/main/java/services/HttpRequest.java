package services;

import models.Pokemon;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class HttpRequest implements GeneralPokemonAccess {

    public HttpRequest() {
    }

    /**
     * Return a Map containing datas on Pokemons
     * @param id
     * @return
     */
    public HashMap getPokemonById(Long id) {
        HashMap elements = new HashMap<>();
        String jsonResponse = "";
        try {
            //Fetch data from the API
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/"+id);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");

            //Transform this data to a HashMap
            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(jsonResponse);
            if (resultObject instanceof JSONObject) {
                JSONObject obj = (JSONObject) resultObject;
                elements.put("name",obj.get("name").toString());
                elements.put("weight",Integer.parseInt(obj.get("weight").toString()));
                elements.put("height",Integer.parseInt(obj.get("height").toString()));
            } else {
                System.err.println("Error, we expected a JSON Object from the API");
            }
        }
        catch (ParseException e) {
            System.err.println("Could not parse the response given by the API as JSON");
            System.err.println("Response body is :");
            System.err.println(jsonResponse);
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return elements;
    }
}
