/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.a.l2;

/**
 *
 * @author Andrey
 */

public class MistyMountainsOrcBuilder extends OrcBuilder {
    private final OrcGearFactory gearFactory;

    public MistyMountainsOrcBuilder(OrcGearFactory gearFactory) {
        this.gearFactory = gearFactory;
    }
     @Override
    public void buildName(String name) {
        ork.setName(name);
    }
    
    @Override
    public void buildTribe() {
        ork.setTribe("Misty Mountains");
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
        ork.setStrength((int) (Math.random() * 60 + 30));
        ork.setAgility((int) (Math.random() * 80));
        ork.setIntelligence((int) (Math.random() * 25));
        ork.setHealth((int) (Math.random() * 150 + 50));
    }
}


