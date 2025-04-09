/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.a.l2;

/**
 *
 * @author Andrey
 */

public class MordorGearFactory implements OrkGearFactory {
    public Weapon createWeapon() { return new HardSword(); }
    public Armor createArmor() { return new SteelArmor(); }
    public Banner createBanner() { return new RedEyeBanner(); }
}

