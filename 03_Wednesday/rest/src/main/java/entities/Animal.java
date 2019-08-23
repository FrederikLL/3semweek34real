/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Bruger
 */
public class Animal {
    private String type;
    private int birthyear;
    private String sound;
    
    public Animal(String type, int birthyear, String sound){
        this.type = type;
        this.birthyear = birthyear;
        this.sound = sound;
    }
    
    public Animal(){}
    
    
    
}
