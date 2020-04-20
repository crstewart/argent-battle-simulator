package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.*;
import com.argentstew.simulator.battle.action.defense.Guard;
import com.argentstew.simulator.battle.action.defense.Heal;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.trait.Trait;
import com.argentstew.simulator.battle.vg.factory.VgFighterFactory;
import com.argentstew.simulator.battle.web.model.AttackDTO;
import com.argentstew.simulator.battle.web.model.FighterDTO;
import com.argentstew.simulator.battle.web.model.GuardDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * com.argentstew.simulator.battle.web.service
 * 4/19/2020
 *
 * @author argen
 */
@Service
public class VgFighterService implements FighterService {

    private static final Logger LOG = LogManager.getLogger(VgFighterService.class);

    private final VgFighterFactory fighterFactory;

    @Autowired
    public VgFighterService(VgFighterFactory fighterFactory) {
        this.fighterFactory = fighterFactory;
    }

    @Override
    public List<String> getFighters() {
        VgFighterFactory.FIGHTERS.sort(String::compareTo);
        return VgFighterFactory.FIGHTERS;
    }

    @Override
    public FighterDTO getFighter(String name) {
        LOG.info("Fetching fighter information for {}", name);
        Fighter fighter = fighterFactory.getFighter(name);
        FighterDTO dto = new FighterDTO();

        dto.setName(fighter.getName());
        dto.setDescription(fighter.getDescription());
        List<String> classifications = new ArrayList<>();
        for (FighterClassification classification : fighter.getClassifications()) {
            classifications.add(classification.toString());
        }
        dto.setClassifications(classifications);

        dto.setHp(fighter.getMaxHp());
        dto.setSp(fighter.getMp());
        dto.setMaxSp(fighter.getMaxMp());
        dto.setStrength(fighter.getStats().getStrength());
        dto.setToughness(fighter.getStats().getToughness());
        dto.setDexterity(fighter.getStats().getDexterity());
        dto.setAim(fighter.getStats().getAim());
        dto.setAgility(fighter.getStats().getAgility());
        dto.setSpeed(fighter.getStats().getSpeed());
        dto.setIntellect(fighter.getStats().getIntellect());
        dto.setWillpower(fighter.getStats().getWillpower());
        dto.setSize(fighter.getStats().getSize());
        dto.setWeight(fighter.getStats().getWeight());

        List<String> traits = new ArrayList<>();
        for (Trait trait : fighter.getTraits().getTraits()) {
            traits.add(trait.getName());
        }
        dto.setTraits(traits);

        List<String> defenses = new ArrayList<>();
        for (AttackType attackType : AttackType.values()) {
            double defense = fighter.getDefenses().get(attackType);
            if (defense > 1) {
                int weakness = (int) Math.round((defense - 1) * 100);
                defenses.add(attackType.toString() + ": " + weakness + "% weakness");
            } else if (defense < 1) {
                int resistance = (int) Math.round((1 - defense) * 100);
                defenses.add(attackType.toString() + ": " + resistance + "% resistance");
            }
        }
        for (AttackSubType attackSubType : AttackSubType.values()) {
            double defense = fighter.getDefenses().get(attackSubType);
            if (defense > 1) {
                int weakness = (int) Math.round((defense - 1) * 100);
                defenses.add(attackSubType.toString() + ": " + weakness + "% weakness");
            } else if (defense < 1) {
                int resistance = (int) Math.round((1 - defense) * 100);
                defenses.add(attackSubType.toString() + ": " + resistance + "% resistance");
            }
        }
        dto.setDefenses(defenses);

        dto.setStrategy(fighter.getStrategy().getClass().getSimpleName());

        List<AttackDTO> attacks = new ArrayList<>();
        List<GuardDTO> guards = new ArrayList<>();
        List<GuardDTO> heals = new ArrayList<>();
        for (Action action : fighter.getActions()) {
            if (action instanceof AttackAction) {
                AttackAction attack = (AttackAction) action;

                AttackDTO attackDTO = new AttackDTO();
                attackDTO.setName(attack.getName());
                attackDTO.setDescription(attack.getDescription());
                attackDTO.setAttackType(attack.getAttackType().toString());
                attackDTO.setPower(attack.getPower());
                attackDTO.setVariance(attack.getVariance());
                attackDTO.setSpeed(attack.getSpeed());

                List<String> attackSubTypes = new ArrayList<>();
                for (AttackSubType attackSubType : attack.getSubtypes()) {
                    attackSubTypes.add(attackSubType.toString());
                }
                attackDTO.setAttackSubTypes(attackSubTypes);

                List<String> characteristics = new ArrayList<>();
                for (AttackCharacteristic characteristic : attack.getCharacteristics()) {
                    characteristics.add(characteristic.toString());
                }
                attackDTO.setCharacteristics(characteristics);

                if (isXStrike(attack)) {
                    dto.setXStrike(attackDTO);
                } else {
                    attacks.add(attackDTO);
                }
            } else if (action instanceof Guard) {
                GuardDTO guardDTO = new GuardDTO();
                guardDTO.setName(action.getName());
                guardDTO.setDescription(action.getDescription());
                guards.add(guardDTO);
            } else if (action instanceof Heal) {
                GuardDTO healDTO = new GuardDTO();
                healDTO.setName(action.getName());
                healDTO.setDescription(action.getDescription());
                heals.add(healDTO);
            }
        }

        dto.setAttacks(attacks);
        dto.setGuards(guards);
        dto.setHeals(heals);

        return dto;
    }

    private static boolean isXStrike(Action action) {
        return action instanceof MeleeXStrike || action instanceof RangedXStrike || action instanceof MagicXStrike;
    }
}
