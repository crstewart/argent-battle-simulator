package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.*;
import com.argentstew.simulator.battle.action.defense.Guard;
import com.argentstew.simulator.battle.action.defense.Heal;
import com.argentstew.simulator.battle.factory.FighterFactory;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.strategy.*;
import com.argentstew.simulator.battle.trait.Trait;
import com.argentstew.simulator.battle.web.cache.ImageCache;
import com.argentstew.simulator.battle.web.file.FileAccessor;
import com.argentstew.simulator.battle.web.model.*;
import com.argentstew.simulator.battle.web.repository.FighterRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    private static final Logger log = LogManager.getLogger(VgFighterService.class);

    private final FighterFactory fighterFactory;
    private final FighterRepository fighterRepository;
    private final FileAccessor fileAccessor;
    private final ImageCache imageCache;
    private final String imageDirectory;

    @Autowired
    public VgFighterService(FighterFactory fighterFactory,
                            FighterRepository fighterRepository,
                            FileAccessor fileAccessor,
                            ImageCache imageCache,
                            @Value("${argent.fighter.image.directory}") String imageDirectory) {
        this.fighterFactory = fighterFactory;
        this.fighterRepository = fighterRepository;
        this.fileAccessor = fileAccessor;
        this.imageCache = imageCache;
        this.imageDirectory = imageDirectory;
    }

    @Override
    public List<String> getFighters() {
        return fighterFactory.getAllFighters();
    }

    @Override
    public FighterDTO getFighter(String name) {
        Fighter fighter = fighterFactory.getFighter(name);
        log.info("Fetching fighter information for {}", fighter.getName());

        FighterDTO dto = new FighterDTO();

        fighterRepository.findByName(name).ifPresent(entry -> {
            dto.setSeriesOfOrigin(entry.getSeriesOfOrigin());
            dto.setCopyrightOwner(entry.getCopyrightOwner());
        });

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

        List<TraitDTO> traits = new ArrayList<>();
        for (Trait trait : fighter.getTraits()) {
            TraitDTO traitDto = new TraitDTO();
            traitDto.setName(trait.getName());
            traitDto.setDescription(trait.getDescription());
            traitDto.setImmuneToTorment(trait.isImmuneToTorment());
            traits.add(traitDto);
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

        dto.setStrategy(getStrategyType(fighter.getStrategy()));

        List<AttackDTO> attacks = new ArrayList<>();
        List<AttackDTO> xstrikes = new ArrayList<>();
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
                    xstrikes.add(attackDTO);
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
        dto.setXStrikes(xstrikes);
        dto.setGuards(guards);
        dto.setHeals(heals);

        return dto;
    }

    private String getStrategyType(Strategy strategy) {
        if (strategy instanceof BalancedStrategy) {
            return "Balanced";
        } else if (strategy instanceof OffensiveStrategy) {
            return "Focused on Offense";
        } else if (strategy instanceof DefensiveStrategy) {
            return "Focused on Defense";
        } else if (strategy instanceof MeleeStrategy) {
            return "Focused on Melee attacks";
        } else if (strategy instanceof RangedStrategy) {
            return "Focused on Ranged attacks";
        }

        return "Unique";
    }

    private static boolean isXStrike(Action action) {
        return action instanceof MeleeXStrike || action instanceof RangedXStrike || action instanceof MagicXStrike;
    }

    @Override
    public ImageDTO getFighterImage(String name) {
        String canonicalName = getCanonicalName(name);
        ImageDTO image = imageCache.get(canonicalName);
        if (image == null || image.getBytes() == null) {
            log.info("Image for {} not cached, fetching from remote file system", name);
            image = fileAccessor.getImage(imageDirectory, canonicalName);
            imageCache.put(image);
        }

        image.setName(name);
        return image;
    }

    private String getCanonicalName(String name) {
        return name.trim().replaceAll("\\s+", "_").replaceAll("\\.", "")
                .replaceAll("&", "and").toLowerCase();
    }
}
