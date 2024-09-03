import java.util.Scanner;

public class Movement {

    public void MovementOptions(Adventurer adventurer, int roll) {

        System.out.println("You rolled a " + roll);

        switch (roll) {

            case 2, 5, 6, 8, 9, 10:
                System.out.println("You walk into a new section of the " +
                        "dungeon.");
                break;
            case 3:
                if (!adventurer.magicRing) {
                    System.out.println("You walked into a trap!");

                    int trapRoll = Dice.rollDice(1);

                    Trap trap = new Trap();
                    String trapName = trap.rollTrap(trapRoll);
                    int trapDmg = trap.trapDamage(trapRoll);

                    adventurer.currentHealthPoints -= trapDmg;

                    switch (trapName) {
                        case "Trapdoor":
                            if (adventurer.currentHealthPoints <= 0) {
                                System.out.println("You fell into a trapdoor " +
                                        "and took " + trapDmg + " Damage. " +
                                        "You died.");
                                adventurer.isAlive = false;
                            } else {
                                System.out.println("You fell into a trapdoor " +
                                        "and took " + trapDmg + " Damage.");
                            }
                            break;
                        case "Dart Rain":
                            if (adventurer.currentHealthPoints <= 0) {
                                System.out.println("You were hit by a rain" +
                                        " of darts and took " + trapDmg +
                                        " damage. You died.");
                                adventurer.isAlive = false;
                            } else {
                                System.out.println("You were hit by a rain" +
                                        " of darts and took " + trapDmg +
                                        " damage.");
                            }
                            break;
                        case "Acid":
                            if (adventurer.currentHealthPoints <= 0) {
                                System.out.println("Acid fell from the roof " +
                                        "and you took " + trapDmg + " Damage." +
                                        " You died.");
                                adventurer.isAlive = false;
                            } else {
                                System.out.println("Acid fell from the roof " +
                                        "and you took " + trapDmg + " Damage.");
                            }
                            break;
                        case "Arrow Rain":
                            if (adventurer.currentHealthPoints <= 0) {
                                System.out.println("You were hit by a rain of " +
                                        "arrows and you took " + trapDmg +
                                        " Damage. You died.");
                                adventurer.isAlive = false;
                            } else {
                                System.out.println("You were hit by a rain of" +
                                        " arrows and you took " + trapDmg +
                                        " Damage.");
                            }
                            break;
                        case "Gas":
                            if (adventurer.currentHealthPoints <= 0) {
                                System.out.println("Toxic Gas leaked from the " +
                                        "wall and you took " + trapDmg +
                                        " Damage. You died.");
                                adventurer.isAlive = false;
                            } else {
                                System.out.println("Toxic Gas leaked from the" +
                                        " wall and you took " + trapDmg +
                                        " Damage.");
                            }
                            break;
                        case "Roof Collapse":
                            System.out.println("The roof collapsed and you " +
                                    "died");
                            adventurer.isAlive = false;
                            break;
                    }
                } else {
                    System.out.println("Your ring tells that there is a trap!" +
                            " You walk past the trap.");
                }
                break;
            case 4, 12:
                System.out.println("You found a treasure chest with " +
                        "an item inside");
                int itemRoll = Dice.rollDice(1);
                System.out.println("You rolled a " + itemRoll);
                TreasureChest treasureChest = new TreasureChest();
                String item = treasureChest.FindItem(itemRoll);
                switch (item) {
                    case "Magic Sword":
                        if (adventurer.attackPower == 3) {
                            System.out.println("You found a Magic Sword! " +
                                    "You already have a Magic Sword. " +
                                    "Leaving this one on the chest.");
                        } else {
                            System.out.println("You found a Magic Sword! " +
                                    "Your Attack Power is now 3d6!");
                            adventurer.attackPower = 3;
                            adventurer.sword = "Magic Sword";
                        }
                        break;

                    case "Health Potion":
                        if (adventurer.potionNumbers == 4) {
                            System.out.println("You found a Health Potion! " +
                                    "You can't cary more than 4 " +
                                    "Health Potions. Leaving this one " +
                                    "on the chest.");
                        } else {
                            adventurer.potionNumbers++;
                            String s = "";
                            if (adventurer.potionNumbers > 1) {
                                s = "s";
                            }
                            System.out.println("You found a Health Potion! " +
                                    "You now have " + adventurer.potionNumbers +
                                    " Potion" + s + ".");
                        }
                        break;

                    case "Ring of Trap Detection":
                        if (adventurer.magicRing) {
                            System.out.println("You found a Ring of Trap Detection! " +
                                    "You already have a Ring of Trap Detection. " +
                                    "Leaving this one on the chest.");
                        } else {
                            System.out.println("You found a Ring of Trap Detection! " +
                                    "You are now immune to Traps!");
                            adventurer.magicRing = true;
                        }
                        break;

                    case "Magic Armour":
                        if (adventurer.armourClass == 9) {
                            System.out.println("You found a Magic Armour! " +
                                    "You already have a Magic Armour. " +
                                    "Leaving this one on the chest.");
                        } else {
                            System.out.println("You found a Magic Armour! " +
                                    "Your Armour Class is now 9!");
                            adventurer.armourClass = 9;
                            adventurer.armour = "Magic Armour";
                        }
                        break;
                    case "Gold Coins":
                        int coins = Dice.rollDice(1) * 1000;
                        if (adventurer.goldCoins >= 14000) {
                            System.out.println("You found " + coins +
                                    " Gold Coins. " +
                                    "You can't carry more than 14000" +
                                    " Gold Coins. Leaving these on the chest.");
                        } else if (adventurer.goldCoins + coins > 14000) {
                            adventurer.goldCoins = 14000;
                            System.out.println("You found " + coins +
                                    " Gold Coins. " +
                                    "You can't carry more than 14000 " +
                                    "Gold Coins. Leaving some on the chest. " +
                                    "You now have " + adventurer.goldCoins +
                                    " Gold Coins.");
                        } else {
                            adventurer.goldCoins += coins;
                            System.out.println("You found " + coins +
                                    " Gold Coins! You now have "
                                    + adventurer.goldCoins + " Gold Coins.");
                        }
                        break;
                    case "Cursed Item":
                        int damage = Dice.rollDice(1);
                        adventurer.currentHealthPoints -= damage;
                        if (adventurer.currentHealthPoints <= 0) {
                            System.out.println("You found a Cursed Item! " +
                                    "You took " + damage + " damage. You died.");
                            adventurer.isAlive = false;
                        } else {
                            System.out.println("You found a Cursed Item! You took " +
                                    damage + " damage. You now have " +
                                    adventurer.currentHealthPoints +
                                    " Health Points.");
                        }
                }
                break;
            case 7, 11:

                boolean combat = true;

                int creatureType = Dice.rollDice(1);

                Creature monster = new Creature();
                monster = monster.createMonster(monster, creatureType);

                System.out.println("You found a " + monster.name + "!" +
                        "The combat begins."
                        + "\nRolling initiative");

                int adventurerInitiative = Dice.rollDice(1);
                int monsterInitiative = Dice.rollDice(1);
                System.out.println(adventurer.name + " initiative: " +
                        adventurerInitiative);
                System.out.println(monster.name + " initiative: " +
                        monsterInitiative);
                Scanner scan = new Scanner(System.in);
                if (monsterInitiative > adventurerInitiative) {
                    int attack = Dice.rollDice(monster.attackPower);

                    int choise;
                    do {
                        System.out.println("Press 1 to continue");
                        choise = scan.nextInt();
                    } while (choise != 1);
                    if (attack >= adventurer.armourClass) {
                        int damage = attack - adventurer.armourClass;
                        adventurer.currentHealthPoints -= damage;
                        System.out.println("The " + monster.name + " rolled a " +
                                attack + " and hit you, dealing " + damage +
                                " damage. \nYou have " +
                                adventurer.currentHealthPoints + " Health" +
                                        " Points left.");
                        if (adventurer.currentHealthPoints <= 0) {
                            System.out.println("The " + monster.name + " killed" +
                                    " you. You are dead.");
                            adventurer.isAlive = false;
                            combat = false;
                        }
                    } else {
                        System.out.println("The " + monster.name + " missed" +
                                " the attack.");
                    }
                }
                while (combat) {

                    int choise;
                    do {
                        System.out.println("Press 1 to continue");
                        choise = scan.nextInt();
                    } while (choise != 1);


                    int attack;
                    int damage;

                    attack = Dice.rollDice(adventurer.attackPower);

                    if (attack >= monster.armourClass) {
                        damage = attack - monster.armourClass;
                        monster.currentHealthPoints -= damage;
                        System.out.println("You rolled a " +
                                attack + " and hit the "+ monster.name
                                +", dealing " + damage +
                                " damage.");
                        if (monster.currentHealthPoints <= 0) {
                            System.out.println("You killed the " + monster.name +
                                    "! The combat ends.");
                            monster.isAlive = false;
                            combat = false;
                        }
                    } else {
                        System.out.println("You missed the attack.");
                    }
                    do {
                        System.out.println("Press 1 to continue");
                        choise = scan.nextInt();
                    } while (choise != 1);

                    if (monster.isAlive) {
                        attack = Dice.rollDice(monster.attackPower);

                        if (attack >= adventurer.armourClass) {
                            damage = attack - adventurer.armourClass;
                            adventurer.currentHealthPoints -= damage;
                            System.out.println("The " + monster.name + " rolled a " +
                                    attack + " and hit you, dealing " + damage +
                                    " damage. \nYou have " +
                                    adventurer.currentHealthPoints + " Health" +
                                    " Points left.");
                            if (adventurer.currentHealthPoints <= 0) {
                                System.out.println("The " + monster.name + " killed" +
                                        " you. You are dead.");
                                adventurer.isAlive = false;
                                combat = false;
                            }
                        } else {
                            System.out.println("The " + monster.name + " missed" +
                                    " the attack.");
                        }

                    }
                }

        }
    }

