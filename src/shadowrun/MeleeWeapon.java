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
public class MeleeWeapon {
    String name;
    int reach;
    int damage;
    int accuracy;
    int armorPierce;
    
    MeleeWeapon(String name, int reach, int damage, int accuracy, int armorPierce) {
        this.name = name;
        this.reach = reach;
        this.damage = damage;
        this.accuracy = accuracy;
        this.armorPierce = armorPierce;   
    }
    
    void display() {
        System.out.println("Melee Weapon: " + name + " | Reach: " + reach
                            + " | Damage: " + damage + " | Accuracy: " 
                            + accuracy + " | AP: " + armorPierce);   
    }
    
    String prepareForDB() {
        return name + ":" + reach + ":" + damage + ":" + accuracy + ":" + armorPierce;
    }
    
    String getName() {
        return this.name;
    }
}
