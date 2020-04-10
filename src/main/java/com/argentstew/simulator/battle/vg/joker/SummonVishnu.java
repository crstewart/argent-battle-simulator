package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.MoveAction;
import com.argentstew.simulator.battle.trait.impl.Trickster;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

/**
 * com.argentstew.simulator.battle.action.move
 * 8/23/2019
 *
 * @author Craig
 */
@EqualsAndHashCode(callSuper = true)
public class SummonVishnu extends MoveAction {

    public SummonVishnu() {
        this.setName("Summon Vishnu");
        this.setMessage("summons Vishnu!");
        this.setDirection(1);
    }

    @Override
    public double calculateSpeed() {
        return 0;
    }

    @Override
    public boolean isDoable() {
        return owner.getMp() >= owner.getMaxMp() && StringUtils.isBlank(owner.getSelfStatus());
    }

    @Override
    public void move() {
        owner.setMp(0);
        ((Trickster) owner.getTraits().getTraits().get(0)).setState(Joker.PERSONA_VISHNU);
        owner.setSelfStatus(Joker.PERSONA_VISHNU);
    }
}
