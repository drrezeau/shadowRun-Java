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

    /**
     * @param args the command line arguments
     */
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
                    myCharacter.addNewSkill();
//                    System.out.println(myCharacter.getPlayer());
                    break;
                case 3:
                    myCharacter.displaySkills();
                    break;
                case 4:
                    manageQualities(myCharacter);
                    break;
                case 6:
                    myCharacter.addNewContact();
                    break;
                case 7:
                    myCharacter.displayContacts();
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
        // TODO code application logic here
    }
 
    
    static void mainMenu() {
        System.out.println("1.Create new Character");
        System.out.println("2.Load Character");
//        System.out.println("3.Show Menu");
    }
    static void characterMenu() {
        System.out.println("\n1.Display Character Stats");
        System.out.println("2.Add New Skill");
        System.out.println("3.Show Skills");
        System.out.println("4.Manage Qualities");
        System.out.println("6.Add New Contact");
        System.out.println("7.Show Contacts");
        System.out.println("15.Save to DB");
    }
    
    static void manageQualities(Character myCharacter) {
        Scanner user_input = new Scanner( System.in );
        int command;
        
        do {
            System.out.println("\n1.Display Qualities");
            System.out.println("2.Add Quality");
            System.out.println("3.Delete Quality");
            
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
            }
        } while(command != 0);
    }
    
    static boolean displayDBCharacters() {
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
