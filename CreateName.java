import java.util.Scanner;

public class CreateName {

    public String createName() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Insert your adventurer name:");
        return scan.next() + scan.nextLine();

    }

    public CreateName() {}
}