    public void EscapeOptions(Adventurer adventurer, int roll) {

        System.out.println("You rolled a " + roll);


        switch (roll) {
            case 1:
                System.out.println("You keep walking on the, but" +
                        " \"someone\" \"found\" you.");

                boolean combat = true;

                int creatureType = Dice.rollDice(1);

                Creature monster = new Creature();
                monster = monster.createMonster(monster, creatureType);

                System.out.println("You found a " + monster.name + "!" +
                        "The combat begins."
                        + "\nRolling initiative");

                int adventurerInitiative = Dice.rollDice(1);
                int monsterInitiative = Dice.rollDice(1);
                System.out.println(adventurer.name + " initiative: " +
                        adventurerInitiative);
                System.out.println(monster.name + " initiative: " +
                        monsterInitiative);
                Scanner scan = new Scanner(System.in);
                if (monsterInitiative > adventurerInitiative) {
                    int attack = Dice.rollDice(monster.attackPower);

                    int choise;
                    do {
                        System.out.println("Press 1 to continue");
                        choise = scan.nextInt();
                    } while (choise != 1);
                    if (attack >= adventurer.armourClass) {
                        int damage = attack - adventurer.armourClass;
                        adventurer.currentHealthPoints -= damage;
                        System.out.println("The " + monster.name + " rolled a " +
                                attack + " and hit you, dealing " + damage +
                                " damage. \nYou have " +
                                adventurer.currentHealthPoints + " Health" +
                                " Points left.");
                        if (adventurer.currentHealthPoints <= 0) {
                            System.out.println("The " + monster.name + " killed" +
                                    " you. You are dead.");
                            adventurer.isAlive = false;
                            combat = false;
                        }
                    } else {
                        System.out.println("The " + monster.name + " missed" +
                                " the attack.");
                    }
                }
                while (combat) {

                    int choise;
                    do {
                        System.out.println("Press 1 to continue");
                        choise = scan.nextInt();
                    } while (choise != 1);


                    int attack;
                    int damage;

                    attack = Dice.rollDice(adventurer.attackPower);

                    if (attack >= monster.armourClass) {
                        damage = attack - monster.armourClass;
                        monster.currentHealthPoints -= damage;
                        System.out.println("You rolled a " +
                                attack + " and hit the " + monster.name
                                + ", dealing " + damage +
                                " damage.");
                        if (monster.currentHealthPoints <= 0) {
                            System.out.println("You killed the " + monster.name +
                                    "! The combat ends.");
                            monster.isAlive = false;
                            combat = false;
                        }
                    } else {
                        System.out.println("You missed the attack.");
                    }
                    do {
                        System.out.println("Press 1 to continue");
                        choise = scan.nextInt();
                    } while (choise != 1);

                    if (monster.isAlive) {
                        attack = Dice.rollDice(monster.attackPower);

                        if (attack >= adventurer.armourClass) {
                            damage = attack - adventurer.armourClass;
                            adventurer.currentHealthPoints -= damage;
                            System.out.println("The " + monster.name + " rolled a " +
                                    attack + " and hit you, dealing " + damage +
                                    " damage. \nYou have " +
                                    adventurer.currentHealthPoints + " Health" +
                                    " Points left.");
                            if (adventurer.currentHealthPoints <= 0) {
                                System.out.println("The " + monster.name + " killed" +
                                        " you. You are dead.");
                                adventurer.isAlive = false;
                                combat = false;
                            }
                        } else {
                            System.out.println("The " + monster.name + " missed" +
                                    " the attack.");
                        }

                    }
                }
                break;
            case 2:
                System.out.println("You was the only one to find the escape from this" +
                        " infernal place! You can now tell the terrible adventures " +
                        "that you lived in the Berdolock Fortress.");
                adventurer.isAlive = false;
                break;
            case 3:
                System.out.println("You fell into a hole in the ground. You " +
                        "lose 1 health point, for you hurt yourself.");
                adventurer.currentHealthPoints--;
                break;
            case 4:
                System.out.println("You were approaching an exit, but an enormous " +
                        "boulder blocks the way out.");
                break;
            case 5:
                System.out.println("A skeleton of an ancient adventurer points to " +
                        "a possible exit of the dungeon. If you roll a pair you are " +
                        "free from the Berdolock Fortress.");
                int escapeRoll = Dice.rollDice(1);
                if (escapeRoll % 2 == 0) {
                    System.out.println("You escaped!");
                    adventurer.isAlive = false;
                } else {
                    System.out.println("You didn't escape.");
                }
                break;
            case 6:
                System.out.println("Despair and hunger takes control of you. You wandered" +
                        " for days without stop and still the exit didn't appear." +
                        "\nIf you roll a 1, you will escape, else, you was just " +
                        "another victim of the dungeon.");
                int desperateRoll = Dice.rollDice(1);
                System.out.println("You rolled a: " + desperateRoll);
                if (desperateRoll == 1) {
                    System.out.println("You have escaped!");
                } else {
                    System.out.println("You were just another victim of the Dungeon.");
                }
                break;
        }
    }
}
