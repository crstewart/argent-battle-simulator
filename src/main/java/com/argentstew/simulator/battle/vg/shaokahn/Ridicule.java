package com.argentstew.simulator.battle.vg.shaokahn;

import com.argentstew.simulator.battle.action.MoveAction;
import com.argentstew.simulator.battle.trait.impl.Trickster;
import com.argentstew.simulator.battle.vg.joker.Joker;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

/**
 * com.argentstew.simulator.battle.vg.shaokahn
 * 8/23/2019
 *
 * @author Craig
 */
@EqualsAndHashCode(callSuper = true)
public class Ridicule extends MoveAction {

    public Ridicule() {
        this.setName("Ridicule");
        this.setDescription("Taunts and laughs at the opponent; otherwise, does nothing");
        this.setMessage("decries, 'You will never win!'");
        this.setDirection(1);
    }

    @Override
    public double calculateSpeed() {
        return 0;
    }

    @Override
    public boolean isDoable() {
        return true;
    }

    @Override
    public void move() {
        double random = Math.random() * 3;
        if (random < 1) {
            this.setMessage("decries, 'You will never win!'");
        } else if (random < 2) {
            this.setMessage("yells, 'Bow to me!'");
        } else {
            this.setMessage("says, 'Prepare to die!'");
        }
    }
}
