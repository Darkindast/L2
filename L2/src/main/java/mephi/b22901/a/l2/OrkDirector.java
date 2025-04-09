/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.a.l2;

/**
 *
 * @author Andrey
 */

public class OrkDirector {
    private OrkBuilder builder;

    public OrkDirector(OrkBuilder builder) {
        this.builder = builder;
    }

    public Ork createBasicOrc(String name) {
        builder.createNewOrk();
        builder.buildName(name);
        builder.buildTribe();
        builder.buildWeapon();   
        builder.buildArmor();
        builder.buildBanner();  
        builder.buildAttributes();
        builder.getOrk().setRole("Warrior");
        return builder.getOrk();
    }

    public Ork createLeaderOrc(String name) {
        builder.createNewOrk();
        builder.buildName(name);
        builder.buildTribe();
        builder.buildWeapon();   
        builder.buildArmor();
        builder.buildBanner();  
        builder.buildAttributes();

  
        Ork leader = builder.getOrk();
        leader.setRole("Leader");
        leader.setStrength(leader.getStrength() + 20);
        leader.setHealth(leader.getHealth() + 30);
        return leader;
    }

    public Ork createScoutOrc(String name) {
        builder.createNewOrk();
        builder.buildName(name);
        builder.buildTribe();
        builder.getOrk().setWeapon(new Bow());
        builder.buildArmor();
        builder.buildBanner(); 
        builder.buildAttributes();

        Ork scout = builder.getOrk();
        scout.setRole("Scout");
        scout.setAgility(scout.getAgility() + 25);
        scout.setStrength((int)(scout.getStrength() * 0.8)); 
        return scout;
    }
}
