/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.a.l2;

/**
 *
 * @author Andrey
 */

public abstract class OrcBuilder {
    protected Ork ork;

    public Ork getOrk() {
        return ork;
    }

    public void createNewOrk() {
        ork = new Ork();
    }

    public abstract void buildName(String name);
    public abstract void buildTribe();
    public abstract void buildWeapon();
    public abstract void buildArmor();
    public abstract void buildBanner();
    public abstract void buildAttributes();

}

