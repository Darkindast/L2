/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.a.l2;

/**
 *
 * @author Andrey
 */

public class Ork {
    private String name;
    private String tribe;
    private Weapon weapon;
    private Armor armor;
    private Banner banner;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;
    private String role;

 
    public void setName(String name) { this.name = name; }
    public void setTribe(String tribe) { this.tribe = tribe; }
    public void setWeapon(Weapon weapon) { this.weapon = weapon; }
    public void setArmor(Armor armor) { this.armor = armor; }
    public void setBanner(Banner banner) { this.banner = banner; }
    public void setStrength(int strength) { this.strength = strength; }
    public void setAgility(int agility) { this.agility = agility; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }
    public void setHealth(int health) { this.health = health; }
    public void setRole(String role) {this.role = role;}
    
    
    public String getRole() {return role;}
    public String getName() { return name; }
    public String getTribe() { return tribe; }
    public Weapon getWeapon() { return weapon; }
    public Armor getArmor() { return armor; }
    public Banner getBanner() { return banner; }
    public int getStrength() { return strength; }
    public int getAgility() { return agility; }
    public int getIntelligence() { return intelligence; }
    public int getHealth() { return health; }
}


