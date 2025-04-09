/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.a.l2;

/**
 *
 * @author Andrey
 */
// OrcDirector.java
public class OrkDirector {
    private final OrkBuilder builder;

    public OrkDirector(OrkBuilder builder) {
        this.builder = builder;
    }

    public Ork createBasicOrc(String name) {
        builder.createNewOrk();
        builder.buildName(name);
        builder.buildTribe();
        builder.buildWeapon();   // обычное оружие
        builder.buildArmor();
        builder.buildBanner();   // может быть простое знамя
        builder.buildAttributes();
        builder.getOrk().setRole("Warrior");
        return builder.getOrk();
    }

    public Ork createLeaderOrc(String name) {
        builder.createNewOrk();
        builder.buildName(name);
        builder.buildTribe();

        builder.buildWeapon();   // возможно особенное оружие
        builder.buildArmor();

        builder.buildBanner();  

        builder.buildAttributes();

        // Дополнительный бонус лидеру
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

        // Заменим оружие на лук вручную
        builder.getOrk().setWeapon(new Bow());

        builder.buildArmor();
        builder.buildBanner(); // можно использовать лёгкое знамя

        builder.buildAttributes();

        // Дополнительные скаутские бонусы
        Ork scout = builder.getOrk();
        scout.setRole("Scout");
        scout.setAgility(scout.getAgility() + 25);
        scout.setStrength((int)(scout.getStrength() * 0.8)); // чуть слабее
        return scout;
    }
}
