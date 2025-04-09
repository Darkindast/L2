/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.a.l2;

/**
 *
 * @author Andrey
 */

public class MordorOrkBuilder extends OrkBuilder {
    public MordorOrkBuilder(OrkGearFactory gearFactory) {
        super(gearFactory);
    }

    @Override
    public void buildName(String name) {
        ork.setName(name);
    }

    @Override
    public void buildTribe() {
        ork.setTribe("Mordor");
    }

    @Override
    public void buildWeapon() {
        ork.setWeapon(gearFactory.createWeapon());
    }

    @Override
    public void buildArmor() {
        ork.setArmor(gearFactory.createArmor());
    }

    @Override
    public void buildBanner() {
        ork.setBanner(gearFactory.createBanner());
    }

    @Override
    public void buildAttributes() {
        ork.setStrength((int) (Math.random() * 100));
        ork.setAgility((int) (Math.random() * 60));
        ork.setIntelligence((int) (Math.random() * 30));
        ork.setHealth((int) (Math.random() * 150 + 50));
    }
}





