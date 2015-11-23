/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shadowrun;

import java.util.Scanner;

/**
 *
 * @author c
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
        command = Integer.parseInt(user_input.next());
        
        switch(command) {
                case 1:
                    myCharacter.createCharacter();
                    characterCreated = true;
//                    System.out.println(myCharacter.getPlayer());
                    break;
                case 2:
                    myCharacter.loadFromDB();
                    characterCreated = true;
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
                    myCharacter.addNewQuality();
                    break;
                case 5:
                    myCharacter.displayQualities();
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
        System.out.println("4.Add Quality");
        System.out.println("5.Show Qualities");
        System.out.println("15.Save to DB");
    }
}
