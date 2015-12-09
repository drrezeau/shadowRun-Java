/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shadowrun;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class ShadowRun {

    public static void main(String[] args) {
        Scanner user_input = new Scanner( System.in );
        
        Character myCharacter = new Character();
        
        
        int command;
        boolean characterCreated = false;
        mainMenu();
        System.out.println("What would you like to do?");
        System.out.print(">");
        command = Integer.parseInt(user_input.next());
        
        switch(command) {
                case 1:
                    myCharacter.createCharacter();
                    characterCreated = true;
//                    System.out.println(myCharacter.getPlayer());
                    break;
                case 2:
                    displayDBCharacters();
                    characterCreated = myCharacter.loadFromDB();
                    if (!characterCreated) {
                        System.out.println("Creating new Character...");
                        myCharacter.createCharacter();
                        characterCreated = true;
                    }
                    break;
                default:
                    System.out.println("Not an option -- Leaving program.");
                    command = 0;
                    break;

            }
        do {
            if (characterCreated) {
                characterMenu();
            
            System.out.println("\nWhat would you like to do?");
            System.out.print(">");
            command = Integer.parseInt(user_input.next());
            
            
                switch(command) {
                case 1:
                    myCharacter.displayCharacter();
                    break;
                case 2:
                    manageSkills(myCharacter);
                    break;
                case 3:
                    manageQualities(myCharacter);
                    break;
                case 4:
                    manageContacts(myCharacter);
                    break;
                case 5:
                    manageMeleeWeapons(myCharacter);
                    break;
                case 15:
                    myCharacter.saveToDB();
                    break;
                default:
                    System.out.println("Not an option -- Leaving program.");
                    command = 0;
                    break;

                }
            }
        } while(command != 0);
    }
 
    /******************************************************
    /******************** Main Menu ***********************
    /******************************************************/
    static void mainMenu() {
        System.out.println("1.Create new Character");
        System.out.println("2.Load Character");
//        System.out.println("3.Show Menu");
    }
    static void characterMenu() {
        System.out.println("\n1.Display Character Stats");
        System.out.println("2.Manage Skills");
        System.out.println("3.Manage Qualities");
        System.out.println("4.Manage Contacts");
        System.out.println("5.Manage Melee Weapons");
        System.out.println("15.Save to DB");
        System.out.println("0.Close Program");
    }
    
    /******************************************************
    /***************** Individual Menus *******************
    /******************************************************/
    static void manageSkills(Character myCharacter) {
        Scanner user_input = new Scanner( System.in );
        int command;
        
        do {
            System.out.println("\n1.Show Skills");
            System.out.println("2.Add Skill");
            System.out.println("3.Delete Skill");
            System.out.println("0.Go Back to Menu");
            
            System.out.println("\nWhat would you like to do?");
            System.out.print(">");
            command = Integer.parseInt(user_input.next());
            
            switch(command) {
                case 1:
                    myCharacter.displaySkills();
                    break;
                case 2:
                    myCharacter.addNewSkill();
                    break;
                case 3:
                    myCharacter.deleteSkill();
                    break;
                default:
                    command = 0;
                    break;
            }
        } while (command != 0);
    }
    static void manageQualities(Character myCharacter) {
        Scanner user_input = new Scanner( System.in );
        int command;
        
        do {
            System.out.println("\n1.Display Qualities");
            System.out.println("2.Add Quality");
            System.out.println("3.Delete Quality");
            System.out.println("0.Back to Character Menu");
            
            System.out.println("\nWhat would you like to do?");
            System.out.print(">");
            command = Integer.parseInt(user_input.next());
            
            switch(command) {
                case 1:
                    myCharacter.displayQualities();
                    break;
                case 2:
                    myCharacter.addNewQuality();
                    break;
                case 3:
                    myCharacter.deleteQuality();
                    break;
                default:
                    command = 0;
                    break;
            }
        } while(command != 0);
    }
    static void manageContacts(Character myCharacter) {
        Scanner user_input = new Scanner( System.in );
        int command;
        
        do {
            System.out.println("\n1.Show Contacts");
            System.out.println("2.Add Contact");
            System.out.println("3.Delete Contact");
            System.out.println("0.Go Back to Menu");
            
            System.out.println("\nWhat would you like to do?");
            System.out.print(">");
            command = Integer.parseInt(user_input.next());
            
            switch(command) {
                case 1:
                    myCharacter.displayContacts();
                    break;
                case 2:
                    myCharacter.addNewContact();
                    break;
                case 3:
                    myCharacter.deleteContact();
                    break;
                default:
                    command = 0;
                    break;
            }
        } while (command != 0);        
    }
    static void manageMeleeWeapons(Character myCharacter) {
        Scanner user_input = new Scanner( System.in );
        int command;
        
        do {
            System.out.println("\n1.Show Melee Weapons");
            System.out.println("2.Add Melee Weapon");
            System.out.println("3.Delete Melee Weapon");
            System.out.println("0.Go Back to Menu");
            
            System.out.println("\nWhat would you like to do?");
            System.out.print(">");
            command = Integer.parseInt(user_input.next());
            
            switch(command) {
                case 1:
                    myCharacter.displayMeleeWeapons();
                    break;
                case 2:
                    myCharacter.addNewMeleeWeapon();
                    break;
                case 3:
                    myCharacter.deleteMeleeWeapon();
                    break;
                default:
                    command = 0;
                    break;
            }
        } while (command != 0); 
    }
    static void manageRangedWeapons(Character myCharacter) {
        //TODO
    }
    
    /******************************************************
    /********** Display Current Characters in DB **********
    /******************************************************/
    static boolean displayDBCharacters() {
        System.out.println("Displaying possible characters... Please Wait.");
        Connection conn = Character.makeConn();
        try {
            Statement stt = conn.createStatement();
            String sql = "SELECT characterName FROM characters";
            
            ResultSet set = stt.executeQuery(sql);
            if (!set.isBeforeFirst()) {
                System.out.println("No Characters in Database.");
                return true;
            }
            
            while(set.next()) {
                String name = set.getString("characterName");
                System.out.println("-" + name);
            }
        } catch(Exception E) {
            E.printStackTrace();
        }
        
        
        return false;
    }
}
