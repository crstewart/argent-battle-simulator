package com.argentstew.simulator.battle.vg.illidan;

import com.argentstew.simulator.battle.action.MoveAction;
import com.argentstew.simulator.battle.trait.impl.DemonicForm;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

/**
 * com.argentstew.simulator.battle.vg.illidan
 * 8/23/2019
 *
 * @author Craig
 */
@EqualsAndHashCode(callSuper = true)
public class Metamorphosis extends MoveAction {

    public Metamorphosis() {
        this.setName("Metamorphosis");
        this.setDescription("Changes user into demon form for 5 turns");
        this.setMessage("switches to Demon Form! 'Now I am complete!'");
        this.setDirection(1);
    }

    @Override
    public double calculateSpeed() {
        return 0;
    }

    @Override
    public boolean isDoable() {
        return StringUtils.isBlank(owner.getSelfStatus());
    }

    @Override
    public void move() {
        DemonicForm trait = owner.getTraits().getTrait(DemonicForm.class);
        if (trait != null) {
            trait.transform(this.owner);
        }
    }
}
