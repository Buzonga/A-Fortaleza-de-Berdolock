public class Adventurer extends Creature{

    Dice dice = new Dice();
    String name;
    int attackPower;
    int armourClass;
    int maxHealthPoints;
    int currentHealthPoints;
    int potionNumbers;
    int goldCoins;
    boolean isAlive = true;
    boolean magicRing = false;
    String armour;
    String sword;


    public void createAdventurer() {

        CreateName createName = new CreateName();
        String name = createName.createName();
        int attackPower = 2;
        int armourClass = 7;
        int maxHealthPoints = dice.rollDice(2);
        int currentHealthPoints = maxHealthPoints;
        int potionNumbers = 0;
        int goldCoins = 0;
        String armour =  "Chainmail and Wood Shield";
        String sword = "Sword";
        boolean isAlive = true;
        boolean magicRing = false;

        this.name = name;
        this.attackPower = attackPower;
        this.armourClass = armourClass;
        this.maxHealthPoints = maxHealthPoints;
        this.currentHealthPoints = currentHealthPoints;
        this.armour = armour;
        this.sword = sword;
        this.potionNumbers = potionNumbers;
        this.goldCoins = goldCoins;
        this.magicRing = magicRing;
        this.isAlive = isAlive;

        readAttributes();
    }

    public void readAttributes() {

        System.out.println(STR."Your adventurer name is: \{name}");
        System.out.println(STR."Attack Power: \{attackPower}d6");
        System.out.println(STR."Armor Class: \{armourClass}");
        System.out.println(STR."Max Health Points: \{maxHealthPoints}");
        System.out.println(STR."Current Health Points: \{currentHealthPoints}");

        System.out.println("Inventory:");
        System.out.println(STR."Sword: \{sword}");
        System.out.println(STR."Armour: \{armour}");
        System.out.println(STR."Potions: \{potionNumbers}");
        System.out.println(STR."Gold Coins: \{goldCoins}");
        if (magicRing) {
            System.out.println("Magic Ring");
        }
    }

    public void drinkPotion() {
        if (potionNumbers > 0) {
            if (currentHealthPoints == maxHealthPoints) {
                System.out.println("Your health is full, you don't need to" +
                        "drink a potion.");
            } else {
                System.out.println("You drink a potion, your health now is" +
                        " full");
                currentHealthPoints = maxHealthPoints;
            }
        } else if (potionNumbers == 0){
            System.out.println("You don't have any potion to drink.");
        }
    }

}

