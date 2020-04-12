package com.argentstew.simulator.battle.desc;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.*;
import com.argentstew.simulator.battle.action.defense.Guard;
import com.argentstew.simulator.battle.action.defense.Heal;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.trait.Trait;
import com.argentstew.simulator.battle.vg.factory.VgFighterFactory;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * com.argentstew.simulator.battle.desc
 * 4/11/2020
 *
 * @author argen
 */
public class CharacterDescriptionWriter {

//    private static final List<String> FIGHTERS = Arrays.asList("Mario", "Luigi", "Peach", "Bowser");
    private static final List<String> FIGHTERS = Arrays.asList("Mario", "Luigi", "Peach", "Bowser", "Donkey Kong",
        "Diddy Kong", "Yoshi", "Wario", "Link", "Zelda", "Ganondorf", "Pikachu", "Charizard", "Mewtwo",
        "Samus Aran", "Ridley", "Fox McCloud", "Kirby", "King Dedede", "Marth", "Ness", "Captain Falcon", "Pit",
        "Inkling", "Mega Man", "Dr. Wily", "Zero", "Sigma", "Tron Bonne", "Ryu", "Chun Li", "Akuma",
        "Leon Kennedy", "Albert Wesker", "Viewtiful Joe", "Morrigan Aensland", "Dante", "Arthur", "Sonic", "Tails",
        "Dr. Eggman", "Vyse", "Cloud Strife", "Squall Leonhart", "Kefka Palazzo", "Sephiroth", "Erdrick", "Sora",
        "Crono", "Magus", "Crash Bandicoot", "Spyro", "Jak & Daxter", "Ratchet & Clank", "Nathan Drake", "Kratos",
        "Cole MacGrath", "Sly Cooper", "Solid Snake", "Simon Belmont", "Pac-Man", "Heihachi Mishima", "KOS-MOS",
        "Lloyd Irving", "Gordon Freeman", "Heavy", "Master Chief", "Marcus Fenix", "Steve", "Niko Bellic",
        "John Marston", "Big Daddy", "Terry Bogard", "Handsome Jack", "Rayman", "Ezio Auditore",
        "Prince of Persia", "Thrall", "Jaina Proudmoore", "Arthas Menethil", "Diablo", "Sarah Kerrigan", "Tracer",
        "Sub-Zero", "Scorpion", "Bomberman", "Banjo & Kazooie", "Lara Croft", "Commander Shepard",
        "Ryu Hayabusa", "Dovahkiin", "Shovel Knight", "Sans", "Joker", "Doom Slayer", "Captain Price",
        "Cuphead", "Guybrush Threepwood", "Draven", "Geralt of Rivia");
    private static final String SEPARATOR = "-------------------------------------------------------\n";

