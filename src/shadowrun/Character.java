/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shadowrun;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class Character {
    String player;
    String name;
    String alias;
    
    String metatype;
    Integer age;
    Integer height;
    Integer weight;
    Integer karma;
    
    Integer body;
    Integer agility;
    Integer reaction;
    Integer strength;
    Integer willpower;
    Integer logic;
    Integer intuition;
    Integer charisma;
    Integer edge;
    
    Integer essence;
    boolean hasMagic;
    Integer magic;
    
    ArrayList<Skill> skills;
    ArrayList<Quality> positiveQualities;
    ArrayList<Quality> negativeQualities;
    ArrayList<Contacts> contacts;
    ArrayList<MeleeWeapons> meleeWeapons;
    ArrayList<RangedWeapon> rangedWeapons;
    ArrayList<Armor> armor;
    
    
    Character() {
        skills = new ArrayList();
        positiveQualities = new ArrayList();
    }
    
     void addNewSkill() {
        Scanner user_input = new Scanner( System.in );
        
        String skillName;
        Integer rating;
        
        System.out.println("What is the name of the skill?");
        System.out.print(">");
        skillName = user_input.nextLine();
        
        System.out.println("What is the rating?");
        System.out.print(">");
        rating = Integer.parseInt(user_input.next());
        Skill skill = new Skill();
        skill.addSkill(skillName, rating);
//        skill.display();
        skills.add(skill);
    }
    
    void displaySkills() {
        int length = skills.size();
        for (int i = 0; i < length; i++) {
//            System.out.println("Skill: " + skills.get(i).getSkill() + " Rating: " + skills.get(i).getRating());
            skills.get(i).display();
        }
    }
    
    public String getPlayer() {
        return player;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getBody() {
        return body;
    }
    public void setBody(Integer body) {
        this.body = body;
    }

    public Integer getAgility() {
        return agility;
    }
    public void setAgility(Integer agility) {
        this.agility = agility;
    }

    public Integer getReaction() {
        return reaction;
    }
    public void setReaction(Integer reaction) {
        this.reaction = reaction;
    }

    public Integer getStrength() {
        return strength;
    }
    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getWillpower() {
        return willpower;
    }
    public void setWillpower(Integer willpower) {
        this.willpower = willpower;
    }

    public Integer getLogic() {
        return logic;
    }
    public void setLogic(Integer logic) {
        this.logic = logic;
    }

    public Integer getIntuition() {
        return intuition;
    }
    public void setIntuition(Integer intuition) {
        this.intuition = intuition;
    }

    public Integer getCharisma() {
        return charisma;
    }
    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    public Integer getEdge() {
        return edge;
    }
    public void setEdge(Integer edge) {
        this.edge = edge;
    }
    
    void createCharacter() {
        Scanner user_input = new Scanner( System.in );
        
        System.out.print("What is your name? ");
        this.player = user_input.nextLine();
        
    }
    
    void saveToDB() {
        String skillsToSave = "";
        
        for (int i = 0; i < skills.size(); i++) {
            skillsToSave += skills.get(i).prepareForDB() + ";";
        }
        
//        System.out.println(skillsToSave);
    }
}
