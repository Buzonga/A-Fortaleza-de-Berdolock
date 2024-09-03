public class Trap {

    public String rollTrap(int roll) {

        String trap = "";

        switch (roll) {

            case 1:
                trap = "Trapdoor";
                break;
            case 2:
                trap = "Dart Rain";
                break;
            case 3:
                trap = "Acid";
                break;
            case 4:
                trap = "Arrow Rain";
                break;
            case 5:
                trap = "Gas";
                break;
            case 6:
                trap = "Roof Collapse";
        }
        return trap;
    }

    public int trapDamage(int trapRoll) {

        int damage = 0;

        switch (trapRoll) {
            case 1, 2, 5:
                damage = Dice.rollDice(1);
            case 3:
                damage = Dice.rollDice(3);
            case 4:
                damage = Dice.rollDice(2);

        }
        return damage;
    }
}
