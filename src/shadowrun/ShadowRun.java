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
        
        Character myCharacter = new Character();;
        int command;
        boolean characterCreated = false;
        do {
            if (characterCreated) {
                characterMenu();
            } else {
                mainMenu();
            }
            
            System.out.println("What would you like to do?");
            command = Integer.parseInt(user_input.next());
            
             if (characterCreated) {
                switch(command) {
                case 1:
                    myCharacter.addNewSkill();
//                    System.out.println(myCharacter.getPlayer());
                    break;
                default:
                    System.out.println("Not an option -- Leaving program.");
                    command = 0;
                    break;

            }
            } else {
                switch(command) {
                case 1:
//                    myCharacter = new Character();
                    characterCreated = true;
//                    System.out.println(myCharacter.getPlayer());
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
        System.out.println("3.Show Menu");
    }
    static void characterMenu() {
        System.out.println("1.Add New Skill");
    }
}