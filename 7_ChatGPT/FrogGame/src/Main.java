import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the grid dimension as a command-line argument.");
            return;
        }

        int dimension;
        try {
            dimension = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please provide an integer value for the grid dimension.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a frog type (1 for Regular Frog, 2 for Diagonal Frog):");
        int choice = scanner.nextInt();

        Frog frog;
        if (choice == 1) {
            frog = new Frog(new Cell(0, 0));
        } else if (choice == 2) {
            frog = new DiagFrog(new Cell(0, 0));
        } else {
            System.out.println("Invalid choice. Exiting...");
            return;
        }

        RandomWalk randomWalk = new RandomWalk();
        randomWalk.start(dimension, frog);

        System.out.println("Total number of hops: " + randomWalk.getNoOfHops());
        System.out.println("Total number of die rolls: " + randomWalk.getNoOfRolls());
        System.out.print("Path: ");
        for (int i = 0; i < randomWalk.getPath().cells.size(); i++) {
            Cell cell = randomWalk.getPath().cells.get(i);
            System.out.print("(" + cell.x + ", " + cell.y + ")");
            if (i < randomWalk.getPath().cells.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}

