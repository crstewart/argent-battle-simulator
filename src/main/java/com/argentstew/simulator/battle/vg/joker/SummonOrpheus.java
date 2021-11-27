package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.MoveAction;
import com.argentstew.simulator.battle.trait.impl.FoolArcana;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

/**
 * com.argentstew.simulator.battle.action.move
 * 8/23/2019
 *
 * @author Craig
 */
@EqualsAndHashCode(callSuper = true)
public class SummonOrpheus extends MoveAction {

    public SummonOrpheus() {
        this.setName("Summon Orpheus");
        this.setDescription("Uses all SP");
        this.setMessage("summons Orpheus Picaro!");
        this.setDirection(1);
    }

    @Override
    public double calculateSpeed() {
        return 0;
    }

    @Override
    public boolean isAllowed() {
        return owner.getMp() >= owner.getMaxMp() && StringUtils.isBlank(owner.getSelfStatus());
    }

    @Override
    public void move() {
        owner.setMp(0);
        FoolArcana trait = this.owner.getTraits().getTrait(FoolArcana.class);
        trait.setState(Joker.PERSONA_ORPHEUS);
        owner.setSelfStatus(Joker.PERSONA_ORPHEUS);
    }
}
