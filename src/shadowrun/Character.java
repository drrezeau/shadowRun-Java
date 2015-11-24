/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shadowrun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class Character {
    //necessary information about the character
    private String player;
    private String name;
    private String alias;
    
    private String metatype;
    private Integer age;
    private Integer height;
    private Integer weight;
    private String sex;
    private Integer karma;
    
    //the character attributes
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
    private ArrayList<Contact> contacts;
    private ArrayList<MeleeWeapons> meleeWeapons;
    private ArrayList<RangedWeapon> rangedWeapons;
    private ArrayList<Armor> armor;

    private boolean characterLoaded = false;
    
    Character() {
        skills = new ArrayList();
        qualities = new ArrayList();
        contacts = new ArrayList();
        meleeWeapons = new ArrayList();
        rangedWeapons = new ArrayList();
        armor = new ArrayList();
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
//            sex = sex.toUpperCase();
            if (!(sex.equalsIgnoreCase("Male") || sex.equalsIgnoreCase("Female")))
                System.out.println("Error. Wrong input entered. Try Again.");
        } while (!(sex.equalsIgnoreCase("Male") || sex.equalsIgnoreCase("Female")));
        
        //Keep Looping until input is valid
        do {
            System.out.println("What is the character's metatype?(Human, Elf, Dwarf, Ork, Troll)");
            System.out.print(">");
            this.metatype = user_input.nextLine();
            if (!(metatype.equalsIgnoreCase("Human") || metatype.equalsIgnoreCase("Elf") || metatype.equalsIgnoreCase("Dwarf")
                || metatype.equalsIgnoreCase("Ork") || metatype.equalsIgnoreCase("Troll"))) {
                System.out.println("Error. Wrong input entered. Try Again.");
            }
        } while (!(metatype.equalsIgnoreCase("Human") || metatype.equalsIgnoreCase("Elf") || metatype.equalsIgnoreCase("Dwarf")
                || metatype.equalsIgnoreCase("Ork") || metatype.equalsIgnoreCase("Troll")));


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
        
        do {
            System.out.println("What is the rating?");
            System.out.print(">");
            rating = Integer.parseInt(user_input.next());
            if (rating > 12) {
                System.out.println("Number is too large. Try again.");
            }
        } while (rating > 12);
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
    void addNewContact() {
        Scanner user_input = new Scanner( System.in );

        String name;
        int loyalty, connection;
        String favor;
        System.out.println("What is the name of your contact?");
        System.out.print(">");
        name = user_input.nextLine();
        
        System.out.println("How loyal are they to you?");
        System.out.print(">");
        loyalty = Integer.parseInt(user_input.nextLine());
        
        System.out.println("How strong is your connection to them?");
        System.out.print(">");
        connection = Integer.parseInt(user_input.nextLine());
        
        System.out.println("What favors do they owe you?");
        System.out.print(">");
        favor = user_input.nextLine();
        
        Contact contact = new Contact(name, loyalty, connection, favor);
        contacts.add(contact);
    }
    
    /*******************************************************
    /*******************************************************
     *********** Functions for Adding new Traits ***********
     *******************************************************/
    void deleteSkill() {
       //TODO
    }
    void deleteQuality() {
         String qualityName;
         System.out.println("What qaulity would you like to delete?");
         //TODO
     }
    void deleteContact() {
        //TODO
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
    void displayContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            contacts.get(i).display();
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
        System.out.println("Character's Metatype: " + this.metatype + "\n");
        
        System.out.println("--- SKILLS ---");
        this.displaySkills();
        System.out.println("--- QUALITIES ---");
        this.displayQualities();
        System.out.println("--- CONTACTS ---");
        this.displayContacts();
        System.out.println("--- MELEE WEAPONS ---");
        System.out.println("--- RANGED WEAPONS ---");
        System.out.println("--- ARMOR ---");
        System.out.println("--- ITEMS ---");
    }
    
    /*****************************************************
     ************* Functions For Database ****************
     *****************************************************/
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static final String DB_URL = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/heroku_77540a9be8a2f22"; //**HEROKU
//    static final String DB_URL = "jdbc:mysql://localhost/EM"; //**Local

    //  Database credentials
   static final String USER = "b120a816248bc1"; //** Heroku
//    static final String USER = "root"; //**Local
   static final String PASS = "4821acef"; //** Heroku
//    static final String PASS = "root"; //**Local
    
    void saveToDB() {
        String skillsToSave = "";
        String qualitiesToSave = "";
        String contactsToSave = "";
        String meleeWeaponsToSave = "";
        String armorToSave = "";
        String rangedWeaponsToSave = "";
        String itemsToSave = "";
        
        for (int i = 0; i < skills.size(); i++) {
            skillsToSave += skills.get(i).prepareForDB() + ";";
        }
//        System.out.println(skillsToSave);
        
        for (int i = 0; i < qualities.size(); i++) {
            qualitiesToSave += qualities.get(i).prepareForDB() + ";";
        }
//        System.out.println(qualitiesToSave);
        
        for (int i = 0; i < contacts.size(); i++) {
            contactsToSave += contacts.get(i).prepareForDB() + ";";
        }
//        System.out.println(contactsToSave);

        String sql = new String();
        Connection conn = makeConn();
        
        if (this.characterLoaded) { //updating a character already in the DB
            sql = "UPDATE characters SET player='" + this.player + "', characterName='" + this.name + "', alias='" + this.alias 
                    + "', age=" +this.age + ", height=" + this.height + ", weight=" + this.weight + ", metatype='" + this.metatype 
                    + "', sex='" + this.sex + "', skills='" + skillsToSave + "', qualities='" + qualitiesToSave + "', contacts='" + contactsToSave 
                    + "', meleeWeapons='" + meleeWeaponsToSave + "', armor='" + armorToSave + "', rangedWeapons='" + rangedWeaponsToSave 
                    + "', items='" + itemsToSave //add new Items here
                    + "' WHERE characterName='" + this.name + "';";

        } else { //saving a new character into the database
            sql = "INSERT INTO characters (player, characterName, alias, age, height, weight, metatype, sex, skills, qualities, contacts, "
                    + "meleeWeapons, armor, rangedWeapons, items) VALUES ('"
                    + this.player + "', '" + this.name + "', '" + this.alias + "', " +this.age + ", " + this.height + ", " + this.weight + ", '" 
                    + this.metatype + "', '" + this.sex + "', '" + skillsToSave + "', '" + qualitiesToSave + "', '" + contactsToSave + "', '" 
                    + meleeWeaponsToSave + "', '" + armorToSave + "', '" + rangedWeaponsToSave + "', '" + itemsToSave + "');";
        }
        
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    void loadFromDB() {
        this.characterLoaded = true;
        String skillsFromDB = new String();
        String skillsTemp[];
        String qualitiesFromDB = new String();
        String qualitiesTemp[];
        String contactsFromDB = new String();
        String contactsTemp[];

        
        
        
        Scanner user_input = new Scanner( System.in );
        String characterName;
        System.out.println("What character do you wish to load?");
        System.out.print(">");
        characterName = user_input.nextLine();
        
        Connection conn = makeConn();
        System.out.println("Creating statement...");
        try {
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM characters WHERE characterName='"+characterName+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Gather all the variables and save them into their spots
                System.out.println(rs.getString("player"));
                this.player = rs.getString("player");
                this.name = rs.getString("characterName");
                this.alias = rs.getString("alias");
                this.age = rs.getInt("age");
                this.height = rs.getInt("height");
                this.weight = rs.getInt("weight");
                this.sex = rs.getString("sex");
                this.metatype = rs.getString("metatype");
                skillsFromDB = rs.getString("skills");
                qualitiesFromDB = rs.getString("qualities");
                contactsFromDB = rs.getString("contacts");
                
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        
        //Parsing through the Strings to save into the vectors
        if (!(skillsFromDB.isEmpty())) {
            skillsTemp = skillsFromDB.split(";");
            
            for (int i = 0; i < skillsTemp.length; i++) {
                String temp[] = skillsTemp[i].split(":");
                Skill skilltemp = new Skill(temp[0], Integer.parseInt(temp[1]));
                this.skills.add(skilltemp);
            }
        }
        System.out.println(qualitiesFromDB.isEmpty());
        if (!(qualitiesFromDB.isEmpty())) {
            qualitiesTemp = qualitiesFromDB.split(";");
            
            for (int i = 0; i < qualitiesTemp.length; i++) {
               String temp[] = qualitiesTemp[i].split(":");
                Quality qualitytemp = new Quality(temp[0], temp[1], Boolean.parseBoolean(temp[2]));
                this.qualities.add(qualitytemp);
            }
        }
        if (!(contactsFromDB.isEmpty())) {
            contactsTemp = contactsFromDB.split(";");
            
            for (int i = 0; i < contactsTemp.length; i++) {
                String temp[] = contactsTemp[i].split(":");
                Contact contactTemp;
                if (temp.length < 4) {
                    contactTemp = new Contact(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), "");
                } else {
                    contactTemp = new Contact(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), temp[3]);
                }
                this.contacts.add(contactTemp);
            }
        }       
    }
   
    private static Connection makeConn() {
        Connection conn = null;
        try{
        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
//        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }catch(Exception se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        return conn;
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
