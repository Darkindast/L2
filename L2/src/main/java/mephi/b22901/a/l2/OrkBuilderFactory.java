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
    public static OrcBuilder createOrcBuilder(String tribe) {
        switch (tribe) {
            case "Мордор":
                return new MordorOrcBuilder(new MordorGearFactory());
            case "Мглистые Горы:":
                return new MistyMountainsOrcBuilder(new MistyMountainsGearFactory());
            case "Дол Гулдур":
                return new DolGuldurOrcBuilder(new DolGuldurGearFactory());
            default:
                throw new IllegalArgumentException("Unknown tribe: " + tribe);
        }
    }
}




