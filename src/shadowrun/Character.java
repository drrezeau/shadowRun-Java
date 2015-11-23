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
    private String player;
    private String name;
    private String alias;
    
    private String metatype;
    private Integer age;
    private Integer height;
    private Integer weight;
    private String sex;
    private Integer karma;
    
    private Integer body;
    private Integer agility;
    private Integer reaction;
    private Integer strength;
    private Integer willpower;
    private Integer logic;
    private Integer intuition;
    private Integer charisma;
    private Integer edge;
    
    private Integer essence;
    private boolean hasMagic;
    private Integer magic;
    
    private ArrayList<Skill> skills;
    private ArrayList<Quality> qualities;
    private ArrayList<Contacts> contacts;
    private ArrayList<MeleeWeapons> meleeWeapons;
    private ArrayList<RangedWeapon> rangedWeapons;
    private ArrayList<Armor> armor;    
    
    Character() {
        skills = new ArrayList();
        qualities = new ArrayList();
        contacts = new ArrayList();
    }
    
    
    void createCharacter() {
        Scanner user_input = new Scanner( System.in );
        
        System.out.println("What is The player's name? ");
        System.out.print(">");
        this.player = user_input.nextLine();
        
        System.out.println("What Is the character's name?");
        System.out.print(">");
        this.name = user_input.nextLine();
        
        System.out.println("What is the character's alias?");
        System.out.print(">");
        this.alias = user_input.nextLine();
        
        System.out.println("What is the character's age?");
        System.out.print(">");
        this.age = Integer.parseInt(user_input.nextLine());

        System.out.println("What is the character's Height(Inches)?");
        System.out.print(">");
        this.height = Integer.parseInt(user_input.nextLine());
        
        System.out.println("What is the character's Weight(Pounds)?");
        System.out.print(">");
        this.weight = Integer.parseInt(user_input.nextLine());

        do {
            System.out.println("Are you Male or Female?");
            System.out.print(">");
            this.sex = user_input.nextLine();
        } while (!sex.equals("Male") || !sex.equals("Female"));
        
        System.out.println("What is the character's metatype?(Human, Elf, Dwarf, Ork, Troll)");
        System.out.print(">");
        this.sex = user_input.nextLine();


    }
    
    /*******************************************************
     *********** Functions for Adding new Traits ***********
     *******************************************************/
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
        Skill skill = new Skill(skillName, rating);
        skills.add(skill);
    }
    void addNewQuality() {
         Scanner user_input = new Scanner( System.in );
         
         String qualityName;
         String notes;
         String positiveChar;
         boolean positive = false;
         
         System.out.println("What is the name of the quality?");
         System.out.print(">");
         qualityName = user_input.nextLine();
         System.out.println("Are there any notes to put with the quality?");
         System.out.print(">");
         notes = user_input.nextLine();
         System.out.println("Is this a positive quality?(Y OR N)");
         System.out.print(">");
         positiveChar = user_input.next();
         
         if (positiveChar.toUpperCase().equals("Y")) {
             positive = true;
         }
         
         Quality quality = new Quality(qualityName, notes, positive);
         qualities.add(quality);
     }
    
    /*******************************************************
     *********** Functions for Displaying Traits ***********
     *******************************************************/
    void displaySkills() {
        int length = skills.size();
        for (int i = 0; i < length; i++) {
//            System.out.println("Skill: " + skills.get(i).getSkill() + " Rating: " + skills.get(i).getRating());
            skills.get(i).display();
        }
        System.out.println();
    }
    void displayQualities() {
        for (int i = 0; i < qualities.size(); i++) {
            qualities.get(i).display();
        }
        System.out.println();
    }
        
    void displayCharacter() {
        System.out.println("Player's Name: " + this.player);
        System.out.println("Character's Name: " + this.name);
        System.out.println("Character's Alias: " + this.alias);
        System.out.println("Character's Age: " + this.age);
        System.out.println("Character's Height: " + this.height + "(inches)");
        System.out.println("Character's Weight: " + this.weight + "(pounds)");
        System.out.println("Character's Sex: " + this.sex);
        

        this.displaySkills();
        this.displayQualities();
    }
    
    /*****************************************************
     ************* Functions For Database ****************
     *****************************************************/
    void saveToDB() {
        String skillsToSave = "";
        String qualitiesToSave = "";
        String contactsToSave = "";
        
        for (int i = 0; i < skills.size(); i++) {
            skillsToSave += skills.get(i).prepareForDB() + ";";
        }
        
        System.out.println(skillsToSave);
        
        for (int i = 0; i < qualities.size(); i++) {
            qualitiesToSave += qualities.get(i).prepareForDB() + ";";
        }
        
        System.out.println(qualitiesToSave);
        
        for (int i = 0; i < contacts.size(); i++) {
            contactsToSave += contacts.get(i).prepareForDB();
        }
        
        System.out.println(contactsToSave);
    }
    void loadFromDB() {
        player = "David";
        name = "Kel";
        
        //Test strings for DB
        String skillsFromDB = "a:3;b:5;";
        String skillsTemp[] = skillsFromDB.split(";");
        String qualitiesFromDB = "ab:qwerty:true;cd:password:false;";
        String qualitiesTemp[] = qualitiesFromDB.split(";");
        
        
        
        
        for (int i = 0; i < skillsTemp.length; i++) {
            String temp[] = skillsTemp[i].split(":");
            Skill skilltemp = new Skill(temp[0], Integer.parseInt(temp[1]));
            this.skills.add(skilltemp);
        }
        
        for (int i = 0; i < qualitiesTemp.length; i++) {
            String temp[] = qualitiesTemp[i].split(":");
            Quality qualitytemp = new Quality(temp[0], temp[1], Boolean.parseBoolean(temp[2]));
            this.qualities.add(qualitytemp);
        }
    }
    
     /*******************************************************
     **************** Getters and Setters *******************
     *******************************************************/
   
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

}
