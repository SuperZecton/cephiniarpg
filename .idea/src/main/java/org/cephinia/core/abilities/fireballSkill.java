package org.cephinia.core.abilities;

import org.bukkit.entity.Fireball;

public class fireballSkill {

    public static void doThrow(Fireball ball, boolean incendiary, Integer yield ) {
        if (ball.getType().toString().equals("FIREBALL")) {

            ball.setIsIncendiary(incendiary);
            ball.setYield(yield);
        }
    }

}
