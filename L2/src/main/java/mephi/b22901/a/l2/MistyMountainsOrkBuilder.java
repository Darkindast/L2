/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.a.l2;

/**
 *
 * @author Andrey
 */

public class MistyMountainsOrkBuilder extends OrkBuilder {
    public MistyMountainsOrkBuilder(OrkGearFactory gearFactory) {
        super(gearFactory);
    }
     @Override
    public void buildName(String name) {
        getOrk().setName(name);
    }
    
    @Override
    public void buildTribe() {
        getOrk().setTribe("Misty Mountains");
    }
  
    @Override
    public void buildWeapon() {
        getOrk().setWeapon(getgearFactory().createWeapon());
    }

    @Override
    public void buildArmor() {
        getOrk().setArmor(getgearFactory().createArmor());
    }

    @Override
    public void buildBanner() {
        getOrk().setBanner(getgearFactory().createBanner());
    }

    @Override
    public void buildAttributes() {
        getOrk().setStrength((int) (Math.random() * 60 + 30));
        getOrk().setAgility((int) (Math.random() * 80));
        getOrk().setIntelligence((int) (Math.random() * 25));
        getOrk().setHealth((int) (Math.random() * 150 + 50));
    }
}


