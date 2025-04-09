/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.a.l2;

/**
 *
 * @author Andrey
 */

public class OrkBuilderFactory {
    public static OrkBuilder createOrcBuilder(String tribe) {
        switch (tribe) {
            case "Мордор":
                return new MordorOrkBuilder(new MordorGearFactory());
            case "Мглистые Горы:":
                return new MistyMountainsOrkBuilder(new MistyMountainsGearFactory());
            case "Дол Гулдур":
                return new DolGuldurOrkBuilder(new DolGuldurGearFactory());
            default:
                throw new IllegalArgumentException("Unknown tribe: " + tribe);
        }
    }
}




