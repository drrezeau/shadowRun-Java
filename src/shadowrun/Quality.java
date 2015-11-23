/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shadowrun;

/**
 *
 * @author c
 */
public class Quality {
    private String name;
    private String note;
    private boolean positive;
    
    Quality(String name, String note, boolean positive) {
        this.name = name;
        this.note = note;
        this.positive = positive;
    }
    
    String prepareForDB() {
        return name + ":" + note + ":" + positive;
    }
    
    void display() {
        System.out.println("Quality: " + name + " | Notes: " + note + " | " + positive);
    }
}
