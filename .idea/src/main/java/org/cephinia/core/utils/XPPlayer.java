package org.cephinia.core.utils;

import org.jetbrains.annotations.NotNull;
import org.cephinia.core.utils.PlayerDataModifier;

public interface XPPlayer extends PlayerDataModifier {
    @NotNull
    XPModule getXpModule();

    default int getLevel() {
        return getXpModule().getLevel();
    }

    default int getCurrentThreshold() {
        return getXpModule().getCurrentThreshold();
    }

    default int getCurrentXp() {
        return getXpModule().getCurrentXp();
    }

    default int getIncrease() {
        return getXpModule().getIncrease();
    }

    default void giveXp(int amt) {
        getXpModule().giveXp(amt);
    }

    default void takeXp(int amt) {
        getXpModule().takeXp(amt);
    }
}