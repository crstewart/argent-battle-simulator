package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.trait.Trait;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * com.argentstew.simulator.battle.trait.impl
 * 11/10/2019
 *
 * @author Craig
 */
@Getter
@EqualsAndHashCode(exclude = {"owner"})
public class StanceChange implements Trait {

    private final String name = "Stance Change";

    private Fighter owner;
    private boolean isReady;
    private Stance stance;

    public StanceChange() {
        this.isReady = true;
        this.stance = Stance.DEFAULT;
    }

    @Override
    public void applyStartOfGameEffects(Fighter owner, Fighter opponent) {
        this.owner = owner;
    }

    @Override
    public void setUpTurn() {
        if (isReady) {
            isReady = false;
            int choice = (int) Math.floor(Math.random() * 4);
            Stance stance = Stance.values()[choice];
            if (!this.stance.equals(stance)) {
                owner.getStats().setStrength(owner.getStats().getStrength() + stance.getStrength() - this.stance.getStrength());
                owner.getStats().setToughness(owner.getStats().getToughness() + stance.getToughness() - this.stance.getToughness());
                owner.getStats().setDexterity(owner.getStats().getDexterity() + stance.getDexterity() - this.stance.getDexterity());
                owner.getStats().setAim(owner.getStats().getAim() + stance.getAim() - this.stance.getAim());
                owner.getStats().setAgility(owner.getStats().getAgility() + stance.getAgility() - this.stance.getAgility());
                owner.getStats().setSpeed(owner.getStats().getSpeed() + stance.getSpeed() - this.stance.getSpeed());
                this.stance = stance;
            }
        } else {
            isReady = true;
        }
    }

    @Getter
    public enum Stance {

        DEFAULT(0, 0, 0, 0, 0, 0),
        AGGRESSIVE(3, 3, -2, -2, 0, 0),
        QUICK(-2, -2, 0, 0, 3, 3),
        TARGETED(0, 0, 3, 3, -2, -2);

        private final double strength;
        private final double toughness;
        private final double dexterity;
        private final double aim;
        private final double agility;
        private final double speed;

        Stance(double strength, double toughness, double dexterity, double aim, double agility, double speed) {
            this.strength = strength;
            this.toughness = toughness;
            this.dexterity = dexterity;
            this.aim = aim;
            this.agility = agility;
            this.speed = speed;
        }
    }
}
