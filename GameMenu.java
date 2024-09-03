import java.util.Scanner;

public class GameMenu {

    public void GameMenuOptions() {

        Scanner scan = new Scanner(System.in);
        Movement movement = new Movement();
        int turn = 1;
        boolean running = true;

        Adventurer adventurer = new Adventurer();
        adventurer.createAdventurer();

        do {
            if (!adventurer.isAlive) {
                break;
            }
            if (turn <= 30) {
                System.out.println(STR."Turn: \{turn}");
                System.out.println("""
                Chose an option:\
                \n
                1 - Movement\
                \n
                2 - Use potion\
                \n
                3 - See stats and items\
                \n
                0 - Quit game\
                """);

                int op = scan.nextInt();

                switch (op) {
                    case 1:
                        Dice dice = new Dice();
                        int roll = dice.rollDice(2);
                        movement.MovementOptions(adventurer, roll);
                        turn++;
                        break;
                    case 2:
                        adventurer.drinkPotion();
                        break;
                    case 3:
                        adventurer.readAttributes();
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            } else {

                System.out.println(STR."Turn: \{turn}");
                System.out.println("""
                Chose an option:\
                \n
                1 - Try to escape\
                \n
                2 - Use potion\
                \n
                3 - See stats and items\
                \n
                0 - Quit game\
                """);

                int op = scan.nextInt();

                switch (op) {
                    case 1:
                        Dice dice = new Dice();
                        int roll = dice.rollDice(1);
                        movement.EscapeOptions(adventurer, roll);
                        turn++;
                        break;
                    case 2:
                        adventurer.drinkPotion();
                        break;
                    case 3:
                        adventurer.readAttributes();
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }

            }

        } while (running);

    }

}