    public static void main(String[] args) {
        try {
            FIGHTERS.sort(String::compareTo);

            FileWriter fileWriter = new FileWriter("fighter_descriptions.txt");

            fileWriter.write("Below is a detailed description of all characters in the argent-battle-simulator\n");

            VgFighterFactory factory = new VgFighterFactory();
            for (String fighterName : FIGHTERS) {
                fileWriter.write("\n");
                fileWriter.write(SEPARATOR);
                fileWriter.write("\n");
                fileWriter.write(fighterName + "\n");

                Fighter fighter = factory.getFighter(fighterName);

                fileWriter.write(fighter.getDescription() + "\n");
                fileWriter.write("Classifications: ");
                for (FighterClassification classification : fighter.getClassifications()) {
                    fileWriter.write(classification + " ");
                }

                fileWriter.write("\n");
                fileWriter.write("\nStats:\n");
                fileWriter.write("HP " + fighter.getMaxHp() + "/" + fighter.getMaxHp() + "\n");
                fileWriter.write("Str " + fighter.getStats().getStrength() + "\t\t\t Spd " + fighter.getStats().getSpeed() + "\n");
                fileWriter.write("Tgh " + fighter.getStats().getToughness() + "\t\t\t Int " + fighter.getStats().getIntellect() + "\n");
                fileWriter.write("Dex " + fighter.getStats().getDexterity() + "\t\t\t Wil " + fighter.getStats().getWillpower() + "\n");
                fileWriter.write("Aim " + fighter.getStats().getAim() + "\t\t\t Siz " + fighter.getStats().getSize() + "\n");
                fileWriter.write("Agi " + fighter.getStats().getAgility() + "\t\t\t Wgt " + fighter.getStats().getWeight() + "\n");

                fileWriter.write("\nTraits: ");
                if (fighter.getTraits().getTraits().isEmpty()) {
                    fileWriter.write("NONE");
                } else {
                    List<String> traits = new ArrayList<>();
                    for (Trait trait : fighter.getTraits().getTraits()) {
                        traits.add(trait.getName());
                    }
                    fileWriter.write(String.join(", ", traits));
                }
                fileWriter.write("\n");

                fileWriter.write("\nDefenses:\n");
                for (AttackType attackType : AttackType.values()) {
                    double defense = fighter.getDefenses().get(attackType);
                    if (defense > 1) {
                        int weakness = (int) Math.round((defense - 1) * 100);
                        fileWriter.write(attackType.toString() + ": " + weakness + "% weakness\n");
                    } else if (defense < 1) {
                        int resistance = (int) Math.round((1 - defense) * 100);
                        fileWriter.write(attackType.toString() + ": " + resistance + "% resistance\n");
                    }
                }
                for (AttackSubType attackSubType : AttackSubType.values()) {
                    double defense = fighter.getDefenses().get(attackSubType);
                    if (defense > 1) {
                        int weakness = (int) Math.round((defense - 1) * 100);
                        fileWriter.write(attackSubType.toString() + ": " + weakness + "% weakness\n");
                    } else if (defense < 1) {
                        int resistance = (int) Math.round((1 - defense) * 100);
                        fileWriter.write(attackSubType.toString() + ": " + resistance + "% resistance\n");
                    }
                }

                String strategyName = fighter.getStrategy().getClass().getSimpleName();
                fileWriter.write("\nStrategy: " + strategyName.substring(0, strategyName.indexOf("Strategy")));

                fileWriter.write("\nAttacks:\n");
                for (Action action : fighter.getActions()) {
                    if (action instanceof AttackAction && !isXStrike(action)) {
                        AttackAction attack = (AttackAction) action;
                        fileWriter.write(attack.getName() + " - Type: " + attack.getAttackType() + ", Power: " +
                                attack.getPower() + " +0-" + (int) attack.getVariance() + ", Speed: " + attack.getSpeed() +
                                ", Elements: ");
                        for (AttackSubType attackSubType : attack.getSubtypes()) {
                            fileWriter.write(attackSubType + " ");
                        }
                        if (!attack.getCharacteristics().isEmpty()) {
                            fileWriter.write("\n\t");
                            for (AttackCharacteristic characteristic : attack.getCharacteristics()) {
                                fileWriter.write(characteristic + " ");
                            }
                        }
                        fileWriter.write("\n");
                    }
                }

                fileWriter.write("\nGuards: ");
                List<Action> guards = new ArrayList<>();
                for (Action action : fighter.getActions()) {
                    if (action instanceof Guard) {
                        guards.add(action);
                    }
                }
                if (guards.isEmpty()) {
                    fileWriter.write("NONE");
                } else {
                    for (Action guard : guards) {
                        fileWriter.write(guard.getName());
                    }
                }

                fileWriter.write("\nHeals: ");
                List<Action> heals = new ArrayList<>();
                for (Action action : fighter.getActions()) {
                    if (action instanceof Heal) {
                        heals.add(action);
                    }
                }
                if (heals.isEmpty()) {
                    fileWriter.write("NONE");
                } else {
                    for (Action heal : heals) {
                        fileWriter.write(heal.getName());
                    }
                }
                fileWriter.write("\n");

                fileWriter.write("\nX-Strike:\n");
                for (Action action : fighter.getActions()) {
                    if (isXStrike(action)) {
                        AttackAction attack = (AttackAction) action;
                        fileWriter.write(attack.getName() + " - Type: " + attack.getAttackType() + ", Power: " +
                                attack.getPower() + " +0-" + (int) attack.getVariance() + ", Speed: " + attack.getSpeed() +
                                ", Elements: ");
                        for (AttackSubType attackSubType : attack.getSubtypes()) {
                            fileWriter.write(attackSubType + " ");
                        }
                        if (!attack.getCharacteristics().isEmpty()) {
                            fileWriter.write("\n\t");
                            for (AttackCharacteristic characteristic : attack.getCharacteristics()) {
                                fileWriter.write(characteristic + " ");
                            }
                        }
                        fileWriter.write("\n");
                    }
                }
            }

            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isXStrike(Action action) {
        return action instanceof MeleeXStrike || action instanceof RangedXStrike || action instanceof MagicXStrike;
    }
}
