/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entities.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Bruger
 */
@Path("animal")
public class AnimalResource {

    @Context
    private UriInfo context;
    
    ArrayList<Animal> animals = new ArrayList<>();
//    Animal dog = new Animal("dog", 2011, "vuf");
//    Animal duck = new Animal("duck", 2016, "quack");
//    Animal cow = new Animal("cow", 2006, "moo");
//    animals.
    //animals.add(new Animal("dog", 2011, "vuf"));

    /**
     * Creates a new instance of AnimalResource
     */
    public AnimalResource() {
    }
    
    public ArrayList<Animal> makeAnimalList(){
            ArrayList<Animal> animals = new ArrayList<>();
    Animal dog = new Animal("dog", 2011, "vuf");
    Animal duck = new Animal("duck", 2016, "quack");
    Animal cow = new Animal("cow", 2006, "moo");
    Animal frog = new Animal("Frog", 2018, "Ribbit");
    animals.add(dog);
    animals.add(duck);
    animals.add(cow);
    animals.add(frog);
        return animals;
    }
    
    public int randomNumb(int size){
        Random random = new Random();
        int rand = random.nextInt(size);
        return rand;
    }

    /**
     * Retrieves representation of an instance of rest.AnimalResource
     * @return an instance of java.lang.String
     */
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "hello my first web service";
    }
    
    @GET
    @Path("random")
    @Produces(MediaType.APPLICATION_JSON)
        public String getRandomString() {
        ArrayList<Animal> animals = makeAnimalList();
        Animal randAni = animals.get(randomNumb(animals.size()));
        
        Gson gson = new Gson();
        String randAniAsJson = gson.toJson(randAni);
        return randAniAsJson;
        
        //return "This string isnt actually random";
       
    }

    /**
     * PUT method for updating or creating an instance of AnimalResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
