/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shadowrun;

/**
 *
 * @author David
 */
public class Skill {
    String skill;
    Integer rating;

    public String getSkill() {
        return skill;
    }
    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    
    void addSkill(String name, Integer rating) {
        this.skill = name;
        this.rating = rating;
    }
    
     void display() {
         System.out.println("Skill: " + this.skill + " | Rating: " + this.rating);
     }
     
     String prepareForDB() {
         String skillToReturn = this.skill + ":" + this.rating;
         
         return skillToReturn;
     }
    
}
