import javax.management.MBeanRegistration;

public class Creature {

    String name;
    int attackPower;
    int armourClass;
    int maxHealthPoints;
    int currentHealthPoints;
    boolean isAlive;

    public Creature(String name, int attackPower, int armourClass, int maxHealthPoints) {
        this.name = name;
        this.attackPower = attackPower;
        this.armourClass = armourClass;
        this.maxHealthPoints = maxHealthPoints;
        this.currentHealthPoints = maxHealthPoints;
        this.isAlive = true;
    }

    public Creature() {

    }

    public Creature createMonster(Creature monster, int monsterType) {

        switch (monsterType) {
            case 1:
                monster.name = "Giant Spider";
                monster.attackPower = 3;
                monster.armourClass = 7;
                monster.maxHealthPoints = 20;
                monster.currentHealthPoints = maxHealthPoints;
                monster.isAlive = true;
                break;
            case 2:
                monster.name = "Undead";
                monster.attackPower = 2;
                monster.armourClass = 5;
                monster.maxHealthPoints = 8;
                monster.currentHealthPoints = maxHealthPoints;
                monster.isAlive = true;
                break;
            case 3:
                monster.name = "Ghost";
                monster.attackPower = 3;
                monster.armourClass = 9;
                monster.maxHealthPoints = 14;
                monster.currentHealthPoints = maxHealthPoints;
                monster.isAlive = true;
                break;
            case 4:
                monster.name = "Orc";
                monster.attackPower = 2;
                monster.armourClass = 6;
                monster.maxHealthPoints = 10;
                monster.currentHealthPoints = maxHealthPoints;
                monster.isAlive = true;
                break;
            case 5:
                monster.name = "Troll";
                monster.attackPower = 3;
                monster.armourClass = 8;
                monster.maxHealthPoints = 18;
                monster.currentHealthPoints = maxHealthPoints;
                monster.isAlive = true;
                break;
            case 6:
                monster.name = "Chaos Warrior";
                monster.attackPower = 3;
                monster.armourClass = 9;
                monster.maxHealthPoints = 16;
                monster.currentHealthPoints = maxHealthPoints;
                monster.isAlive = true;
                break;


        }
        return monster;
    }

}